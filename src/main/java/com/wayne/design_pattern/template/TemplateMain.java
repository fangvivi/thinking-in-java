package com.wayne.design_pattern.template;

/**
 * 模板模式
 * @author wayne
 */
public class TemplateMain {
    public static void main(String[] args) {
        Game game = new Basketball();
        game.play();

        game = new Football();
        game.play();

    }
}
