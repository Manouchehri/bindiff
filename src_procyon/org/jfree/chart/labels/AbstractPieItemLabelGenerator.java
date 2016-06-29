package org.jfree.chart.labels;

import java.io.*;
import org.jfree.data.general.*;
import java.text.*;

public class AbstractPieItemLabelGenerator implements Serializable
{
    private static final long serialVersionUID = 7347703325267846275L;
    private String labelFormat;
    private NumberFormat numberFormat;
    private NumberFormat percentFormat;
    
    protected AbstractPieItemLabelGenerator(final String labelFormat, final NumberFormat numberFormat, final NumberFormat percentFormat) {
        if (labelFormat == null) {
            throw new IllegalArgumentException("Null 'labelFormat' argument.");
        }
        if (numberFormat == null) {
            throw new IllegalArgumentException("Null 'numberFormat' argument.");
        }
        if (percentFormat == null) {
            throw new IllegalArgumentException("Null 'percentFormat' argument.");
        }
        this.labelFormat = labelFormat;
        this.numberFormat = numberFormat;
        this.percentFormat = percentFormat;
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
    
    protected Object[] createItemArray(final PieDataset pieDataset, final Comparable comparable) {
        final Object[] array = new Object[4];
        final double calculatePieDatasetTotal = DatasetUtilities.calculatePieDatasetTotal(pieDataset);
        array[0] = comparable.toString();
        final Number value = pieDataset.getValue(comparable);
        if (value != null) {
            array[1] = this.numberFormat.format(value);
        }
        else {
            array[1] = "null";
        }
        double n = 0.0;
        if (value != null) {
            final double doubleValue = value.doubleValue();
            if (doubleValue > 0.0) {
                n = doubleValue / calculatePieDatasetTotal;
            }
        }
        array[2] = this.percentFormat.format(n);
        array[3] = this.numberFormat.format(calculatePieDatasetTotal);
        return array;
    }
    
    protected String generateSectionLabel(final PieDataset pieDataset, final Comparable comparable) {
        String format = null;
        if (pieDataset != null) {
            format = MessageFormat.format(this.labelFormat, this.createItemArray(pieDataset, comparable));
        }
        return format;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AbstractPieItemLabelGenerator)) {
            return false;
        }
        final AbstractPieItemLabelGenerator abstractPieItemLabelGenerator = (AbstractPieItemLabelGenerator)o;
        return this.labelFormat.equals(abstractPieItemLabelGenerator.labelFormat) && this.numberFormat.equals(abstractPieItemLabelGenerator.numberFormat) && this.percentFormat.equals(abstractPieItemLabelGenerator.percentFormat);
    }
    
    public Object clone() {
        final AbstractPieItemLabelGenerator abstractPieItemLabelGenerator = (AbstractPieItemLabelGenerator)super.clone();
        if (this.numberFormat != null) {
            abstractPieItemLabelGenerator.numberFormat = (NumberFormat)this.numberFormat.clone();
        }
        if (this.percentFormat != null) {
            abstractPieItemLabelGenerator.percentFormat = (NumberFormat)this.percentFormat.clone();
        }
        return abstractPieItemLabelGenerator;
    }
}
