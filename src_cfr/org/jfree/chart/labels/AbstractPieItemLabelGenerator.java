/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.MessageFormat;
import java.text.NumberFormat;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.PieDataset;

public class AbstractPieItemLabelGenerator
implements Serializable {
    private static final long serialVersionUID = 7347703325267846275L;
    private String labelFormat;
    private NumberFormat numberFormat;
    private NumberFormat percentFormat;

    protected AbstractPieItemLabelGenerator(String string, NumberFormat numberFormat, NumberFormat numberFormat2) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'labelFormat' argument.");
        }
        if (numberFormat == null) {
            throw new IllegalArgumentException("Null 'numberFormat' argument.");
        }
        if (numberFormat2 == null) {
            throw new IllegalArgumentException("Null 'percentFormat' argument.");
        }
        this.labelFormat = string;
        this.numberFormat = numberFormat;
        this.percentFormat = numberFormat2;
    }

    public String getLabelFormat() {
        return this.labelFormat;
    }

    public NumberFormat getNumberFormat() {
        return this.numberFormat;
    }

    public NumberFormat getPercentFormat() {
        return this.percentFormat;
    }

    protected Object[] createItemArray(PieDataset pieDataset, Comparable comparable) {
        double d2;
        Object[] arrobject = new Object[4];
        double d3 = DatasetUtilities.calculatePieDatasetTotal(pieDataset);
        arrobject[0] = comparable.toString();
        Number number = pieDataset.getValue(comparable);
        arrobject[1] = number != null ? this.numberFormat.format(number) : "null";
        double d4 = 0.0;
        if (number != null && (d2 = number.doubleValue()) > 0.0) {
            d4 = d2 / d3;
        }
        arrobject[2] = this.percentFormat.format(d4);
        arrobject[3] = this.numberFormat.format(d3);
        return arrobject;
    }

    protected String generateSectionLabel(PieDataset pieDataset, Comparable comparable) {
        String string = null;
        if (pieDataset == null) return string;
        Object[] arrobject = this.createItemArray(pieDataset, comparable);
        return MessageFormat.format(this.labelFormat, arrobject);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AbstractPieItemLabelGenerator)) {
            return false;
        }
        AbstractPieItemLabelGenerator abstractPieItemLabelGenerator = (AbstractPieItemLabelGenerator)object;
        if (!this.labelFormat.equals(abstractPieItemLabelGenerator.labelFormat)) {
            return false;
        }
        if (!this.numberFormat.equals(abstractPieItemLabelGenerator.numberFormat)) {
            return false;
        }
        if (this.percentFormat.equals(abstractPieItemLabelGenerator.percentFormat)) return true;
        return false;
    }

    public Object clone() {
        AbstractPieItemLabelGenerator abstractPieItemLabelGenerator = (AbstractPieItemLabelGenerator)super.clone();
        if (this.numberFormat != null) {
            abstractPieItemLabelGenerator.numberFormat = (NumberFormat)this.numberFormat.clone();
        }
        if (this.percentFormat == null) return abstractPieItemLabelGenerator;
        abstractPieItemLabelGenerator.percentFormat = (NumberFormat)this.percentFormat.clone();
        return abstractPieItemLabelGenerator;
    }
}

