package com.yongzh.springframework.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/31 22:41
 */
public class ClassPathXmlApplicationContext implements ApplicationContext{
    private static final Logger  logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    private Map<String,Object> singletonObject = new HashMap<>();
    /**
     * @description: 解析spring配置文件，然后初始化所有的Bean对象
     * @date: 2023/12/31 22:42
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        try {
            //解析nyspring.xml文件，然后实例化Bean,将Bean存放到singletonObject集合当中，
            SAXReader reader = new SAXReader();
            //获取一个输入流，指向配置文件
            InputStream resource = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            //读文件
            Document document = reader.read(resource);
            //获取所有的bean标签
            List<Node> nodes = document.selectNodes("//bean");
            nodes.forEach(node -> {
                try {
                    //System.out.println(node);
                    //向下转型是为了使用Element接口更加丰富的方法
                    Element beanElt = (Element) node;
                    String beanName = beanElt.attributeValue("id");
                    String className = beanElt.attributeValue("class");
                    logger.info("beanName: " + beanName);
                    logger.info("beanClassName: " + className);
                    //通过反射创建对象，将其放入Map集合中，提前曝光
                    Class<?> aClass = Class.forName(className);
                    //获取无参构造方法
                    Constructor<?> defaultConstructor = aClass.getDeclaredConstructor();
                    //调用无参构造方法实例化Bean 2024年第一行代码！！！！
                    Object bean = defaultConstructor.newInstance();
                    singletonObject.put(beanName,bean);
                    logger.info(singletonObject.toString());

                }catch (Exception e){
                    e.printStackTrace();
                }

            });

            nodes.forEach(node -> {
                try {
                    Element beanElt = (Element) node;
                    String beanName = beanElt.attributeValue("id");
                    String className = beanElt.attributeValue("class");
                    Class<?> aClass = Class.forName(className);
                    List<Element> propertys = beanElt.elements("property");
                    propertys.forEach(property ->{
                        //获取属性名
                        String propertyName = property.attributeValue("name");
                        //获取属性类型
                        try {
                            Field field = aClass.getDeclaredField(propertyName);
                            logger.info("属性名： "+propertyName);
                            String setterName = "set" + propertyName.toUpperCase().charAt(0)+propertyName.substring(1);
                            Method setMethod = aClass.getDeclaredMethod(setterName, field.getType());
                            //获取具体的值
                            String value = property.attributeValue("value");
                            String ref = property.attributeValue("ref");
                            Object propertyVal = null;
                            if (value != null) {
                                //说明是简单类型
                                String propertyTypeSimpleName = field.getType().getSimpleName();

                                switch (propertyTypeSimpleName){
                                    case "byte": case "Byte":
                                        propertyVal = Byte.valueOf(value);
                                        break;
                                    case "short": case "Short":
                                        propertyVal = Short.valueOf(value);
                                        break;
                                    case "int": case "Integer":
                                        propertyVal = Integer.valueOf(value);
                                        break;
                                    case "long": case "Long":
                                        propertyVal = Long.valueOf(value);
                                        break;
                                    case "float": case "Float":
                                        propertyVal = Float.valueOf(value);
                                        break;
                                    case "double": case "Double":
                                        propertyVal = Double.valueOf(value);
                                        break;
                                    case "boolean": case "Boolean":
                                        propertyVal = Boolean.valueOf(value);
                                        break;
                                    case "char": case "Character":
                                        propertyVal = value.charAt(0);
                                        break;
                                    case "String":
                                        propertyVal = value;
                                        break;
                                }
                                setMethod.invoke(singletonObject.get(beanName),propertyVal);
                            }
                            if(ref != null){
                                setMethod.invoke(singletonObject.get(beanName),singletonObject.get(ref));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    });

                }catch (Exception e){
                    e.printStackTrace();
                }

            });

        }catch (Exception e){
            e.printStackTrace();

        }



    }

    @Override
    public Object getBean(String beanName) {
        return singletonObject.get(beanName);
    }
}
