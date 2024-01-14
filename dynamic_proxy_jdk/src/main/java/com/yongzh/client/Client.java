package com.yongzh.client;

import com.yongzh.proxy.service.OrderService;
import com.yongzh.proxy.service.OrderServiceImpl;
import com.yongzh.proxy.service.TimerInvocationHandler;
import com.yongzh.proxy.util.ProxyUtil;

import java.lang.reflect.Proxy;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/1/5 12:27
 */
public class Client {
    public static void main(String[] args) {
        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        /**
         * @description:1.newProxyInstance翻译为：新建代理对象
         * 也就是说，通过调用这个方法可以创建代理付象
         * 本质上，这个Proxy.newProxyI行stance()方法的执行，做了两件事
         * 第一件事：在内存中动态的生成了一个代理类的字节码class。
         * 第二件事：neW对象了。通过内存中生成的代理类这个代码，实例化了代理对象。
         * 2.关于newProxyInstance()方法的三个重要的参数，每一个什么含义，有什么用？
         *  第一个参数：ClassLoader loader
         *  类加载器。这个类加载有什么用呢
         *  在内存当中生成的字节码也是class文件，要执行也得先加载到内存当中，加载类需要类加载器，所以这里需要指定类加载器，
         *  并且JDK要求，目标类的类加载器必须和代理类的类加我器使用同一个。
         *   第二个参数：Class<?>[]interfaces
         *  代理类和目标类实现同一个接口或同些接口。
         *  在内存中生成代理类的时候，这个代理类是需要你告诉它实现哪些接口的
        第三个参数：InvocationHandler h
            InvocationHandler被翻译为：调用处理器。是一个接口.
            在调用处理器接口中编写的就是：增强代码。
            因为具体要增强什么代码，JDK动态代理技术它是猜不到的。没有那么神。
            既然是接口，就要写接口的实现类。
            可能会有疑问？
            自己还要动手写调用处理器接口的实现类，这不会类爆炸吗？不会。
            因为这种调用处理器写一次就好。
            注意：代理对象和目标对象实现的接口一样，所以可以向下转型。
         */
 /*       OrderService orderServiceProxy = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));*/
        OrderService orderServiceProxy = (OrderService) ProxyUtil.newProxyInstance(target);
        // 调用代理对象的代理方法
        orderServiceProxy.detail();
        orderServiceProxy.modify();
        orderServiceProxy.generate();
        System.out.println(orderServiceProxy.getName());
    }
}
