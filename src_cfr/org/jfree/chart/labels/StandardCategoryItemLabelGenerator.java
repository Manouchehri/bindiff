/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.util.PublicCloneable;

public class StandardCategoryItemLabelGenerator
extends AbstractCategoryItemLabelGenerator
implements Serializable,
Cloneable,
CategoryItemLabelGenerator,
PublicCloneable {
    private static final long serialVersionUID = 3499701401211412882L;
    public static final String DEFAULT_LABEL_FORMAT_STRING = "{2}";

    public StandardCategoryItemLabelGenerator() {
        super("{2}", NumberFormat.getInstance());
    }

    public StandardCategoryItemLabelGenerator(String string, NumberFormat numberFormat) {
        super(string, numberFormat);
    }

    public StandardCategoryItemLabelGenerator(String string, NumberFormat numberFormat, NumberFormat numberFormat2) {
        super(string, numberFormat, numberFormat2);
    }

    public StandardCategoryItemLabelGenerator(String string, DateFormat dateFormat) {
        super(string, dateFormat);
    }

    @Override
    public String generateLabel(CategoryDataset categoryDataset, int n2, int n3) {
        return this.generateLabelString(categoryDataset, n2, n3);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof StandardCategoryItemLabelGenerator) return super.equals(object);
        return false;
    }
}

