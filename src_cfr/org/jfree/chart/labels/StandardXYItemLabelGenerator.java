/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class StandardXYItemLabelGenerator
extends AbstractXYItemLabelGenerator
implements Serializable,
Cloneable,
XYItemLabelGenerator,
PublicCloneable {
    private static final long serialVersionUID = 7807668053171837925L;
    public static final String DEFAULT_ITEM_LABEL_FORMAT = "{2}";

    public StandardXYItemLabelGenerator() {
        this("{2}", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
    }

    public StandardXYItemLabelGenerator(String string, NumberFormat numberFormat, NumberFormat numberFormat2) {
        super(string, numberFormat, numberFormat2);
    }

    public StandardXYItemLabelGenerator(String string, DateFormat dateFormat, NumberFormat numberFormat) {
        super(string, dateFormat, numberFormat);
    }

    public StandardXYItemLabelGenerator(String string, NumberFormat numberFormat, DateFormat dateFormat) {
        super(string, numberFormat, dateFormat);
    }

    public StandardXYItemLabelGenerator(String string, DateFormat dateFormat, DateFormat dateFormat2) {
        super(string, dateFormat, dateFormat2);
    }

    @Override
    public String generateLabel(XYDataset xYDataset, int n2, int n3) {
        return this.generateLabelString(xYDataset, n2, n3);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof StandardXYItemLabelGenerator) return super.equals(object);
        return false;
    }
}

