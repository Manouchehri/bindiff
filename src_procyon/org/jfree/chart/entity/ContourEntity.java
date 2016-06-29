package org.jfree.chart.entity;

import java.io.*;
import java.awt.*;

public class ContourEntity extends ChartEntity implements Serializable, Cloneable
{
    private static final long serialVersionUID = 1249570520505992847L;
    private int index;
    
    public ContourEntity(final Shape shape, final String s) {
        super(shape, s);
        this.index = -1;
    }
    
    public ContourEntity(final Shape shape, final String s, final String s2) {
        super(shape, s, s2);
        this.index = -1;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public void setIndex(final int index) {
        this.index = index;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof ContourEntity && super.equals(o) && this.index == ((ContourEntity)o).index);
    }
    
    public Object clone() {
        return super.clone();
    }
}
