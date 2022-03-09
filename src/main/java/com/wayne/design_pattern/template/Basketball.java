package com.wayne.design_pattern.template;

/**
 * @author wayne
 */
public class Basketball extends Game{
    /**
     * 初始化游戏
     */
    @Override
    void initialize() {
        System.out.println("Basketball game initialize! Start playing");
    }

    /**
     * 开始游戏
     */
    @Override
    void startPlay() {
        System.out.println("Basketball game start！Enjoy the game!");
    }

    /**
     * 结束游戏
     */
    @Override
    void endPlay() {
        System.out.println("Basketball game finished!");
    }
}
