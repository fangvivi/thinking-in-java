package com.wayne.clone;

import java.util.Objects;

public class A implements Cloneable{
    private B b;
    private C c;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        A a = (A) o;
        return Objects.equals(b, a.b) && Objects.equals(c, a.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(b, c);
    }

    @Override
    protected A clone() throws CloneNotSupportedException {
        return (A)super.clone();
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                ", c=" + c +
                '}';
    }
}
