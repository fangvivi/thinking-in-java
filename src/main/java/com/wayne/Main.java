package com.wayne;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
@Slf4j
public class Main {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("60");
        BigDecimal b = new BigDecimal("80");
        BigDecimal subtract = a.max(b).subtract(a.min(b));
        log.info("结果【{}】",subtract.toString());
    }
}
