package org.jfree.ui;

import java.io.*;

public final class HorizontalAlignment implements Serializable
{
    private static final long serialVersionUID = -8249740987565309567L;
    public static final HorizontalAlignment LEFT;
    public static final HorizontalAlignment RIGHT;
    public static final HorizontalAlignment CENTER;
    private String name;
    
    private HorizontalAlignment(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof HorizontalAlignment && this.name.equals(((HorizontalAlignment)o).name));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    private Object readResolve() {
        Object o = null;
        if (this.equals(HorizontalAlignment.LEFT)) {
            o = HorizontalAlignment.LEFT;
        }
        else if (this.equals(HorizontalAlignment.RIGHT)) {
            o = HorizontalAlignment.RIGHT;
        }
        else if (this.equals(HorizontalAlignment.CENTER)) {
            o = HorizontalAlignment.CENTER;
        }
        return o;
    }
    
    static {
        LEFT = new HorizontalAlignment("HorizontalAlignment.LEFT");
        RIGHT = new HorizontalAlignment("HorizontalAlignment.RIGHT");
        CENTER = new HorizontalAlignment("HorizontalAlignment.CENTER");
    }
}
