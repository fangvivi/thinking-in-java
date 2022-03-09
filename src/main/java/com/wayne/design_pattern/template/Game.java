package com.wayne.design_pattern.template;

/**
 * 模板模式
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
