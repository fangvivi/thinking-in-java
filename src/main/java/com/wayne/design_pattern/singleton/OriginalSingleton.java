package com.wayne.design_pattern.singleton;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 饿汉式单例模式
 * @author wayne
 */
public class OriginalSingleton implements Serializable {
    private static final OriginalSingleton SINGLETON = new OriginalSingleton();

    /**
     * 可以通过反射来调用这个方法
     */
    private OriginalSingleton() {
        if(SINGLETON != null){
            // 防止通过反射直接构造对象
            throw new RuntimeException("已经存在一个OriginalSingleton的实例");
        }
    }

    public OriginalSingleton getSingletonInstance(){
        return SINGLETON;
    }

    /**
     * 如果单例类实现了序列化接口，反序列化之后，这个方法会被调用，
     * 返回单例实例，从而取代新创建的对象
     */
    public Object readResolve(){
        return SINGLETON;
    }

    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        Class<OriginalSingleton> clz = OriginalSingleton.class;
        // 利用反射获取无参构造函数
        Constructor<OriginalSingleton> noArgsConstructor
                = clz.getDeclaredConstructor(null);
        // 试私有构造方法可被调用
        noArgsConstructor.setAccessible(true);
        OriginalSingleton originalSingleton
                = noArgsConstructor.newInstance(null);
    }
}
