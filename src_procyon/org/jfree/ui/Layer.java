package org.jfree.ui;

import java.io.*;

public final class Layer implements Serializable
{
    private static final long serialVersionUID = -1470104570733183430L;
    public static final Layer FOREGROUND;
    public static final Layer BACKGROUND;
    private String name;
    
    private Layer(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof Layer && this.name.equals(((Layer)o).name));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    private Object readResolve() {
        Object o = null;
        if (this.equals(Layer.FOREGROUND)) {
            o = Layer.FOREGROUND;
        }
        else if (this.equals(Layer.BACKGROUND)) {
            o = Layer.BACKGROUND;
        }
        return o;
    }
    
    static {
        FOREGROUND = new Layer("Layer.FOREGROUND");
        BACKGROUND = new Layer("Layer.BACKGROUND");
    }
}
