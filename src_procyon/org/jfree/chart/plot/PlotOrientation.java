package org.jfree.chart.plot;

import java.io.*;

public final class PlotOrientation implements Serializable
{
    private static final long serialVersionUID = -2508771828190337782L;
    public static final PlotOrientation HORIZONTAL;
    public static final PlotOrientation VERTICAL;
    private String name;
    
    private PlotOrientation(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof PlotOrientation && this.name.equals(((PlotOrientation)o).toString()));
    }
    
    private Object readResolve() {
        Object o = null;
        if (this.equals(PlotOrientation.HORIZONTAL)) {
            o = PlotOrientation.HORIZONTAL;
        }
        else if (this.equals(PlotOrientation.VERTICAL)) {
            o = PlotOrientation.VERTICAL;
        }
        return o;
    }
    
    static {
        HORIZONTAL = new PlotOrientation("PlotOrientation.HORIZONTAL");
        VERTICAL = new PlotOrientation("PlotOrientation.VERTICAL");
    }
}
