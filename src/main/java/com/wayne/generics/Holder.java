package com.wayne.generics;

import java.util.Objects;

public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T val) {
        value = val;
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Holder &&
                Objects.equals(value, ((Holder) o).value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);

        //Holder<Fruit> fruit = apple;
        Holder<? extends Fruit> fruit = apple;
        //fruit.set(new Apple());
        Fruit p = fruit.get();
        d = (Apple)fruit.get();
        try {
            Orange o = (Orange)fruit.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Holder<? super Apple> apples = apple;
        apples.set(new Apple());
        apples.get();

        System.out.println(fruit.equals(d));
    }
}
