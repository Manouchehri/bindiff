/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.XYDataset;

public class BoxAndWhiskerXYToolTipGenerator
extends StandardXYToolTipGenerator
implements Serializable,
Cloneable,
XYToolTipGenerator {
    private static final long serialVersionUID = -2648775791161459710L;
    public static final String DEFAULT_TOOL_TIP_FORMAT = "X: {1} Mean: {2} Median: {3} Min: {4} Max: {5} Q1: {6} Q3: {7} ";

    public BoxAndWhiskerXYToolTipGenerator() {
        super("X: {1} Mean: {2} Median: {3} Min: {4} Max: {5} Q1: {6} Q3: {7} ", NumberFormat.getInstance(), NumberFormat.getInstance());
    }

    public BoxAndWhiskerXYToolTipGenerator(String string, DateFormat dateFormat, NumberFormat numberFormat) {
        super(string, dateFormat, numberFormat);
    }

    @Override
    protected Object[] createItemArray(XYDataset xYDataset, int n2, int n3) {
        Object[] arrobject = new Object[8];
        arrobject[0] = xYDataset.getSeriesKey(n2).toString();
        Number number = xYDataset.getX(n2, n3);
        arrobject[1] = this.getXDateFormat() != null ? this.getXDateFormat().format(new Date(number.longValue())) : this.getXFormat().format(number);
        NumberFormat numberFormat = this.getYFormat();
        if (!(xYDataset instanceof BoxAndWhiskerXYDataset)) return arrobject;
        BoxAndWhiskerXYDataset boxAndWhiskerXYDataset = (BoxAndWhiskerXYDataset)xYDataset;
        arrobject[2] = numberFormat.format(boxAndWhiskerXYDataset.getMeanValue(n2, n3));
        arrobject[3] = numberFormat.format(boxAndWhiskerXYDataset.getMedianValue(n2, n3));
        arrobject[4] = numberFormat.format(boxAndWhiskerXYDataset.getMinRegularValue(n2, n3));
        arrobject[5] = numberFormat.format(boxAndWhiskerXYDataset.getMaxRegularValue(n2, n3));
        arrobject[6] = numberFormat.format(boxAndWhiskerXYDataset.getQ1Value(n2, n3));
        arrobject[7] = numberFormat.format(boxAndWhiskerXYDataset.getQ3Value(n2, n3));
        return arrobject;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof BoxAndWhiskerXYToolTipGenerator) return super.equals(object);
        return false;
    }
}

