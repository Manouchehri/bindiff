/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.io.Serializable;

public final class SeriesRenderingOrder
implements Serializable {
    private static final long serialVersionUID = 209336477448807735L;
    public static final SeriesRenderingOrder FORWARD = new SeriesRenderingOrder("SeriesRenderingOrder.FORWARD");
    public static final SeriesRenderingOrder REVERSE = new SeriesRenderingOrder("SeriesRenderingOrder.REVERSE");
    private String name;

    private SeriesRenderingOrder(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof SeriesRenderingOrder)) {
            return false;
        }
        SeriesRenderingOrder seriesRenderingOrder = (SeriesRenderingOrder)object;
        if (this.name.equals(seriesRenderingOrder.toString())) return true;
        return false;
    }

    private Object readResolve() {
        if (this.equals(FORWARD)) {
            return FORWARD;
        }
        if (!this.equals(REVERSE)) return null;
        return REVERSE;
    }
}

