/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.geom.Dimension2D;
import java.io.Serializable;

public class FloatDimension
extends Dimension2D
implements Serializable {
    private static final long serialVersionUID = 5367882923248086744L;
    private float width;
    private float height;

    public FloatDimension() {
        this.width = 0.0f;
        this.height = 0.0f;
    }

    public FloatDimension(FloatDimension floatDimension) {
        this.width = floatDimension.width;
        this.height = floatDimension.height;
    }

    public FloatDimension(float f2, float f3) {
        this.width = f2;
        this.height = f3;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    public void setWidth(double d2) {
        this.width = (float)d2;
    }

    public void setHeight(double d2) {
        this.height = (float)d2;
    }

    @Override
    public void setSize(double d2, double d3) {
        this.setHeight((float)d3);
        this.setWidth((float)d2);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    public String toString() {
        return new StringBuffer().append(this.getClass().getName()).append(":={width=").append(this.getWidth()).append(", height=").append(this.getHeight()).append("}").toString();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof FloatDimension)) {
            return false;
        }
        FloatDimension floatDimension = (FloatDimension)object;
        if (this.height != floatDimension.height) {
            return false;
        }
        if (this.width == floatDimension.width) return true;
        return false;
    }

    public int hashCode() {
        int n2 = Float.floatToIntBits(this.width);
        return 29 * n2 + Float.floatToIntBits(this.height);
    }
}

