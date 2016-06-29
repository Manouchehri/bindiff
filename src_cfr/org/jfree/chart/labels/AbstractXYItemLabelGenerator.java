/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.ObjectUtilities;

public class AbstractXYItemLabelGenerator
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 5869744396278660636L;
    private String formatString;
    private NumberFormat xFormat;
    private DateFormat xDateFormat;
    private NumberFormat yFormat;
    private DateFormat yDateFormat;
    private String nullXString = "null";
    private String nullYString = "null";

    protected AbstractXYItemLabelGenerator() {
        this("{2}", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
    }

    protected AbstractXYItemLabelGenerator(String string, NumberFormat numberFormat, NumberFormat numberFormat2) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'formatString' argument.");
        }
        if (numberFormat == null) {
            throw new IllegalArgumentException("Null 'xFormat' argument.");
        }
        if (numberFormat2 == null) {
            throw new IllegalArgumentException("Null 'yFormat' argument.");
        }
        this.formatString = string;
        this.xFormat = numberFormat;
        this.yFormat = numberFormat2;
    }

    protected AbstractXYItemLabelGenerator(String string, DateFormat dateFormat, NumberFormat numberFormat) {
        this(string, NumberFormat.getInstance(), numberFormat);
        this.xDateFormat = dateFormat;
    }

    protected AbstractXYItemLabelGenerator(String string, NumberFormat numberFormat, DateFormat dateFormat) {
        this(string, numberFormat, NumberFormat.getInstance());
        this.yDateFormat = dateFormat;
    }

    protected AbstractXYItemLabelGenerator(String string, DateFormat dateFormat, DateFormat dateFormat2) {
        this(string, NumberFormat.getInstance(), NumberFormat.getInstance());
        this.xDateFormat = dateFormat;
        this.yDateFormat = dateFormat2;
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

    public String generateLabelString(XYDataset xYDataset, int n2, int n3) {
        String string = null;
        Object[] arrobject = this.createItemArray(xYDataset, n2, n3);
        return MessageFormat.format(this.formatString, arrobject);
    }

    protected Object[] createItemArray(XYDataset xYDataset, int n2, int n3) {
        Object[] arrobject = new Object[3];
        arrobject[0] = xYDataset.getSeriesKey(n2).toString();
        double d2 = xYDataset.getXValue(n2, n3);
        arrobject[1] = Double.isNaN(d2) && xYDataset.getX(n2, n3) == null ? this.nullXString : (this.xDateFormat != null ? this.xDateFormat.format(new Date((long)d2)) : this.xFormat.format(d2));
        double d3 = xYDataset.getYValue(n2, n3);
        if (Double.isNaN(d3) && xYDataset.getY(n2, n3) == null) {
            arrobject[2] = this.nullYString;
            return arrobject;
        }
        if (this.yDateFormat != null) {
            arrobject[2] = this.yDateFormat.format(new Date((long)d3));
            return arrobject;
        }
        arrobject[2] = this.yFormat.format(d3);
        return arrobject;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AbstractXYItemLabelGenerator)) {
            return false;
        }
        AbstractXYItemLabelGenerator abstractXYItemLabelGenerator = (AbstractXYItemLabelGenerator)object;
        if (!this.formatString.equals(abstractXYItemLabelGenerator.formatString)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.xFormat, abstractXYItemLabelGenerator.xFormat)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.xDateFormat, abstractXYItemLabelGenerator.xDateFormat)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.yFormat, abstractXYItemLabelGenerator.yFormat)) {
            return false;
        }
        if (ObjectUtilities.equal(this.yDateFormat, abstractXYItemLabelGenerator.yDateFormat)) return true;
        return false;
    }

    public Object clone() {
        AbstractXYItemLabelGenerator abstractXYItemLabelGenerator = (AbstractXYItemLabelGenerator)super.clone();
        if (this.xFormat != null) {
            abstractXYItemLabelGenerator.xFormat = (NumberFormat)this.xFormat.clone();
        }
        if (this.yFormat != null) {
            abstractXYItemLabelGenerator.yFormat = (NumberFormat)this.yFormat.clone();
        }
        if (this.xDateFormat != null) {
            abstractXYItemLabelGenerator.xDateFormat = (DateFormat)this.xDateFormat.clone();
        }
        if (this.yDateFormat == null) return abstractXYItemLabelGenerator;
        abstractXYItemLabelGenerator.yDateFormat = (DateFormat)this.yDateFormat.clone();
        return abstractXYItemLabelGenerator;
    }
}

