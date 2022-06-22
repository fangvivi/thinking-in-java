package com.wayne.design_pattern.proxy.cglib_proxy.extend;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * 在CGLib回调时可以设置对不同方法执行不同的回调逻辑，或者根本不执行回调，
 * JDK的invocation handler没有类似的功能
 * @author wayne
 */
public class TargetCGlibFilterTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        CallbackFilter filter = new TargetMethodCallbackFilter();
        // 设置方法调用过滤器
        enhancer.setCallbackFilter(filter);
        /*
            NoOp.INSTANCE：这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
            callback1：方法拦截器
            FixedValue：表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
         */
        Callback noopCb= NoOp.INSTANCE;
        Callback callback1=new TargetInterceptor();
        Callback fixedValue=new TargetResultFixed();

        /* method1拦截，method2NoOp，method3 固定返回值*/
        Callback[] callbacks=new Callback[]{callback1,noopCb,fixedValue};

        enhancer.setCallbacks(callbacks);

        TargetObject targetObject2=(TargetObject)enhancer.create();

        System.out.println(targetObject2);
        System.out.printf("method1：%s%n",targetObject2.method1("mmm1"));
        System.out.printf("method2：%s%n",targetObject2.method2(100));
        System.out.printf("method3：%s%n",targetObject2.method3(100));
        System.out.printf("method3：%s%n",targetObject2.method3(200));
    }
}
