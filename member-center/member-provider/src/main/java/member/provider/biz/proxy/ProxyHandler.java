package member.provider.biz.proxy;

import member.provider.biz.proxy.impl.ProxyServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 * jdk动态代理类需要实现InvocationHandler 接口并从新invoke方法
 */
public class ProxyHandler implements InvocationHandler {


    //被代理的类对象
    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy
     *         代理类
     * @param method
     *          方法
     * @param args
     *          参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        //目标放执行前  ==== 做额外的事情  日志 事务权限控制。。。
        System.out.println("进入代理类的处理逻辑-----");

        //调用执行被代理对象的方法
        method.invoke(target, args);

        //执行后
        System.out.println("后处理逻辑-----");

        return null;
//
//        ProxyHandler proxyHandler = new ProxyHandler(new ProxyServiceImpl());
//        //获取ProxyTestImpl类的代理对象
//        ProxyService proxy =  (ProxyService)Proxy.newProxyInstance(ProxyHandler.class.getClassLoader(),new Class[]{ProxyService.class},proxyHandler);
//        proxy.test();
    }

    public static void main(String[] args) {
        ProxyHandler proxyHandler = new ProxyHandler(new ProxyServiceImpl());
        //获取ProxyTestImpl类的代理对象
        ProxyService proxy =  (ProxyService)Proxy.newProxyInstance(ProxyHandler.class.getClassLoader(),new Class[]{ProxyService.class},proxyHandler);
        proxy.test();

    }
}
