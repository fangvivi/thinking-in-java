package com.wayne.strings.exercise;

import java.math.BigInteger;
import java.util.Formatter;

/**
 ****************** Exercise 5 ******************
 * For each of the basic conversion types in the
 * above table, write the most complex formatting
 * expression possible. That is, use all the
 * possible format specifiers available for that
 * conversion type.
 ***********************************************
 * @author wayne
 */
public class StringExercise5 {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);
        char u = 'a';
        // u = 'a'
        System.out.println("u = 'a'");
        // s: a         , 末尾有9个空格
        f.format("s: %1$-10s\n", u);
        // c: a         , 末尾有9个空格
        f.format("c: %1$-10c\n", u);
        // b: true      , 末尾有6个空格
        f.format("b: %1$-10.10b\n", u);
        // h: 61        , 末尾有8个空格
        f.format("h: %1$-10.10h\n", u);

        int v = 1000;
        // v = 1000
        System.out.println("v = 1000");
        // d 1: +00001,000
        // "("表示把负数部分用小括号括住；","表示1,000；
        // "0"表示用0补位；"+"表示输出正负号
        f.format("d 1: %1$(,0+10d\n", v);
        // d 2:  1,000    ;1前面一个空格，末尾4个空格
        f.format("d 2: %1$-(, 10d\n", v);
        // d 3, v = -v: (1,000)   ;末尾3个空格
        f.format("d 3, v = -v: %1$-(, 10d\n", -v);
        // c, v = 121: y         ;末尾9个空格
        f.format("c, v = 121: %1$-10c\n", 121);
        // b: true      ;末尾6个空格
        f.format("b: %1$-10.10b\n", v);
        // s: 1000      ;末尾6个空格
        f.format("s: %1$-10.10s\n", v);
        // x: 0x3e8     ;末尾5个空格
        // "#"表示8进制前面加0,16进制前面加0x;
        f.format("x: %1$-#10x\n", v);
        // h: 3e8       ;末尾加7个空格
        // "h"表示参数的hashcode转换为16进制
        f.format("h: %1$-10.10h\n", v);

        double x = -179.543;
        // x = -179.543
        System.out.println("x = -179.543");
        // b: true      , 末尾加6个空格
        f.format("b: %1$-10.10b\n", x);
        // s: -179.543  ,末尾加2个空格
        f.format("s: %1$-10.10s\n", x);
        // f 1: (0179.543)，"("会把负数部分用括号括住
        f.format("f 1: %1$#+(,010.3f\n", x);
        // f 2: (179.54)  ;末尾加2个空格
        f.format("f 2: %1$#(,- 10.2f\n", x);
        // f 3, x = -x: +000179.54
        f.format("f 3, x = -x: %1$#(,0+10.2f\n", -x);
        // e 1: (1.80e+02)
        f.format("e 1: %1$#(0+10.2e\n", x);
        // e 2: (1.80e+02)
        f.format("e 2: %1$#(- 10.2e\n", x);
        // e 3, x = -x: +01.80e+02
        f.format("e 3, x = -x: %1$#(0+10.2e\n", -x);
        // h: 81ef462c  ;末尾2个0
        f.format("h: %1$-10.10h\n", x);

        BigInteger w = new BigInteger("50000000000000");
        // w = new BigInteger("50000000000000")
        System.out.println("w = new BigInteger(\"50000000000000\")");
        // d 1: +50,000,000,000,000
        f.format("d 1: %1$(,0+10d\n", w);
        // d 2:  50,000,000,000,000；头部有一个空格
        f.format("d 2: %1$-(, 10d\n", w);
        // d 3, w = -w: (50,000,000,000,000)；头部有一个空格
        f.format("d 3, w = -w: %1$-(, 10d\n", w.negate());
        // b: true      ;末尾加6个空格
        f.format("b: %1$-10.10b\n", w);
        // s: 5000000000
        f.format("s: %1$-10.10s\n", w);
        // x 1: +2d79883D2000
        f.format("x 1: %1$(0+10x\n", w);
        // x 2:  2d79883D2000
        f.format("x 2: %1$-( 10x\n", w);
        // x 3, w = -w: (2d79883D2000)
        f.format("x 3, w = -w: %1$-( 10x\n", w.negate());
        // h: 8842a1a7  ;末尾加2个0
        f.format("h: %1$-10.10h\n", w);

        Object y = new Object();
        // y = new Object()
        System.out.println("y = new Object()");
        // b: true      ;末尾加6个空格
        f.format("b: %1$-10.10b\n", y);
        // s: java.lang.
        f.format("s: %1$-10.10s\n", y);
        // h: 1540e19d  ;末尾加2个空格
        f.format("h: %1$-10.10h\n", y);

        boolean z = false;
        // z = false
        System.out.println("z = false");
        // b: false     ;末尾加5个空格
        f.format("b: %1$-10.10b\n", z);
        // s: false     ;末尾加5个空格
        f.format("s: %1$-10.10s\n", z);
        // h: 4d5       ;末尾加7个空格
        f.format("h: %1$-10.10h\n", z);
        // %: %
        f.format("%%: %-10%");

    }
}
