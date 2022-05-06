package com.wayne.enums;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 */
@Slf4j
public class SpicinessTest {
    public static void main(String[] args) {
        // 编译器为Spiciness添加了默认的toString()方法
        log.info("{}",Spiciness.NOT);
        Spiciness.NOT.print();
        // 把常量的名字转换为常量本身
        Spiciness not = Spiciness.valueOf("NOT");
        not.print();

    }
}