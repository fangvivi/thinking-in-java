package com.wayne.design_pattern.template;

/**
 * @author wayne
 */
public class Football extends Game{
    /**
     * 初始化游戏
     */
    @Override
    void initialize() {
        System.out.println("Football game initialize! Start playing");
    }

    /**
     * 开始游戏
     */
    @Override
    void startPlay() {
        System.out.println("Football game start！Enjoy the game!");
    }

    /**
     * 结束游戏
     */
    @Override
    void endPlay() {
        System.out.println("Football game finished!");
    }
}
