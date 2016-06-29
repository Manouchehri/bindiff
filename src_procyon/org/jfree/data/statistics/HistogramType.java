package org.jfree.data.statistics;

import java.io.*;

public class HistogramType implements Serializable
{
    private static final long serialVersionUID = 2618927186251997727L;
    public static final HistogramType FREQUENCY;
    public static final HistogramType RELATIVE_FREQUENCY;
    public static final HistogramType SCALE_AREA_TO_1;
    private String name;
    
    private HistogramType(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return o != null && (o == this || (o instanceof HistogramType && this.name.equals(((HistogramType)o).name)));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    private Object readResolve() {
        if (this.equals(HistogramType.FREQUENCY)) {
            return HistogramType.FREQUENCY;
        }
        if (this.equals(HistogramType.RELATIVE_FREQUENCY)) {
            return HistogramType.RELATIVE_FREQUENCY;
        }
        if (this.equals(HistogramType.SCALE_AREA_TO_1)) {
            return HistogramType.SCALE_AREA_TO_1;
        }
        return null;
    }
    
    static {
        FREQUENCY = new HistogramType("FREQUENCY");
        RELATIVE_FREQUENCY = new HistogramType("RELATIVE_FREQUENCY");
        SCALE_AREA_TO_1 = new HistogramType("SCALE_AREA_TO_1");
    }
}
