package com.wayne.strings.exercise;

import java.util.Formatter;

/**
 * ****************** Exercise 4 ******************
 * Modify Receipt.java so that the widths are all
 * controlled by a single set of constant values.
 * The goal is to allow you to easily change a
 * width by changing a single value in one place.
 */
public class StringExercise4 {
    private double total = 0;
    public static final int ITEM_WIDTH = 18;
    public static final int QTY_WIDTH = 5;
    public static final int PRICE_WIDTH = 10;

    // "%-18s %5s %10s\n"
    private static final String TITLE_FRMT =
            "%-" + ITEM_WIDTH + "s %" + QTY_WIDTH + "s %" +
                    PRICE_WIDTH + "s\n";
    private static final String ITEM_FRMT =
            "%-" + ITEM_WIDTH + "." + ITEM_WIDTH + "s %" +
                    QTY_WIDTH + "d %" + PRICE_WIDTH + ".2f\n";
    private static final String TOTAL_FRMT =
            "%-" + ITEM_WIDTH + "s %" + QTY_WIDTH + "s %" +
                    PRICE_WIDTH + ".2f\n";


    private Formatter f = new Formatter(System.out);

    public void printTitle() {
        f.format(TITLE_FRMT, "Item", "Qty", "Price");
        f.format(TITLE_FRMT, "----", "---", "-----");
    }
    public void print(String name, int qty, double price) {
        f.format(ITEM_FRMT, name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format(TOTAL_FRMT, "Tax", "", total*0.06);
        f.format(TITLE_FRMT, "", "", "-----");
        f.format(TOTAL_FRMT, "Total", "",
                total * 1.06);
    }

    public static void main(String[] args) {
        StringExercise4 receipt = new StringExercise4();
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
 */
