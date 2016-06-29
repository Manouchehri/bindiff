/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.event;

import java.io.Serializable;

public final class ChartChangeEventType
implements Serializable {
    private static final long serialVersionUID = 5481917022435735602L;
    public static final ChartChangeEventType GENERAL = new ChartChangeEventType("ChartChangeEventType.GENERAL");
    public static final ChartChangeEventType NEW_DATASET = new ChartChangeEventType("ChartChangeEventType.NEW_DATASET");
    public static final ChartChangeEventType DATASET_UPDATED = new ChartChangeEventType("ChartChangeEventType.DATASET_UPDATED");
    private String name;

    private ChartChangeEventType(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ChartChangeEventType)) {
            return false;
        }
        ChartChangeEventType chartChangeEventType = (ChartChangeEventType)object;
        if (this.name.equals(chartChangeEventType.toString())) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        if (this.equals(GENERAL)) {
            return GENERAL;
        }
        if (this.equals(NEW_DATASET)) {
            return NEW_DATASET;
        }
        if (!this.equals(DATASET_UPDATED)) return null;
        return DATASET_UPDATED;
    }
}

