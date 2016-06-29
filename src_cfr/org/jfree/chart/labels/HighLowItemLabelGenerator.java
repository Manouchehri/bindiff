/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class HighLowItemLabelGenerator
implements Serializable,
Cloneable,
XYItemLabelGenerator,
XYToolTipGenerator,
PublicCloneable {
    private static final long serialVersionUID = 5617111754832211830L;
    private DateFormat dateFormatter;
    private NumberFormat numberFormatter;

    public HighLowItemLabelGenerator() {
        this(DateFormat.getInstance(), NumberFormat.getInstance());
    }

    public HighLowItemLabelGenerator(DateFormat dateFormat, NumberFormat numberFormat) {
        if (dateFormat == null) {
            throw new IllegalArgumentException("Null 'dateFormatter' argument.");
        }
        if (numberFormat == null) {
            throw new IllegalArgumentException("Null 'numberFormatter' argument.");
        }
        this.dateFormatter = dateFormat;
        this.numberFormatter = numberFormat;
    }

    @Override
    public String generateToolTip(XYDataset xYDataset, int n2, int n3) {
        String string = null;
        if (!(xYDataset instanceof OHLCDataset)) return string;
        OHLCDataset oHLCDataset = (OHLCDataset)xYDataset;
        Number number = oHLCDataset.getHigh(n2, n3);
        Number number2 = oHLCDataset.getLow(n2, n3);
        Number number3 = oHLCDataset.getOpen(n2, n3);
        Number number4 = oHLCDataset.getClose(n2, n3);
        Number number5 = oHLCDataset.getX(n2, n3);
        string = oHLCDataset.getSeriesKey(n2).toString();
        if (number5 == null) return string;
        Date date = new Date(number5.longValue());
        string = new StringBuffer().append(string).append("--> Date=").append(this.dateFormatter.format(date)).toString();
        if (number != null) {
            string = new StringBuffer().append(string).append(" High=").append(this.numberFormatter.format(number.doubleValue())).toString();
        }
        if (number2 != null) {
            string = new StringBuffer().append(string).append(" Low=").append(this.numberFormatter.format(number2.doubleValue())).toString();
        }
        if (number3 != null) {
            string = new StringBuffer().append(string).append(" Open=").append(this.numberFormatter.format(number3.doubleValue())).toString();
        }
        if (number4 == null) return string;
        return new StringBuffer().append(string).append(" Close=").append(this.numberFormatter.format(number4.doubleValue())).toString();
    }

    @Override
    public String generateLabel(XYDataset xYDataset, int n2, int n3) {
        return null;
    }

    @Override
    public Object clone() {
        HighLowItemLabelGenerator highLowItemLabelGenerator = (HighLowItemLabelGenerator)super.clone();
        if (this.dateFormatter != null) {
            highLowItemLabelGenerator.dateFormatter = (DateFormat)this.dateFormatter.clone();
        }
        if (this.numberFormatter == null) return highLowItemLabelGenerator;
        highLowItemLabelGenerator.numberFormatter = (NumberFormat)this.numberFormatter.clone();
        return highLowItemLabelGenerator;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof HighLowItemLabelGenerator)) {
            return false;
        }
        HighLowItemLabelGenerator highLowItemLabelGenerator = (HighLowItemLabelGenerator)object;
        if (!this.dateFormatter.equals(highLowItemLabelGenerator.dateFormatter)) {
            return false;
        }
        if (this.numberFormatter.equals(highLowItemLabelGenerator.numberFormatter)) return true;
        return false;
    }
}

