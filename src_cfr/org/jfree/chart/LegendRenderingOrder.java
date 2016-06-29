/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.io.Serializable;

public final class LegendRenderingOrder
implements Serializable {
    private static final long serialVersionUID = -3832486612685808616L;
    public static final LegendRenderingOrder STANDARD = new LegendRenderingOrder("LegendRenderingOrder.STANDARD");
    public static final LegendRenderingOrder REVERSE = new LegendRenderingOrder("LegendRenderingOrder.REVERSE");
    private String name;

    private LegendRenderingOrder(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LegendRenderingOrder)) {
            return false;
        }
        LegendRenderingOrder legendRenderingOrder = (LegendRenderingOrder)object;
        if (this.name.equals(legendRenderingOrder.toString())) return true;
        return false;
    }

    private Object readResolve() {
        if (this.equals(STANDARD)) {
            return STANDARD;
        }
        if (!this.equals(REVERSE)) return null;
        return REVERSE;
    }
}

