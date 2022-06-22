package com.wayne.design_pattern.template;

/**
 * 模板方法模式，属于行为设计模式，在父类中声明一个算法的框架，
 * 比如声明一个非抽象的方法，里面按照特定的顺序调用其他抽象的方法，
 * 让子类在不修改方法结构的基础上，可以重写具体的步骤
 * @author wayne
 */
public abstract class Game {
    /**
     * 初始化游戏
     */
    abstract void initialize();

    /**
     * 开始游戏
     */
    abstract void startPlay();

    /**
     * 结束游戏
     */
    abstract void endPlay();

    /**
     * 模板
     */
    public void play(){
        initialize();
        startPlay();
        endPlay();
    }
}
