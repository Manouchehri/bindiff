/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.data.category.CategoryDataset;

public class StandardCategoryToolTipGenerator
extends AbstractCategoryItemLabelGenerator
implements Serializable,
CategoryToolTipGenerator {
    private static final long serialVersionUID = -6768806592218710764L;
    public static final String DEFAULT_TOOL_TIP_FORMAT_STRING = "({0}, {1}) = {2}";

    public StandardCategoryToolTipGenerator() {
        super("({0}, {1}) = {2}", NumberFormat.getInstance());
    }

    public StandardCategoryToolTipGenerator(String string, NumberFormat numberFormat) {
        super(string, numberFormat);
    }

    public StandardCategoryToolTipGenerator(String string, DateFormat dateFormat) {
        super(string, dateFormat);
    }

    @Override
    public String generateToolTip(CategoryDataset categoryDataset, int n2, int n3) {
        return this.generateLabelString(categoryDataset, n2, n3);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof StandardCategoryToolTipGenerator) return super.equals(object);
        return false;
    }
}

