package org.jfree.chart.labels;

import java.io.*;
import org.jfree.data.xy.*;
import java.text.*;
import org.jfree.util.*;

public class StandardXYZToolTipGenerator extends StandardXYToolTipGenerator implements Serializable, XYZToolTipGenerator
{
    private static final long serialVersionUID = -2961577421889473503L;
    public static final String DEFAULT_TOOL_TIP_FORMAT = "{0}: ({1}, {2}, {3})";
    private NumberFormat zFormat;
    private DateFormat zDateFormat;
    
    public StandardXYZToolTipGenerator() {
        this("{0}: ({1}, {2}, {3})", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
    }
    
    public StandardXYZToolTipGenerator(final String s, final NumberFormat numberFormat, final NumberFormat numberFormat2, final NumberFormat zFormat) {
        super(s, numberFormat, numberFormat2);
        if (zFormat == null) {
            throw new IllegalArgumentException("Null 'zFormat' argument.");
        }
        this.zFormat = zFormat;
    }
    
    public StandardXYZToolTipGenerator(final String s, final DateFormat dateFormat, final DateFormat dateFormat2, final DateFormat zDateFormat) {
        super(s, dateFormat, dateFormat2);
        if (zDateFormat == null) {
            throw new IllegalArgumentException("Null 'zFormat' argument.");
        }
        this.zDateFormat = zDateFormat;
    }
    
    public NumberFormat getZFormat() {
        return this.zFormat;
    }
    
    public DateFormat getZDateFormat() {
        return this.zDateFormat;
    }
    
    public String generateToolTip(final XYZDataset xyzDataset, final int n, final int n2) {
        return this.generateLabelString(xyzDataset, n, n2);
    }
    
    public String generateLabelString(final XYDataset xyDataset, final int n, final int n2) {
        return MessageFormat.format(this.getFormatString(), this.createItemArray((XYZDataset)xyDataset, n, n2));
    }
    
    protected Object[] createItemArray(final XYZDataset xyzDataset, final int n, final int n2) {
        final Object[] array = new Object[4];
        array[0] = xyzDataset.getSeriesKey(n).toString();
        final Number x = xyzDataset.getX(n, n2);
        final DateFormat xDateFormat = this.getXDateFormat();
        if (xDateFormat != null) {
            array[1] = xDateFormat.format(x);
        }
        else {
            array[1] = this.getXFormat().format(x);
        }
        final Number y = xyzDataset.getY(n, n2);
        final DateFormat yDateFormat = this.getYDateFormat();
        if (yDateFormat != null) {
            array[2] = yDateFormat.format(y);
        }
        else {
            array[2] = this.getYFormat().format(y);
        }
        final Number z = xyzDataset.getZ(n, n2);
        if (this.zDateFormat != null) {
            array[3] = this.zDateFormat.format(z);
        }
        else {
            array[3] = this.zFormat.format(z);
        }
        return array;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StandardXYZToolTipGenerator)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final StandardXYZToolTipGenerator standardXYZToolTipGenerator = (StandardXYZToolTipGenerator)o;
        return ObjectUtilities.equal(this.zFormat, standardXYZToolTipGenerator.zFormat) && ObjectUtilities.equal(this.zDateFormat, standardXYZToolTipGenerator.zDateFormat);
    }
}
