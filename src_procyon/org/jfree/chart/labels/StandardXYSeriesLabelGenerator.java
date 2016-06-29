package org.jfree.chart.labels;

import java.io.*;
import org.jfree.util.*;
import org.jfree.data.xy.*;
import java.text.*;

public class StandardXYSeriesLabelGenerator implements Serializable, Cloneable, XYSeriesLabelGenerator, PublicCloneable
{
    private static final long serialVersionUID = 1916017081848400024L;
    public static final String DEFAULT_LABEL_FORMAT = "{0}";
    private String formatPattern;
    
    public StandardXYSeriesLabelGenerator() {
        this("{0}");
    }
    
    public StandardXYSeriesLabelGenerator(final String formatPattern) {
        if (formatPattern == null) {
            throw new IllegalArgumentException("Null 'format' argument.");
        }
        this.formatPattern = formatPattern;
    }
    
    public String generateLabel(final XYDataset xyDataset, final int n) {
        if (xyDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        return MessageFormat.format(this.formatPattern, this.createItemArray(xyDataset, n));
    }
    
    protected Object[] createItemArray(final XYDataset xyDataset, final int n) {
        return new Object[] { xyDataset.getSeriesKey(n).toString() };
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StandardXYSeriesLabelGenerator && this.formatPattern.equals(((StandardXYSeriesLabelGenerator)o).formatPattern));
    }
}
