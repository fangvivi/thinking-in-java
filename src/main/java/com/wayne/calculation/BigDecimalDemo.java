package com.wayne.calculation;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("3");
        BigDecimal divide1 = a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal divide2 = a.divide(b,3,4).setScale(2,4);
        log.info("divide1【{}】",divide1);
        log.info("divide2【{}】",divide2);
    }
}
