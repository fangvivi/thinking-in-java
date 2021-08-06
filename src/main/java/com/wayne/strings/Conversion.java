package com.wayne.strings;

import java.math.BigInteger;
import java.util.Formatter;

public class Conversion {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);
        char u = 'a';
        System.out.println("u = 'a'");
        // 字符串 s: a
        f.format("s: %s\n",u);
        // f.format("d: %d\n",u); 十进制整数
        // unicode字符 c: a
        f.format("c: %c\n",u);
        // 布尔值 b: true
        f.format("b: %b\n",u);
        // f.format("f: %f\n",u); 十进制浮点数
        // f.format("x: %x\n",u); 整数16进制
        // f.format("e: %e\n",u); 科学记数的浮点数
        // 散列码 h: 61
        f.format("h: %h\n",u);

        int v = 123;
        System.out.println("v = 123");
        // d: 123
        f.format("d: %d\n",v);
        // c: {
        f.format("c: %c\n",v);
        // b: true
        f.format("b: %b\n",v);
        // s: 123
        f.format("s: %s\n",v);
        // x: 7b 123转换为16进制
        f.format("x: %x\n",v);
        // h: 7b
        f.format("h: %h\n",v);

        BigInteger w = new BigInteger("50000000000000");
        System.out.println(
                "w = new BigInteger(\"50000000000000\")");
        // d: 50000000000000
        f.format("d: %d\n",w);
        // b: true
        f.format("b: %b\n",w);
        // s: 50000000000000
        f.format("s: %s\n",w);
        // x: 2d79883D2000
        f.format("x: %x\n",w);
        // h: 8842a1a7
        f.format("h: %h\n",w);

        double x = 179.432;
        System.out.println("x = 179.432");
        // b: true
        f.format("b: %b\n",x);
        // s: 179.432
        f.format("s: %s\n",x);
        // f: 179.432000 默认保留6位小数
        f.format("f: %f\n",x);
        // e: 1.794320e+02
        f.format("e: %e\n",x);
        //h: b1cf9635
        f.format("h: %h\n",x);

        Conversion y = new Conversion();
        System.out.println("y = new Conversion()");
        // b: true
        f.format("b: %b\n",y);
        // s: com.wayne.strings.Conversion@5cad8086
        f.format("s: %s\n",y);
        // h: 5cad8086
        f.format("h: %h\n",y);

        boolean z = false;
        System.out.println("z = false");
        // z: false
        f.format("b: %b\n", z);
        // s: false
        f.format("s: %s\n", z);
        // h: 4d5
        f.format("h: %h\n", z);



    }
}
