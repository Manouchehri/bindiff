/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.MessageFormat;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class StandardXYSeriesLabelGenerator
implements Serializable,
Cloneable,
XYSeriesLabelGenerator,
PublicCloneable {
    private static final long serialVersionUID = 1916017081848400024L;
    public static final String DEFAULT_LABEL_FORMAT = "{0}";
    private String formatPattern;

    public StandardXYSeriesLabelGenerator() {
        this("{0}");
    }

    public StandardXYSeriesLabelGenerator(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'format' argument.");
        }
        this.formatPattern = string;
    }

    @Override
    public String generateLabel(XYDataset xYDataset, int n2) {
        if (xYDataset != null) return MessageFormat.format(this.formatPattern, this.createItemArray(xYDataset, n2));
        throw new IllegalArgumentException("Null 'dataset' argument.");
    }

    protected Object[] createItemArray(XYDataset xYDataset, int n2) {
        Object[] arrobject = new Object[]{xYDataset.getSeriesKey(n2).toString()};
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
        if (!(object instanceof StandardXYSeriesLabelGenerator)) {
            return false;
        }
        StandardXYSeriesLabelGenerator standardXYSeriesLabelGenerator = (StandardXYSeriesLabelGenerator)object;
        if (this.formatPattern.equals(standardXYSeriesLabelGenerator.formatPattern)) return true;
        return false;
    }
}

