/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.util.PublicCloneable;

public class IntervalCategoryItemLabelGenerator
extends StandardCategoryItemLabelGenerator
implements Serializable,
Cloneable,
CategoryItemLabelGenerator,
PublicCloneable {
    private static final long serialVersionUID = 5056909225610630529L;
    public static final String DEFAULT_LABEL_FORMAT_STRING = "({0}, {1}) = {3} - {4}";

    public IntervalCategoryItemLabelGenerator() {
        super("({0}, {1}) = {3} - {4}", NumberFormat.getInstance());
    }

    public IntervalCategoryItemLabelGenerator(String string, NumberFormat numberFormat) {
        super(string, numberFormat);
    }

    public IntervalCategoryItemLabelGenerator(String string, DateFormat dateFormat) {
        super(string, dateFormat);
    }

    @Override
    protected Object[] createItemArray(CategoryDataset categoryDataset, int n2, int n3) {
        Object[] arrobject = new Object[5];
        arrobject[0] = categoryDataset.getRowKey(n2).toString();
        arrobject[1] = categoryDataset.getColumnKey(n3).toString();
        Number number = categoryDataset.getValue(n2, n3);
        if (this.getNumberFormat() != null) {
            arrobject[2] = this.getNumberFormat().format(number);
        } else if (this.getDateFormat() != null) {
            arrobject[2] = this.getDateFormat().format(number);
        }
        if (!(categoryDataset instanceof IntervalCategoryDataset)) return arrobject;
        IntervalCategoryDataset intervalCategoryDataset = (IntervalCategoryDataset)categoryDataset;
        Number number2 = intervalCategoryDataset.getStartValue(n2, n3);
        Number number3 = intervalCategoryDataset.getEndValue(n2, n3);
        if (this.getNumberFormat() != null) {
            arrobject[3] = this.getNumberFormat().format(number2);
            arrobject[4] = this.getNumberFormat().format(number3);
            return arrobject;
        }
        if (this.getDateFormat() == null) return arrobject;
        arrobject[3] = this.getDateFormat().format(number2);
        arrobject[4] = this.getDateFormat().format(number3);
        return arrobject;
    }
}

