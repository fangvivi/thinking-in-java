package com.wayne.design_pattern.observer;

/**
 * @author wayne
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
