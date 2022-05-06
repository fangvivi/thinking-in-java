package com.wayne.enums;

/**
 * 辣度的枚举
 * @author wayne
 */

public enum Spiciness {
    /**
     * 不辣
     */
    NOT{
        @Override
        public void print(){
            System.out.println("这个不辣");
        }
    },
    /**
     * 微辣
     */
    MILD {
        @Override
        public void print() {
            System.out.println("微微辣");
        }
    },
    /**
     * 中辣
     */
    MEDIUM {
        @Override
        public void print() {
            System.out.println("有点辣");
        }
    },
    /**
     * 特辣
     */
    HOT {
        @Override
        public void print() {
            System.out.println("挺辣的");
        }
    },
    /**
     * 魔鬼辣
     */
    FLAMING {
        @Override
        public void print() {
            System.out.println("超级辣");
        }
    };

    /**
     * 枚举类型的抽象方法必须被所有的枚举常量重写
     */
    public abstract void print();


}
