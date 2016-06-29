/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYZToolTipGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.util.ObjectUtilities;

public class StandardXYZToolTipGenerator
extends StandardXYToolTipGenerator
implements Serializable,
XYZToolTipGenerator {
    private static final long serialVersionUID = -2961577421889473503L;
    public static final String DEFAULT_TOOL_TIP_FORMAT = "{0}: ({1}, {2}, {3})";
    private NumberFormat zFormat;
    private DateFormat zDateFormat;

    public StandardXYZToolTipGenerator() {
        this("{0}: ({1}, {2}, {3})", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
    }

    public StandardXYZToolTipGenerator(String string, NumberFormat numberFormat, NumberFormat numberFormat2, NumberFormat numberFormat3) {
        super(string, numberFormat, numberFormat2);
        if (numberFormat3 == null) {
            throw new IllegalArgumentException("Null 'zFormat' argument.");
        }
        this.zFormat = numberFormat3;
    }

    public StandardXYZToolTipGenerator(String string, DateFormat dateFormat, DateFormat dateFormat2, DateFormat dateFormat3) {
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
    public String generateToolTip(XYZDataset xYZDataset, int n2, int n3) {
        return this.generateLabelString(xYZDataset, n2, n3);
    }

    @Override
    public String generateLabelString(XYDataset xYDataset, int n2, int n3) {
        String string = null;
        Object[] arrobject = this.createItemArray((XYZDataset)xYDataset, n2, n3);
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
        if (!(object instanceof StandardXYZToolTipGenerator)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        StandardXYZToolTipGenerator standardXYZToolTipGenerator = (StandardXYZToolTipGenerator)object;
        if (!ObjectUtilities.equal(this.zFormat, standardXYZToolTipGenerator.zFormat)) {
            return false;
        }
        if (ObjectUtilities.equal(this.zDateFormat, standardXYZToolTipGenerator.zDateFormat)) return true;
        return false;
    }
}

