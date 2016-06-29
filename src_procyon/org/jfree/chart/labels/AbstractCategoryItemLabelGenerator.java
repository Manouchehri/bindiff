package org.jfree.chart.labels;

import java.io.*;
import org.jfree.data.category.*;
import java.text.*;
import org.jfree.data.*;
import org.jfree.util.*;

public abstract class AbstractCategoryItemLabelGenerator implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -7108591260223293197L;
    private String labelFormat;
    private String nullValueString;
    private NumberFormat numberFormat;
    private DateFormat dateFormat;
    private NumberFormat percentFormat;
    
    protected AbstractCategoryItemLabelGenerator(final String s, final NumberFormat numberFormat) {
        this(s, numberFormat, NumberFormat.getPercentInstance());
    }
    
    protected AbstractCategoryItemLabelGenerator(final String labelFormat, final NumberFormat numberFormat, final NumberFormat percentFormat) {
        if (labelFormat == null) {
            throw new IllegalArgumentException("Null 'labelFormat' argument.");
        }
        if (numberFormat == null) {
            throw new IllegalArgumentException("Null 'formatter' argument.");
        }
        if (percentFormat == null) {
            throw new IllegalArgumentException("Null 'percentFormatter' argument.");
        }
        this.labelFormat = labelFormat;
        this.numberFormat = numberFormat;
        this.percentFormat = percentFormat;
        this.dateFormat = null;
        this.nullValueString = "-";
    }
    
    protected AbstractCategoryItemLabelGenerator(final String labelFormat, final DateFormat dateFormat) {
        if (labelFormat == null) {
            throw new IllegalArgumentException("Null 'labelFormat' argument.");
        }
        if (dateFormat == null) {
            throw new IllegalArgumentException("Null 'formatter' argument.");
        }
        this.labelFormat = labelFormat;
        this.numberFormat = null;
        this.percentFormat = NumberFormat.getPercentInstance();
        this.dateFormat = dateFormat;
        this.nullValueString = "-";
    }
    
    public String generateRowLabel(final CategoryDataset categoryDataset, final int n) {
        return categoryDataset.getRowKey(n).toString();
    }
    
    public String generateColumnLabel(final CategoryDataset categoryDataset, final int n) {
        return categoryDataset.getColumnKey(n).toString();
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
    
    protected String generateLabelString(final CategoryDataset categoryDataset, final int n, final int n2) {
        if (categoryDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        return MessageFormat.format(this.labelFormat, this.createItemArray(categoryDataset, n, n2));
    }
    
    protected Object[] createItemArray(final CategoryDataset categoryDataset, final int n, final int n2) {
        final Object[] array = { categoryDataset.getRowKey(n).toString(), categoryDataset.getColumnKey(n2).toString(), null, null };
        final Number value = categoryDataset.getValue(n, n2);
        if (value != null) {
            if (this.numberFormat != null) {
                array[2] = this.numberFormat.format(value);
            }
            else if (this.dateFormat != null) {
                array[2] = this.dateFormat.format(value);
            }
        }
        else {
            array[2] = this.nullValueString;
        }
        if (value != null) {
            array[3] = this.percentFormat.format(value.doubleValue() / DataUtilities.calculateColumnTotal(categoryDataset, n2));
        }
        return array;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AbstractCategoryItemLabelGenerator)) {
            return false;
        }
        final AbstractCategoryItemLabelGenerator abstractCategoryItemLabelGenerator = (AbstractCategoryItemLabelGenerator)o;
        return this.labelFormat.equals(abstractCategoryItemLabelGenerator.labelFormat) && ObjectUtilities.equal(this.dateFormat, abstractCategoryItemLabelGenerator.dateFormat) && ObjectUtilities.equal(this.numberFormat, abstractCategoryItemLabelGenerator.numberFormat);
    }
    
    public Object clone() {
        final AbstractCategoryItemLabelGenerator abstractCategoryItemLabelGenerator = (AbstractCategoryItemLabelGenerator)super.clone();
        if (this.numberFormat != null) {
            abstractCategoryItemLabelGenerator.numberFormat = (NumberFormat)this.numberFormat.clone();
        }
        if (this.dateFormat != null) {
            abstractCategoryItemLabelGenerator.dateFormat = (DateFormat)this.dateFormat.clone();
        }
        return abstractCategoryItemLabelGenerator;
    }
}
