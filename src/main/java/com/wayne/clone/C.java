package com.wayne.clone;

public class C {
    private String name;

    public C(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "C{" +
                "name='" + name + '\'' +
                '}';
    }
}
