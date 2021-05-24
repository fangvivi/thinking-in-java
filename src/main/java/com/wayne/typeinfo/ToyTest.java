package com.wayne.typeinfo;


import static com.wayne.utils.Print.print;

/**
 * @author wayne
 */
public class ToyTest {
    public static void printInfo(Class c){
        print("Class name: "+c.getName()+" is Interface? "+"["+c.isInterface()+"]");
        print("Simple name: "+c.getSimpleName());
        print("Canonical name: "+c.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.wayne.typeinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            print("can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class superclass = c.getSuperclass();
        Object obj = null;
        try {
            obj = superclass.newInstance();
        } catch (InstantiationException e) {
            print("can't instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("can't access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
class Toy{
    // Toy(){}
    Toy(int i){}
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots {
    FancyToy() { super(1); }
}

    /*
    输出：
    Class name: com.wayne.typeinfo.FancyToy is Interface? [false]
    Simple name: FancyToy
    Canonical name: com.wayne.typeinfo.FancyToy
    Class name: com.wayne.typeinfo.HasBatteries is Interface? [true]
    Simple name: HasBatteries
    Canonical name: com.wayne.typeinfo.HasBatteries
    Class name: com.wayne.typeinfo.Waterproof is Interface? [true]
    Simple name: Waterproof
    Canonical name: com.wayne.typeinfo.Waterproof
    Class name: com.wayne.typeinfo.Shoots is Interface? [true]
    Simple name: Shoots
    Canonical name: com.wayne.typeinfo.Shoots
    Class name: com.wayne.typeinfo.Toy is Interface? [false]
    Simple name: Toy
    Canonical name: com.wayne.typeinfo.Toy
    */


    /*
    Exercise 1 输出：
    Class name: com.wayne.typeinfo.FancyToy is Interface? [false]
    Simple name: FancyToy
    Canonical name: com.wayne.typeinfo.FancyToy
    Class name: com.wayne.typeinfo.HasBatteries is Interface? [true]
    Simple name: HasBatteries
    Canonical name: com.wayne.typeinfo.HasBatteries
    Class name: com.wayne.typeinfo.Waterproof is Interface? [true]
    Simple name: Waterproof
    Canonical name: com.wayne.typeinfo.Waterproof
    Class name: com.wayne.typeinfo.Shoots is Interface? [true]
    Simple name: Shoots
    Canonical name: com.wayne.typeinfo.Shoots
    can't instantiate
    */