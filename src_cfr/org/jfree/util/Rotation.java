/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.Serializable;

public final class Rotation
implements Serializable {
    private static final long serialVersionUID = -4662815260201591676L;
    public static final Rotation CLOCKWISE = new Rotation("Rotation.CLOCKWISE", -1.0);
    public static final Rotation ANTICLOCKWISE = new Rotation("Rotation.ANTICLOCKWISE", 1.0);
    private String name;
    private double factor;

    private Rotation(String string, double d2) {
        this.name = string;
        this.factor = d2;
    }

    public String toString() {
        return this.name;
    }

    public double getFactor() {
        return this.factor;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Rotation)) {
            return false;
        }
        Rotation rotation = (Rotation)object;
        if (this.factor == rotation.factor) return true;
        return false;
    }

    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.factor);
        return (int)(l2 ^ l2 >>> 32);
    }

    private Object readResolve() {
        if (this.equals(CLOCKWISE)) {
            return CLOCKWISE;
        }
        if (!this.equals(ANTICLOCKWISE)) return null;
        return ANTICLOCKWISE;
    }
}

