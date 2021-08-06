package com.wayne;

import java.util.ArrayList;
import java.util.List;

public class Demo implements Cloneable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        List<Demo> list1 = new ArrayList<>();
        Demo d1 = new Demo();
        d1.setName("zhangsan");
        d1.setAge(10);
        list1.add(d1);
        Demo d2 = new Demo();
        d2.setName("lisi");
        d2.setAge(20);
        list1.add(d2);
        Demo d3 = new Demo();
        d3.setAge(30);
        d3.setName("wangwu");
        List<Demo> list2 = new ArrayList<>();
        list2.addAll(list1);
        list2.add(d3);
        System.out.println(list2.containsAll(list1));
        System.out.println(list1);


    }
}
