package org.jfree.ui;

import java.awt.geom.*;
import java.io.*;

public class FloatDimension extends Dimension2D implements Serializable
{
    private static final long serialVersionUID = 5367882923248086744L;
    private float width;
    private float height;
    
    public FloatDimension() {
        this.width = 0.0f;
        this.height = 0.0f;
    }
    
    public FloatDimension(final FloatDimension floatDimension) {
        this.width = floatDimension.width;
        this.height = floatDimension.height;
    }
    
    public FloatDimension(final float width, final float height) {
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public void setWidth(final double n) {
        this.width = (float)n;
    }
    
    public void setHeight(final double n) {
        this.height = (float)n;
    }
    
    public void setSize(final double n, final double n2) {
        this.setHeight((float)n2);
        this.setWidth((float)n);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public String toString() {
        return this.getClass().getName() + ":={width=" + this.getWidth() + ", height=" + this.getHeight() + "}";
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FloatDimension)) {
            return false;
        }
        final FloatDimension floatDimension = (FloatDimension)o;
        return this.height == floatDimension.height && this.width == floatDimension.width;
    }
    
    public int hashCode() {
        return 29 * Float.floatToIntBits(this.width) + Float.floatToIntBits(this.height);
    }
}
