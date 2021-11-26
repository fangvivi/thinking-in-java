package com.wayne.enums;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 */
@Slf4j
public class SpicinessTest {
    public static void main(String[] args) {
        // 编译器为Spiciness添加了默认的toString()方法
        log.info("{}",Spiciness.HOT);
        Spiciness[] values = Spiciness.values();
        try {
            for (Spiciness value : values) {
                log.info("{}",value);
                throw new  RuntimeException("测试日志");
            }
        } catch (Exception e) {
            // e.printStackTrace();
            // log.error("异常",e);
            log.error("异常【{}】",e.getMessage(),e);
        }

    }
}