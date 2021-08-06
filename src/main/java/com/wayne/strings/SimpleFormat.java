package com.wayne.strings;

public class SimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y = 5.332434;
        System.out.println("Row 1: [" + x + " " + y + "]");
        // 下面两种方式是相同的
        System.out.format("Row 1: [%d %f]\n",x,y);
        System.out.printf("Row 1: [%d %f]\n",x,y);
    }
}

/**
 * Row 1: [5 5.332434]
 * Row 1: [5 5.332434]
 * Row 1: [5 5.332434]
 */
