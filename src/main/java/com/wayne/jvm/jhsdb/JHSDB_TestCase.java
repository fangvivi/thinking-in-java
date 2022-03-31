package com.wayne.jvm.jhsdb;

import org.omg.CORBA.ObjectHolder;

/**
 * -Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
 * staticObj、instanceObj、localObj这三个变量本身（而不是它们所指向的对象）存放在哪里
 * JHSDB测试代码
 *
 * @author wayne
 */
public class JHSDB_TestCase {
    static class Test {
        // staticObj 随着Test的类型信息存放在方法区中
        static ObjectHolder staticObj = new ObjectHolder();
        // instanceObj 随着Test对象的实例存放在堆中
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            // localObj存放在方法foo栈帧的局部变量表中
            ObjectHolder localObj = new ObjectHolder();
            // 这里设一个断点
            System.out.println("done");
        }
        private static class ObjectHolder {}
        public static void main(String[] args) {
            Test test = new JHSDB_TestCase.Test();
            test.foo();
        }
    }
}
