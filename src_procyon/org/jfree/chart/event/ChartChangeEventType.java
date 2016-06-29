package org.jfree.chart.event;

import java.io.*;

public final class ChartChangeEventType implements Serializable
{
    private static final long serialVersionUID = 5481917022435735602L;
    public static final ChartChangeEventType GENERAL;
    public static final ChartChangeEventType NEW_DATASET;
    public static final ChartChangeEventType DATASET_UPDATED;
    private String name;
    
    private ChartChangeEventType(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof ChartChangeEventType && this.name.equals(((ChartChangeEventType)o).toString()));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    private Object readResolve() {
        if (this.equals(ChartChangeEventType.GENERAL)) {
            return ChartChangeEventType.GENERAL;
        }
        if (this.equals(ChartChangeEventType.NEW_DATASET)) {
            return ChartChangeEventType.NEW_DATASET;
        }
        if (this.equals(ChartChangeEventType.DATASET_UPDATED)) {
            return ChartChangeEventType.DATASET_UPDATED;
        }
        return null;
    }
    
    static {
        GENERAL = new ChartChangeEventType("ChartChangeEventType.GENERAL");
        NEW_DATASET = new ChartChangeEventType("ChartChangeEventType.NEW_DATASET");
        DATASET_UPDATED = new ChartChangeEventType("ChartChangeEventType.DATASET_UPDATED");
    }
}
