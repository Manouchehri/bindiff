/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.io.Serializable;

public final class DialShape
implements Serializable {
    private static final long serialVersionUID = -3471933055190251131L;
    public static final DialShape CIRCLE = new DialShape("DialShape.CIRCLE");
    public static final DialShape CHORD = new DialShape("DialShape.CHORD");
    public static final DialShape PIE = new DialShape("DialShape.PIE");
    private String name;

    private DialShape(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DialShape)) {
            return false;
        }
        DialShape dialShape = (DialShape)object;
        if (this.name.equals(dialShape.toString())) return true;
        return false;
    }

    private Object readResolve() {
        if (this.equals(CIRCLE)) {
            return CIRCLE;
        }
        if (this.equals(CHORD)) {
            return CHORD;
        }
        if (!this.equals(PIE)) return null;
        return PIE;
    }
}

