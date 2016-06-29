package org.jfree.data.xy;

import java.io.*;
import org.jfree.util.*;

public class XYDataItem implements Serializable, Cloneable, Comparable
{
    private static final long serialVersionUID = 2751513470325494890L;
    private Number x;
    private Number y;
    
    public XYDataItem(final Number x, final Number y) {
        if (x == null) {
            throw new IllegalArgumentException("Null 'x' argument.");
        }
        this.x = x;
        this.y = y;
    }
    
    public XYDataItem(final double n, final double n2) {
        this(new Double(n), new Double(n2));
    }
    
    public Number getX() {
        return this.x;
    }
    
    public Number getY() {
        return this.y;
    }
    
    public void setY(final double n) {
        this.setY(new Double(n));
    }
    
    public void setY(final Number y) {
        this.y = y;
    }
    
    public int compareTo(final Object o) {
        int n2;
        if (o instanceof XYDataItem) {
            final double n = this.x.doubleValue() - ((XYDataItem)o).getX().doubleValue();
            if (n > 0.0) {
                n2 = 1;
            }
            else if (n < 0.0) {
                n2 = -1;
            }
            else {
                n2 = 0;
            }
        }
        else {
            n2 = 1;
        }
        return n2;
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYDataItem)) {
            return false;
        }
        final XYDataItem xyDataItem = (XYDataItem)o;
        return this.x.equals(xyDataItem.x) && ObjectUtilities.equal(this.y, xyDataItem.y);
    }
    
    public int hashCode() {
        return 29 * this.x.hashCode() + ((this.y != null) ? this.y.hashCode() : 0);
    }
}
