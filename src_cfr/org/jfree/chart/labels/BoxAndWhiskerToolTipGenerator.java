/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.NumberFormat;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.util.PublicCloneable;

public class BoxAndWhiskerToolTipGenerator
extends StandardCategoryToolTipGenerator
implements Serializable,
Cloneable,
CategoryToolTipGenerator,
PublicCloneable {
    private static final long serialVersionUID = -6076837753823076334L;
    public static final String DEFAULT_TOOL_TIP_FORMAT = "X: {1} Mean: {2} Median: {3} Min: {4} Max: {5} Q1: {6} Q3: {7} ";

    public BoxAndWhiskerToolTipGenerator() {
        super("X: {1} Mean: {2} Median: {3} Min: {4} Max: {5} Q1: {6} Q3: {7} ", NumberFormat.getInstance());
    }

    public BoxAndWhiskerToolTipGenerator(String string, NumberFormat numberFormat) {
        super(string, numberFormat);
    }

    @Override
    protected Object[] createItemArray(CategoryDataset categoryDataset, int n2, int n3) {
        Object[] arrobject = new Object[8];
        arrobject[0] = categoryDataset.getRowKey(n2);
        Number number = categoryDataset.getValue(n2, n3);
        NumberFormat numberFormat = this.getNumberFormat();
        arrobject[1] = numberFormat.format(number);
        if (!(categoryDataset instanceof BoxAndWhiskerCategoryDataset)) return arrobject;
        BoxAndWhiskerCategoryDataset boxAndWhiskerCategoryDataset = (BoxAndWhiskerCategoryDataset)categoryDataset;
        arrobject[2] = numberFormat.format(boxAndWhiskerCategoryDataset.getMeanValue(n2, n3));
        arrobject[3] = numberFormat.format(boxAndWhiskerCategoryDataset.getMedianValue(n2, n3));
        arrobject[4] = numberFormat.format(boxAndWhiskerCategoryDataset.getMinRegularValue(n2, n3));
        arrobject[5] = numberFormat.format(boxAndWhiskerCategoryDataset.getMaxRegularValue(n2, n3));
        arrobject[6] = numberFormat.format(boxAndWhiskerCategoryDataset.getQ1Value(n2, n3));
        arrobject[7] = numberFormat.format(boxAndWhiskerCategoryDataset.getQ3Value(n2, n3));
        return arrobject;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BoxAndWhiskerToolTipGenerator)) return false;
        return super.equals(object);
    }
}

