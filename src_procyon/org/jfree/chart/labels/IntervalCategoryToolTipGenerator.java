package org.jfree.chart.labels;

import java.io.*;
import org.jfree.util.*;
import java.text.*;
import org.jfree.data.category.*;

public class IntervalCategoryToolTipGenerator extends StandardCategoryToolTipGenerator implements Serializable, Cloneable, CategoryToolTipGenerator, PublicCloneable
{
    private static final long serialVersionUID = -3853824986520333437L;
    public static final String DEFAULT_TOOL_TIP_FORMAT_STRING = "({0}, {1}) = {3} - {4}";
    
    public IntervalCategoryToolTipGenerator() {
        super("({0}, {1}) = {3} - {4}", NumberFormat.getInstance());
    }
    
    public IntervalCategoryToolTipGenerator(final String s, final NumberFormat numberFormat) {
        super(s, numberFormat);
    }
    
    public IntervalCategoryToolTipGenerator(final String s, final DateFormat dateFormat) {
        super(s, dateFormat);
    }
    
    protected Object[] createItemArray(final CategoryDataset categoryDataset, final int n, final int n2) {
        final Object[] array = { categoryDataset.getRowKey(n).toString(), categoryDataset.getColumnKey(n2).toString(), null, null, null };
        final Number value = categoryDataset.getValue(n, n2);
        if (this.getNumberFormat() != null) {
            array[2] = this.getNumberFormat().format(value);
        }
        else if (this.getDateFormat() != null) {
            array[2] = this.getDateFormat().format(value);
        }
        if (categoryDataset instanceof IntervalCategoryDataset) {
            final IntervalCategoryDataset intervalCategoryDataset = (IntervalCategoryDataset)categoryDataset;
            final Number startValue = intervalCategoryDataset.getStartValue(n, n2);
            final Number endValue = intervalCategoryDataset.getEndValue(n, n2);
            if (this.getNumberFormat() != null) {
                array[3] = this.getNumberFormat().format(startValue);
                array[4] = this.getNumberFormat().format(endValue);
            }
            else if (this.getDateFormat() != null) {
                array[3] = this.getDateFormat().format(startValue);
                array[4] = this.getDateFormat().format(endValue);
            }
        }
        return array;
    }
}
