package org.jfree.ui;

import java.io.*;

public final class GradientPaintTransformType implements Serializable
{
    private static final long serialVersionUID = 8331561784933982450L;
    public static final GradientPaintTransformType VERTICAL;
    public static final GradientPaintTransformType HORIZONTAL;
    public static final GradientPaintTransformType CENTER_VERTICAL;
    public static final GradientPaintTransformType CENTER_HORIZONTAL;
    private String name;
    
    private GradientPaintTransformType(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof GradientPaintTransformType && this.name.equals(((GradientPaintTransformType)o).name));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    private Object readResolve() {
        Object o = null;
        if (this.equals(GradientPaintTransformType.HORIZONTAL)) {
            o = GradientPaintTransformType.HORIZONTAL;
        }
        else if (this.equals(GradientPaintTransformType.VERTICAL)) {
            o = GradientPaintTransformType.VERTICAL;
        }
        else if (this.equals(GradientPaintTransformType.CENTER_HORIZONTAL)) {
            o = GradientPaintTransformType.CENTER_HORIZONTAL;
        }
        else if (this.equals(GradientPaintTransformType.CENTER_VERTICAL)) {
            o = GradientPaintTransformType.CENTER_VERTICAL;
        }
        return o;
    }
    
    static {
        VERTICAL = new GradientPaintTransformType("GradientPaintTransformType.VERTICAL");
        HORIZONTAL = new GradientPaintTransformType("GradientPaintTransformType.HORIZONTAL");
        CENTER_VERTICAL = new GradientPaintTransformType("GradientPaintTransformType.CENTER_VERTICAL");
        CENTER_HORIZONTAL = new GradientPaintTransformType("GradientPaintTransformType.CENTER_HORIZONTAL");
    }
}
