/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XisSymbolic;
import org.jfree.data.xy.YisSymbolic;
import org.jfree.util.PublicCloneable;

public class SymbolicXYItemLabelGenerator
implements Serializable,
Cloneable,
XYItemLabelGenerator,
XYToolTipGenerator,
PublicCloneable {
    private static final long serialVersionUID = 3963400354475494395L;

    @Override
    public String generateToolTip(XYDataset xYDataset, int n2, int n3) {
        double d2;
        String string;
        String string2;
        if (xYDataset instanceof YisSymbolic) {
            string = ((YisSymbolic)((Object)xYDataset)).getYSymbolicValue(n2, n3);
        } else {
            d2 = xYDataset.getYValue(n2, n3);
            string = Double.toString(SymbolicXYItemLabelGenerator.round(d2, 2));
        }
        if (xYDataset instanceof XisSymbolic) {
            string2 = ((XisSymbolic)((Object)xYDataset)).getXSymbolicValue(n2, n3);
            return new StringBuffer().append("X: ").append(string2).append(", Y: ").append(string).toString();
        }
        if (xYDataset instanceof TimeSeriesCollection) {
            RegularTimePeriod regularTimePeriod = ((TimeSeriesCollection)xYDataset).getSeries(n2).getTimePeriod(n3);
            string2 = regularTimePeriod.toString();
            return new StringBuffer().append("X: ").append(string2).append(", Y: ").append(string).toString();
        }
        d2 = xYDataset.getXValue(n2, n3);
        string2 = Double.toString(SymbolicXYItemLabelGenerator.round(d2, 2));
        return new StringBuffer().append("X: ").append(string2).append(", Y: ").append(string).toString();
    }

    @Override
    public String generateLabel(XYDataset xYDataset, int n2, int n3) {
        return null;
    }

    private static double round(double d2, int n2) {
        if (n2 <= 0) {
            return Math.floor(d2 + 0.5);
        }
        double d3 = Math.pow(10.0, n2);
        double d4 = Math.floor(d2 * d3 + 0.5);
        return d4 / d3;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SymbolicXYItemLabelGenerator)) return false;
        return true;
    }
}

