package org.jfree.chart.labels;

import java.io.*;
import org.jfree.util.*;
import java.text.*;
import org.jfree.data.category.*;
import org.jfree.data.statistics.*;

public class BoxAndWhiskerToolTipGenerator extends StandardCategoryToolTipGenerator implements Serializable, Cloneable, CategoryToolTipGenerator, PublicCloneable
{
    private static final long serialVersionUID = -6076837753823076334L;
    public static final String DEFAULT_TOOL_TIP_FORMAT = "X: {1} Mean: {2} Median: {3} Min: {4} Max: {5} Q1: {6} Q3: {7} ";
    
    public BoxAndWhiskerToolTipGenerator() {
        super("X: {1} Mean: {2} Median: {3} Min: {4} Max: {5} Q1: {6} Q3: {7} ", NumberFormat.getInstance());
    }
    
    public BoxAndWhiskerToolTipGenerator(final String s, final NumberFormat numberFormat) {
        super(s, numberFormat);
    }
    
    protected Object[] createItemArray(final CategoryDataset categoryDataset, final int n, final int n2) {
        final Object[] array = new Object[8];
        array[0] = categoryDataset.getRowKey(n);
        final Number value = categoryDataset.getValue(n, n2);
        final NumberFormat numberFormat = this.getNumberFormat();
        array[1] = numberFormat.format(value);
        if (categoryDataset instanceof BoxAndWhiskerCategoryDataset) {
            final BoxAndWhiskerCategoryDataset boxAndWhiskerCategoryDataset = (BoxAndWhiskerCategoryDataset)categoryDataset;
            array[2] = numberFormat.format(boxAndWhiskerCategoryDataset.getMeanValue(n, n2));
            array[3] = numberFormat.format(boxAndWhiskerCategoryDataset.getMedianValue(n, n2));
            array[4] = numberFormat.format(boxAndWhiskerCategoryDataset.getMinRegularValue(n, n2));
            array[5] = numberFormat.format(boxAndWhiskerCategoryDataset.getMaxRegularValue(n, n2));
            array[6] = numberFormat.format(boxAndWhiskerCategoryDataset.getQ1Value(n, n2));
            array[7] = numberFormat.format(boxAndWhiskerCategoryDataset.getQ3Value(n, n2));
        }
        return array;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof BoxAndWhiskerToolTipGenerator && super.equals(o));
    }
}
