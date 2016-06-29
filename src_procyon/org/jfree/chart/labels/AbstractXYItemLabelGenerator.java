package org.jfree.chart.labels;

import java.io.*;
import org.jfree.data.xy.*;
import java.text.*;
import java.util.*;
import org.jfree.util.*;

public class AbstractXYItemLabelGenerator implements Serializable, Cloneable
{
    private static final long serialVersionUID = 5869744396278660636L;
    private String formatString;
    private NumberFormat xFormat;
    private DateFormat xDateFormat;
    private NumberFormat yFormat;
    private DateFormat yDateFormat;
    private String nullXString;
    private String nullYString;
    
    protected AbstractXYItemLabelGenerator() {
        this("{2}", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
    }
    
    protected AbstractXYItemLabelGenerator(final String formatString, final NumberFormat xFormat, final NumberFormat yFormat) {
        this.nullXString = "null";
        this.nullYString = "null";
        if (formatString == null) {
            throw new IllegalArgumentException("Null 'formatString' argument.");
        }
        if (xFormat == null) {
            throw new IllegalArgumentException("Null 'xFormat' argument.");
        }
        if (yFormat == null) {
            throw new IllegalArgumentException("Null 'yFormat' argument.");
        }
        this.formatString = formatString;
        this.xFormat = xFormat;
        this.yFormat = yFormat;
    }
    
    protected AbstractXYItemLabelGenerator(final String s, final DateFormat xDateFormat, final NumberFormat numberFormat) {
        this(s, NumberFormat.getInstance(), numberFormat);
        this.xDateFormat = xDateFormat;
    }
    
    protected AbstractXYItemLabelGenerator(final String s, final NumberFormat numberFormat, final DateFormat yDateFormat) {
        this(s, numberFormat, NumberFormat.getInstance());
        this.yDateFormat = yDateFormat;
    }
    
    protected AbstractXYItemLabelGenerator(final String s, final DateFormat xDateFormat, final DateFormat yDateFormat) {
        this(s, NumberFormat.getInstance(), NumberFormat.getInstance());
        this.xDateFormat = xDateFormat;
        this.yDateFormat = yDateFormat;
    }
    
    public String getFormatString() {
        return this.formatString;
    }
    
    public NumberFormat getXFormat() {
        return this.xFormat;
    }
    
    public DateFormat getXDateFormat() {
        return this.xDateFormat;
    }
    
    public NumberFormat getYFormat() {
        return this.yFormat;
    }
    
    public DateFormat getYDateFormat() {
        return this.yDateFormat;
    }
    
    public String generateLabelString(final XYDataset xyDataset, final int n, final int n2) {
        return MessageFormat.format(this.formatString, this.createItemArray(xyDataset, n, n2));
    }
    
    protected Object[] createItemArray(final XYDataset xyDataset, final int n, final int n2) {
        final Object[] array = { xyDataset.getSeriesKey(n).toString(), null, null };
        final double xValue = xyDataset.getXValue(n, n2);
        if (Double.isNaN(xValue) && xyDataset.getX(n, n2) == null) {
            array[1] = this.nullXString;
        }
        else if (this.xDateFormat != null) {
            array[1] = this.xDateFormat.format(new Date((long)xValue));
        }
        else {
            array[1] = this.xFormat.format(xValue);
        }
        final double yValue = xyDataset.getYValue(n, n2);
        if (Double.isNaN(yValue) && xyDataset.getY(n, n2) == null) {
            array[2] = this.nullYString;
        }
        else if (this.yDateFormat != null) {
            array[2] = this.yDateFormat.format(new Date((long)yValue));
        }
        else {
            array[2] = this.yFormat.format(yValue);
        }
        return array;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AbstractXYItemLabelGenerator)) {
            return false;
        }
        final AbstractXYItemLabelGenerator abstractXYItemLabelGenerator = (AbstractXYItemLabelGenerator)o;
        return this.formatString.equals(abstractXYItemLabelGenerator.formatString) && ObjectUtilities.equal(this.xFormat, abstractXYItemLabelGenerator.xFormat) && ObjectUtilities.equal(this.xDateFormat, abstractXYItemLabelGenerator.xDateFormat) && ObjectUtilities.equal(this.yFormat, abstractXYItemLabelGenerator.yFormat) && ObjectUtilities.equal(this.yDateFormat, abstractXYItemLabelGenerator.yDateFormat);
    }
    
    public Object clone() {
        final AbstractXYItemLabelGenerator abstractXYItemLabelGenerator = (AbstractXYItemLabelGenerator)super.clone();
        if (this.xFormat != null) {
            abstractXYItemLabelGenerator.xFormat = (NumberFormat)this.xFormat.clone();
        }
        if (this.yFormat != null) {
            abstractXYItemLabelGenerator.yFormat = (NumberFormat)this.yFormat.clone();
        }
        if (this.xDateFormat != null) {
            abstractXYItemLabelGenerator.xDateFormat = (DateFormat)this.xDateFormat.clone();
        }
        if (this.yDateFormat != null) {
            abstractXYItemLabelGenerator.yDateFormat = (DateFormat)this.yDateFormat.clone();
        }
        return abstractXYItemLabelGenerator;
    }
}
