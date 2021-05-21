package com.wayne.typeinfo;

import static com.wayne.utils.Print.print;


class Candy {
    static { print("Loading Candy"); }
}

class Pi {
    static { print("Loading Pi"); }
}

class Cookie {
    static { print("Loading Cookie"); }
}

/**
 * @author wayne
 */
public class SweetShop {
    public static void main(String[] args) {
        print("main method");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("com.wayne.typeinfo.Pi");
        } catch(ClassNotFoundException e) {
            print("Couldn't find Pi");
        }
        print("After Class.forName(\"Pi\")");
        new Cookie();
        print("After creating Cookie");
    }
}

    /*
    输出：
    main method
    Loading Candy
    After creating Candy
    Loading Pi
    After Class.forName("Pi")
    Loading Cookie
    After creating Cookie
    */