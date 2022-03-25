package com.wayne.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wayne
 */
public class Pet {
}

class Cat extends Pet{

}

class ExtendsDemo{
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        List<? extends Pet> pets = cats;
        Pet pet = pets.get(0);
    }
}




