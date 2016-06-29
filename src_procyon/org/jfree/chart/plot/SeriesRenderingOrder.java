package org.jfree.chart.plot;

import java.io.*;

public final class SeriesRenderingOrder implements Serializable
{
    private static final long serialVersionUID = 209336477448807735L;
    public static final SeriesRenderingOrder FORWARD;
    public static final SeriesRenderingOrder REVERSE;
    private String name;
    
    private SeriesRenderingOrder(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof SeriesRenderingOrder && this.name.equals(((SeriesRenderingOrder)o).toString()));
    }
    
    private Object readResolve() {
        if (this.equals(SeriesRenderingOrder.FORWARD)) {
            return SeriesRenderingOrder.FORWARD;
        }
        if (this.equals(SeriesRenderingOrder.REVERSE)) {
            return SeriesRenderingOrder.REVERSE;
        }
        return null;
    }
    
    static {
        FORWARD = new SeriesRenderingOrder("SeriesRenderingOrder.FORWARD");
        REVERSE = new SeriesRenderingOrder("SeriesRenderingOrder.REVERSE");
    }
}
