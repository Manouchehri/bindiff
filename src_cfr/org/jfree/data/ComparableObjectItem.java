/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.io.Serializable;
import org.jfree.util.ObjectUtilities;

public class ComparableObjectItem
implements Serializable,
Cloneable,
Comparable {
    private static final long serialVersionUID = 2751513470325494890L;
    private Comparable x;
    private Object obj;

    public ComparableObjectItem(Comparable comparable, Object object) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'x' argument.");
        }
        this.x = comparable;
        this.obj = object;
    }

    protected Comparable getComparable() {
        return this.x;
    }

    protected Object getObject() {
        return this.obj;
    }

    protected void setObject(Object object) {
        this.obj = object;
    }

    public int compareTo(Object object) {
        if (!(object instanceof ComparableObjectItem)) return 1;
        ComparableObjectItem comparableObjectItem = (ComparableObjectItem)object;
        return this.x.compareTo(comparableObjectItem.x);
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ComparableObjectItem)) {
            return false;
        }
        ComparableObjectItem comparableObjectItem = (ComparableObjectItem)object;
        if (!this.x.equals(comparableObjectItem.x)) {
            return false;
        }
        if (ObjectUtilities.equal(this.obj, comparableObjectItem.obj)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.x.hashCode();
        return 29 * n2 + (this.obj != null ? this.obj.hashCode() : 0);
    }
}

