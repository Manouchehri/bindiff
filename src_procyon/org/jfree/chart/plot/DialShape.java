package org.jfree.chart.plot;

import java.io.*;

public final class DialShape implements Serializable
{
    private static final long serialVersionUID = -3471933055190251131L;
    public static final DialShape CIRCLE;
    public static final DialShape CHORD;
    public static final DialShape PIE;
    private String name;
    
    private DialShape(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof DialShape && this.name.equals(((DialShape)o).toString()));
    }
    
    private Object readResolve() {
        if (this.equals(DialShape.CIRCLE)) {
            return DialShape.CIRCLE;
        }
        if (this.equals(DialShape.CHORD)) {
            return DialShape.CHORD;
        }
        if (this.equals(DialShape.PIE)) {
            return DialShape.PIE;
        }
        return null;
    }
    
    static {
        CIRCLE = new DialShape("DialShape.CIRCLE");
        CHORD = new DialShape("DialShape.CHORD");
        PIE = new DialShape("DialShape.PIE");
    }
}
