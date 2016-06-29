/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.io.Serializable;

public final class DatasetRenderingOrder
implements Serializable {
    private static final long serialVersionUID = -600593412366385072L;
    public static final DatasetRenderingOrder FORWARD = new DatasetRenderingOrder("DatasetRenderingOrder.FORWARD");
    public static final DatasetRenderingOrder REVERSE = new DatasetRenderingOrder("DatasetRenderingOrder.REVERSE");
    private String name;

    private DatasetRenderingOrder(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DatasetRenderingOrder)) {
            return false;
        }
        DatasetRenderingOrder datasetRenderingOrder = (DatasetRenderingOrder)object;
        if (this.name.equals(datasetRenderingOrder.toString())) return true;
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

