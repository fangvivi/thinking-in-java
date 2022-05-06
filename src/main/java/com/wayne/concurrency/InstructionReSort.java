package com.wayne.concurrency;

/**
 * 演示指令重排序
 * 正常情况下，x 和 y不会同时等于0，除非发生指令重排序。
 * 在这种情况下，x = b对应的指令先于a = 1执行完，y = a对应的指令先于b = 1执行完
 * @author wayne
 */
public class InstructionReSort {

    private static int x = 0;
    private static int y = 0;
    private static int a = 0;
    private static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            //开两个线程，第一个线程执行a=1，x=b;第二个线程执行b=1，y=a
            Thread t1 = new Thread(() -> {
                    //线程1会比线程2先执行，因此用nanoTime让线程1等待线程2  0.01毫秒
                    shortWait(10000);
                    a = 1;
                    x = b;

            },"t1");

            Thread t2 = new Thread(() ->  {
                    b = 1;
                    y = a;
            }, "t2");

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            //等两个线程都执行完毕后拼接结果
            String result = "第" + i + "次执行，x=" + x + "，y=" + y;
            //如果x=0且y=0，则跳出循环
            if (x == 0 && y == 0) {
                System.out.println(result);
                break;
            }
        }
    }

    /**
     * 等待interval纳秒
     * @param interval 等待的纳秒数
     */
    private static void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }
}
