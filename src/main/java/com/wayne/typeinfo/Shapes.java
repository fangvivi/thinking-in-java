package com.wayne.typeinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wayne
 */
public class Shapes {
    public static void main(String[] args) {
        List<Shape> list = new ArrayList<>();
        list.add(new Circle());
        list.add(new Square());
        list.add(new Triangle());
        for (Shape s : list) {
            s.draw();
        }
    }
}

/**
输出：
Circle.draw()
Square.draw()
Triangle.draw()
*/
abstract class Shape{
    void draw(){
        // this后面跟着+，表示当前对象的toString()会被自动调用
        System.out.println(this + "draw()");
    }
    @Override
    abstract public String toString();
}

class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle.";
    }

}

class Square extends Shape {

    @Override
    public String toString() {
        return "Square.";
    }
}

class Triangle extends Shape {

    @Override
    public String toString() {
        return "Triangle.";
    }
}