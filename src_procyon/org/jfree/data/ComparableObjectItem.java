package org.jfree.data;

import java.io.*;
import org.jfree.util.*;

public class ComparableObjectItem implements Serializable, Cloneable, Comparable
{
    private static final long serialVersionUID = 2751513470325494890L;
    private Comparable x;
    private Object obj;
    
    public ComparableObjectItem(final Comparable x, final Object obj) {
        if (x == null) {
            throw new IllegalArgumentException("Null 'x' argument.");
        }
        this.x = x;
        this.obj = obj;
    }
    
    protected Comparable getComparable() {
        return this.x;
    }
    
    protected Object getObject() {
        return this.obj;
    }
    
    protected void setObject(final Object obj) {
        this.obj = obj;
    }
    
    public int compareTo(final Object o) {
        if (o instanceof ComparableObjectItem) {
            return this.x.compareTo(((ComparableObjectItem)o).x);
        }
        return 1;
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ComparableObjectItem)) {
            return false;
        }
        final ComparableObjectItem comparableObjectItem = (ComparableObjectItem)o;
        return this.x.equals(comparableObjectItem.x) && ObjectUtilities.equal(this.obj, comparableObjectItem.obj);
    }
    
    public int hashCode() {
        return 29 * this.x.hashCode() + ((this.obj != null) ? this.obj.hashCode() : 0);
    }
}
