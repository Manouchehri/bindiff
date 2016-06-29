/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import org.jfree.data.DataUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public abstract class AbstractCategoryItemLabelGenerator
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -7108591260223293197L;
    private String labelFormat;
    private String nullValueString;
    private NumberFormat numberFormat;
    private DateFormat dateFormat;
    private NumberFormat percentFormat;

    protected AbstractCategoryItemLabelGenerator(String string, NumberFormat numberFormat) {
        this(string, numberFormat, NumberFormat.getPercentInstance());
    }

    protected AbstractCategoryItemLabelGenerator(String string, NumberFormat numberFormat, NumberFormat numberFormat2) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'labelFormat' argument.");
        }
        if (numberFormat == null) {
            throw new IllegalArgumentException("Null 'formatter' argument.");
        }
        if (numberFormat2 == null) {
            throw new IllegalArgumentException("Null 'percentFormatter' argument.");
        }
        this.labelFormat = string;
        this.numberFormat = numberFormat;
        this.percentFormat = numberFormat2;
        this.dateFormat = null;
        this.nullValueString = "-";
    }

    protected AbstractCategoryItemLabelGenerator(String string, DateFormat dateFormat) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'labelFormat' argument.");
        }
        if (dateFormat == null) {
            throw new IllegalArgumentException("Null 'formatter' argument.");
        }
        this.labelFormat = string;
        this.numberFormat = null;
        this.percentFormat = NumberFormat.getPercentInstance();
        this.dateFormat = dateFormat;
        this.nullValueString = "-";
    }

    public String generateRowLabel(CategoryDataset categoryDataset, int n2) {
        return categoryDataset.getRowKey(n2).toString();
    }

    public String generateColumnLabel(CategoryDataset categoryDataset, int n2) {
        return categoryDataset.getColumnKey(n2).toString();
    }

    public String getLabelFormat() {
        return this.labelFormat;
    }

    public NumberFormat getNumberFormat() {
        return this.numberFormat;
    }

    public DateFormat getDateFormat() {
        return this.dateFormat;
    }

    protected String generateLabelString(CategoryDataset categoryDataset, int n2, int n3) {
        if (categoryDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        String string = null;
        Object[] arrobject = this.createItemArray(categoryDataset, n2, n3);
        return MessageFormat.format(this.labelFormat, arrobject);
    }

    protected Object[] createItemArray(CategoryDataset categoryDataset, int n2, int n3) {
        Object[] arrobject = new Object[4];
        arrobject[0] = categoryDataset.getRowKey(n2).toString();
        arrobject[1] = categoryDataset.getColumnKey(n3).toString();
        Number number = categoryDataset.getValue(n2, n3);
        if (number != null) {
            if (this.numberFormat != null) {
                arrobject[2] = this.numberFormat.format(number);
            } else if (this.dateFormat != null) {
                arrobject[2] = this.dateFormat.format(number);
            }
        } else {
            arrobject[2] = this.nullValueString;
        }
        if (number == null) return arrobject;
        double d2 = DataUtilities.calculateColumnTotal(categoryDataset, n3);
        double d3 = number.doubleValue() / d2;
        arrobject[3] = this.percentFormat.format(d3);
        return arrobject;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AbstractCategoryItemLabelGenerator)) {
            return false;
        }
        AbstractCategoryItemLabelGenerator abstractCategoryItemLabelGenerator = (AbstractCategoryItemLabelGenerator)object;
        if (!this.labelFormat.equals(abstractCategoryItemLabelGenerator.labelFormat)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.dateFormat, abstractCategoryItemLabelGenerator.dateFormat)) {
            return false;
        }
        if (ObjectUtilities.equal(this.numberFormat, abstractCategoryItemLabelGenerator.numberFormat)) return true;
        return false;
    }

    @Override
    public Object clone() {
        AbstractCategoryItemLabelGenerator abstractCategoryItemLabelGenerator = (AbstractCategoryItemLabelGenerator)super.clone();
        if (this.numberFormat != null) {
            abstractCategoryItemLabelGenerator.numberFormat = (NumberFormat)this.numberFormat.clone();
        }
        if (this.dateFormat == null) return abstractCategoryItemLabelGenerator;
        abstractCategoryItemLabelGenerator.dateFormat = (DateFormat)this.dateFormat.clone();
        return abstractCategoryItemLabelGenerator;
    }
}

