/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.util.ObjectUtilities;

public class BubbleXYItemLabelGenerator
extends AbstractXYItemLabelGenerator
implements Serializable,
XYItemLabelGenerator {
    static final long serialVersionUID = -8458568928021240922L;
    public static final String DEFAULT_FORMAT_STRING = "{3}";
    private NumberFormat zFormat;
    private DateFormat zDateFormat;

    public BubbleXYItemLabelGenerator() {
        this("{3}", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
    }

    public BubbleXYItemLabelGenerator(String string, NumberFormat numberFormat, NumberFormat numberFormat2, NumberFormat numberFormat3) {
        super(string, numberFormat, numberFormat2);
        if (numberFormat3 == null) {
            throw new IllegalArgumentException("Null 'zFormat' argument.");
        }
        this.zFormat = numberFormat3;
    }

    public BubbleXYItemLabelGenerator(String string, DateFormat dateFormat, DateFormat dateFormat2, DateFormat dateFormat3) {
        super(string, dateFormat, dateFormat2);
        if (dateFormat3 == null) {
            throw new IllegalArgumentException("Null 'zFormat' argument.");
        }
        this.zDateFormat = dateFormat3;
    }

    public NumberFormat getZFormat() {
        return this.zFormat;
    }

    public DateFormat getZDateFormat() {
        return this.zDateFormat;
    }

    @Override
    public String generateLabel(XYDataset xYDataset, int n2, int n3) {
        return this.generateLabelString(xYDataset, n2, n3);
    }

    @Override
    public String generateLabelString(XYDataset xYDataset, int n2, int n3) {
        String string = null;
        Object[] arrobject = null;
        arrobject = xYDataset instanceof XYZDataset ? this.createItemArray((XYZDataset)xYDataset, n2, n3) : this.createItemArray(xYDataset, n2, n3);
        return MessageFormat.format(this.getFormatString(), arrobject);
    }

    protected Object[] createItemArray(XYZDataset xYZDataset, int n2, int n3) {
        Object[] arrobject = new Object[4];
        arrobject[0] = xYZDataset.getSeriesKey(n2).toString();
        Number number = xYZDataset.getX(n2, n3);
        DateFormat dateFormat = this.getXDateFormat();
        arrobject[1] = dateFormat != null ? dateFormat.format(number) : this.getXFormat().format(number);
        Number number2 = xYZDataset.getY(n2, n3);
        DateFormat dateFormat2 = this.getYDateFormat();
        arrobject[2] = dateFormat2 != null ? dateFormat2.format(number2) : this.getYFormat().format(number2);
        Number number3 = xYZDataset.getZ(n2, n3);
        if (this.zDateFormat != null) {
            arrobject[3] = this.zDateFormat.format(number3);
            return arrobject;
        }
        arrobject[3] = this.zFormat.format(number3);
        return arrobject;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BubbleXYItemLabelGenerator)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        BubbleXYItemLabelGenerator bubbleXYItemLabelGenerator = (BubbleXYItemLabelGenerator)object;
        if (!ObjectUtilities.equal(this.zFormat, bubbleXYItemLabelGenerator.zFormat)) {
            return false;
        }
        if (ObjectUtilities.equal(this.zDateFormat, bubbleXYItemLabelGenerator.zDateFormat)) return true;
        return false;
    }
}

