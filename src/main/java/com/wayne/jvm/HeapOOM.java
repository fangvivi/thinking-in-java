package com.wayne.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟堆内存OOM VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author wayne
 */
public class HeapOOM {

    static class OOMObject {
    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
