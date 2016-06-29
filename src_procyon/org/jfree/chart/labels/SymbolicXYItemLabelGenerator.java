package org.jfree.chart.labels;

import java.io.*;
import org.jfree.util.*;
import org.jfree.data.xy.*;
import org.jfree.data.time.*;

public class SymbolicXYItemLabelGenerator implements Serializable, Cloneable, XYItemLabelGenerator, XYToolTipGenerator, PublicCloneable
{
    private static final long serialVersionUID = 3963400354475494395L;
    
    public String generateToolTip(final XYDataset xyDataset, final int n, final int n2) {
        String s;
        if (xyDataset instanceof YisSymbolic) {
            s = ((YisSymbolic)xyDataset).getYSymbolicValue(n, n2);
        }
        else {
            s = Double.toString(round(xyDataset.getYValue(n, n2), 2));
        }
        String s2;
        if (xyDataset instanceof XisSymbolic) {
            s2 = ((XisSymbolic)xyDataset).getXSymbolicValue(n, n2);
        }
        else if (xyDataset instanceof TimeSeriesCollection) {
            s2 = ((TimeSeriesCollection)xyDataset).getSeries(n).getTimePeriod(n2).toString();
        }
        else {
            s2 = Double.toString(round(xyDataset.getXValue(n, n2), 2));
        }
        return "X: " + s2 + ", Y: " + s;
    }
    
    public String generateLabel(final XYDataset xyDataset, final int n, final int n2) {
        return null;
    }
    
    private static double round(final double n, final int n2) {
        if (n2 <= 0) {
            return Math.floor(n + 0.5);
        }
        final double pow = Math.pow(10.0, n2);
        return Math.floor(n * pow + 0.5) / pow;
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public boolean equals(final Object o) {
        return o == this || o instanceof SymbolicXYItemLabelGenerator;
    }
}
