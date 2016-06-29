/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.MessageFormat;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.util.PublicCloneable;

public class StandardCategorySeriesLabelGenerator
implements Serializable,
Cloneable,
CategorySeriesLabelGenerator,
PublicCloneable {
    private static final long serialVersionUID = 4630760091523940820L;
    public static final String DEFAULT_LABEL_FORMAT = "{0}";
    private String formatPattern;

    public StandardCategorySeriesLabelGenerator() {
        this("{0}");
    }

    public StandardCategorySeriesLabelGenerator(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'format' argument.");
        }
        this.formatPattern = string;
    }

    @Override
    public String generateLabel(CategoryDataset categoryDataset, int n2) {
        if (categoryDataset != null) return MessageFormat.format(this.formatPattern, this.createItemArray(categoryDataset, n2));
        throw new IllegalArgumentException("Null 'dataset' argument.");
    }

    protected Object[] createItemArray(CategoryDataset categoryDataset, int n2) {
        Object[] arrobject = new Object[]{categoryDataset.getRowKey(n2).toString()};
        return arrobject;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StandardCategorySeriesLabelGenerator)) {
            return false;
        }
        StandardCategorySeriesLabelGenerator standardCategorySeriesLabelGenerator = (StandardCategorySeriesLabelGenerator)object;
        if (this.formatPattern.equals(standardCategorySeriesLabelGenerator.formatPattern)) return true;
        return false;
    }
}

