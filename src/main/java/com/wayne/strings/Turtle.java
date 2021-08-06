package com.wayne.strings;

import java.io.PrintStream;
import java.util.Formatter;

public class Turtle {
    private String name;
    private Formatter f;

    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y){
        f.format("%s The Turtle is at (%d,%d)\n",name,x,y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        Turtle zhangsan = new Turtle("ZhangSan",new Formatter(outAlias));
        Turtle lisi = new Turtle("LiSi",new Formatter(outAlias));
        zhangsan.move(1,2);
        zhangsan.move(3,2);
        lisi.move(4,9);
    }
}
/**
 * ZhangSan The Turtle is at (1,2)
 * ZhangSan The Turtle is at (3,2)
 * LiSi The Turtle is at (4,9)
 * */