package org.jfree.chart;

import java.io.*;

public final class LegendRenderingOrder implements Serializable
{
    private static final long serialVersionUID = -3832486612685808616L;
    public static final LegendRenderingOrder STANDARD;
    public static final LegendRenderingOrder REVERSE;
    private String name;
    
    private LegendRenderingOrder(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof LegendRenderingOrder && this.name.equals(((LegendRenderingOrder)o).toString()));
    }
    
    private Object readResolve() {
        if (this.equals(LegendRenderingOrder.STANDARD)) {
            return LegendRenderingOrder.STANDARD;
        }
        if (this.equals(LegendRenderingOrder.REVERSE)) {
            return LegendRenderingOrder.REVERSE;
        }
        return null;
    }
    
    static {
        STANDARD = new LegendRenderingOrder("LegendRenderingOrder.STANDARD");
        REVERSE = new LegendRenderingOrder("LegendRenderingOrder.REVERSE");
    }
}
