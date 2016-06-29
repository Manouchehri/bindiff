package org.jfree.chart.labels;

import java.io.*;
import org.jfree.util.*;
import java.text.*;
import org.jfree.data.xy.*;
import java.util.*;

public class HighLowItemLabelGenerator implements Serializable, Cloneable, XYItemLabelGenerator, XYToolTipGenerator, PublicCloneable
{
    private static final long serialVersionUID = 5617111754832211830L;
    private DateFormat dateFormatter;
    private NumberFormat numberFormatter;
    
    public HighLowItemLabelGenerator() {
        this(DateFormat.getInstance(), NumberFormat.getInstance());
    }
    
    public HighLowItemLabelGenerator(final DateFormat dateFormatter, final NumberFormat numberFormatter) {
        if (dateFormatter == null) {
            throw new IllegalArgumentException("Null 'dateFormatter' argument.");
        }
        if (numberFormatter == null) {
            throw new IllegalArgumentException("Null 'numberFormatter' argument.");
        }
        this.dateFormatter = dateFormatter;
        this.numberFormatter = numberFormatter;
    }
    
    public String generateToolTip(final XYDataset xyDataset, final int n, final int n2) {
        String s = null;
        if (xyDataset instanceof OHLCDataset) {
            final OHLCDataset ohlcDataset = (OHLCDataset)xyDataset;
            final Number high = ohlcDataset.getHigh(n, n2);
            final Number low = ohlcDataset.getLow(n, n2);
            final Number open = ohlcDataset.getOpen(n, n2);
            final Number close = ohlcDataset.getClose(n, n2);
            final Number x = ohlcDataset.getX(n, n2);
            s = ohlcDataset.getSeriesKey(n).toString();
            if (x != null) {
                s = s + "--> Date=" + this.dateFormatter.format(new Date(x.longValue()));
                if (high != null) {
                    s = s + " High=" + this.numberFormatter.format(high.doubleValue());
                }
                if (low != null) {
                    s = s + " Low=" + this.numberFormatter.format(low.doubleValue());
                }
                if (open != null) {
                    s = s + " Open=" + this.numberFormatter.format(open.doubleValue());
                }
                if (close != null) {
                    s = s + " Close=" + this.numberFormatter.format(close.doubleValue());
                }
            }
        }
        return s;
    }
    
    public String generateLabel(final XYDataset xyDataset, final int n, final int n2) {
        return null;
    }
    
    public Object clone() {
        final HighLowItemLabelGenerator highLowItemLabelGenerator = (HighLowItemLabelGenerator)super.clone();
        if (this.dateFormatter != null) {
            highLowItemLabelGenerator.dateFormatter = (DateFormat)this.dateFormatter.clone();
        }
        if (this.numberFormatter != null) {
            highLowItemLabelGenerator.numberFormatter = (NumberFormat)this.numberFormatter.clone();
        }
        return highLowItemLabelGenerator;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HighLowItemLabelGenerator)) {
            return false;
        }
        final HighLowItemLabelGenerator highLowItemLabelGenerator = (HighLowItemLabelGenerator)o;
        return this.dateFormatter.equals(highLowItemLabelGenerator.dateFormatter) && this.numberFormatter.equals(highLowItemLabelGenerator.numberFormatter);
    }
}
