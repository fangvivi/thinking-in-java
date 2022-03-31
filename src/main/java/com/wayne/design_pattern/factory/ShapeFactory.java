package com.wayne.design_pattern.factory;

/**
 * @author wayne
 */
public class ShapeFactory {

    /**
     * 创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。
     */
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if (shapeType.equals("CIRCLE")){
            return new Circle();
        } else if(shapeType.equals("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equals("SQUARE")){
            return new Square();
        }
        return null;
    }

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("CIRCLE");
        if (circle == null) {
            circle.draw();
        }

        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        if (rectangle == null) {
            rectangle.draw();
        }

        Shape square = shapeFactory.getShape("SQUARE");
        if (square == null) {
            square.draw();
        }

    }
}
