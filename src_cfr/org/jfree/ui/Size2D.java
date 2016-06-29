/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.io.Serializable;
import org.jfree.util.PublicCloneable;

public class Size2D
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 2558191683786418168L;
    public double width;
    public double height;

    public Size2D() {
        this(0.0, 0.0);
    }

    public Size2D(double d2, double d3) {
        this.width = d2;
        this.height = d3;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double d2) {
        this.width = d2;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double d2) {
        this.height = d2;
    }

    public String toString() {
        return new StringBuffer().append("Size2D[width=").append(this.width).append(", height=").append(this.height).append("]").toString();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Size2D)) {
            return false;
        }
        Size2D size2D = (Size2D)object;
        if (this.width != size2D.width) {
            return false;
        }
        if (this.height == size2D.height) return true;
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

