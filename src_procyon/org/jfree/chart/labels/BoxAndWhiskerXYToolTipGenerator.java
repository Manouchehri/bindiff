package org.jfree.chart.labels;

import java.io.*;
import java.text.*;
import org.jfree.data.xy.*;
import java.util.*;
import org.jfree.data.statistics.*;

public class BoxAndWhiskerXYToolTipGenerator extends StandardXYToolTipGenerator implements Serializable, Cloneable, XYToolTipGenerator
{
    private static final long serialVersionUID = -2648775791161459710L;
    public static final String DEFAULT_TOOL_TIP_FORMAT = "X: {1} Mean: {2} Median: {3} Min: {4} Max: {5} Q1: {6} Q3: {7} ";
    
    public BoxAndWhiskerXYToolTipGenerator() {
        super("X: {1} Mean: {2} Median: {3} Min: {4} Max: {5} Q1: {6} Q3: {7} ", NumberFormat.getInstance(), NumberFormat.getInstance());
    }
    
    public BoxAndWhiskerXYToolTipGenerator(final String s, final DateFormat dateFormat, final NumberFormat numberFormat) {
        super(s, dateFormat, numberFormat);
    }
    
    protected Object[] createItemArray(final XYDataset xyDataset, final int n, final int n2) {
        final Object[] array = new Object[8];
        array[0] = xyDataset.getSeriesKey(n).toString();
        final Number x = xyDataset.getX(n, n2);
        if (this.getXDateFormat() != null) {
            array[1] = this.getXDateFormat().format(new Date(x.longValue()));
        }
        else {
            array[1] = this.getXFormat().format(x);
        }
        final NumberFormat yFormat = this.getYFormat();
        if (xyDataset instanceof BoxAndWhiskerXYDataset) {
            final BoxAndWhiskerXYDataset boxAndWhiskerXYDataset = (BoxAndWhiskerXYDataset)xyDataset;
            array[2] = yFormat.format(boxAndWhiskerXYDataset.getMeanValue(n, n2));
            array[3] = yFormat.format(boxAndWhiskerXYDataset.getMedianValue(n, n2));
            array[4] = yFormat.format(boxAndWhiskerXYDataset.getMinRegularValue(n, n2));
            array[5] = yFormat.format(boxAndWhiskerXYDataset.getMaxRegularValue(n, n2));
            array[6] = yFormat.format(boxAndWhiskerXYDataset.getQ1Value(n, n2));
            array[7] = yFormat.format(boxAndWhiskerXYDataset.getQ3Value(n, n2));
        }
        return array;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof BoxAndWhiskerXYToolTipGenerator && super.equals(o));
    }
}
