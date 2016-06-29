package org.jfree.ui;

import java.io.*;
import org.jfree.util.*;

public class Size2D implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 2558191683786418168L;
    public double width;
    public double height;
    
    public Size2D() {
        this(0.0, 0.0);
    }
    
    public Size2D(final double width, final double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public void setWidth(final double width) {
        this.width = width;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public void setHeight(final double height) {
        this.height = height;
    }
    
    public String toString() {
        return "Size2D[width=" + this.width + ", height=" + this.height + "]";
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Size2D)) {
            return false;
        }
        final Size2D size2D = (Size2D)o;
        return this.width == size2D.width && this.height == size2D.height;
    }
    
    public Object clone() {
        return super.clone();
    }
}
