package org.jfree.chart.plot;

import java.io.*;

public final class DatasetRenderingOrder implements Serializable
{
    private static final long serialVersionUID = -600593412366385072L;
    public static final DatasetRenderingOrder FORWARD;
    public static final DatasetRenderingOrder REVERSE;
    private String name;
    
    private DatasetRenderingOrder(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof DatasetRenderingOrder && this.name.equals(((DatasetRenderingOrder)o).toString()));
    }
    
    private Object readResolve() {
        if (this.equals(DatasetRenderingOrder.FORWARD)) {
            return DatasetRenderingOrder.FORWARD;
        }
        if (this.equals(DatasetRenderingOrder.REVERSE)) {
            return DatasetRenderingOrder.REVERSE;
        }
        return null;
    }
    
    static {
        FORWARD = new DatasetRenderingOrder("DatasetRenderingOrder.FORWARD");
        REVERSE = new DatasetRenderingOrder("DatasetRenderingOrder.REVERSE");
    }
}
