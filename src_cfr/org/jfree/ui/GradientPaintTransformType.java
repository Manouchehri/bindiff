/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.io.Serializable;

public final class GradientPaintTransformType
implements Serializable {
    private static final long serialVersionUID = 8331561784933982450L;
    public static final GradientPaintTransformType VERTICAL = new GradientPaintTransformType("GradientPaintTransformType.VERTICAL");
    public static final GradientPaintTransformType HORIZONTAL = new GradientPaintTransformType("GradientPaintTransformType.HORIZONTAL");
    public static final GradientPaintTransformType CENTER_VERTICAL = new GradientPaintTransformType("GradientPaintTransformType.CENTER_VERTICAL");
    public static final GradientPaintTransformType CENTER_HORIZONTAL = new GradientPaintTransformType("GradientPaintTransformType.CENTER_HORIZONTAL");
    private String name;

    private GradientPaintTransformType(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof GradientPaintTransformType)) {
            return false;
        }
        GradientPaintTransformType gradientPaintTransformType = (GradientPaintTransformType)object;
        if (this.name.equals(gradientPaintTransformType.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        GradientPaintTransformType gradientPaintTransformType = null;
        if (this.equals(HORIZONTAL)) {
            return HORIZONTAL;
        }
        if (this.equals(VERTICAL)) {
            return VERTICAL;
        }
        if (this.equals(CENTER_HORIZONTAL)) {
            return CENTER_HORIZONTAL;
        }
        if (!this.equals(CENTER_VERTICAL)) return gradientPaintTransformType;
        return CENTER_VERTICAL;
    }
}

