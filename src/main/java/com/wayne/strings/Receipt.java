package com.wayne.strings;

import java.util.Formatter;

public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    public void printTitle() {
        f.format("%-18s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-18s %5s %10s\n", "----", "---", "-----");
    }
    public void print(String name, int qty, double price) {
        f.format("%-18.17s %5d %10.2f\n", name, qty, price);
        total += price;
    }
    public void printTotal() {
        f.format("%-18s %5s %10.2f\n", "Tax", "", total*0.06);
        f.format("%-18s %5s %10s\n", "", "", "-----");
        f.format("%-18s %5s %10.2f\n", "Total", "",
                total * 1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("zhangSan's apples", 4, 4.25);
        receipt.print("LiSi's bananas", 3, 5.1);
        receipt.print("WangWu's pears", 1, 14.29);
        receipt.printTotal();
    }
}
/**
 * Item                 Qty      Price
 * ----                 ---      -----
 * zhangSan's apples      4       4.25
 * LiSi's bananas         3       5.10
 * WangWu's pears         1      14.29
 * Tax                            1.42
 *                               -----
 * Total                         25.06
 *
 *
 *
 *
 */
