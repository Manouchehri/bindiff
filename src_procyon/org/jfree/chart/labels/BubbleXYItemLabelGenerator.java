package org.jfree.chart.labels;

import java.io.*;
import org.jfree.data.xy.*;
import java.text.*;
import org.jfree.util.*;

public class BubbleXYItemLabelGenerator extends AbstractXYItemLabelGenerator implements Serializable, XYItemLabelGenerator
{
    static final long serialVersionUID = -8458568928021240922L;
    public static final String DEFAULT_FORMAT_STRING = "{3}";
    private NumberFormat zFormat;
    private DateFormat zDateFormat;
    
    public BubbleXYItemLabelGenerator() {
        this("{3}", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
    }
    
    public BubbleXYItemLabelGenerator(final String s, final NumberFormat numberFormat, final NumberFormat numberFormat2, final NumberFormat zFormat) {
        super(s, numberFormat, numberFormat2);
        if (zFormat == null) {
            throw new IllegalArgumentException("Null 'zFormat' argument.");
        }
        this.zFormat = zFormat;
    }
    
    public BubbleXYItemLabelGenerator(final String s, final DateFormat dateFormat, final DateFormat dateFormat2, final DateFormat zDateFormat) {
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
    
    public String generateLabel(final XYDataset xyDataset, final int n, final int n2) {
        return this.generateLabelString(xyDataset, n, n2);
    }
    
    public String generateLabelString(final XYDataset xyDataset, final int n, final int n2) {
        Object[] array;
        if (xyDataset instanceof XYZDataset) {
            array = this.createItemArray((XYZDataset)xyDataset, n, n2);
        }
        else {
            array = this.createItemArray(xyDataset, n, n2);
        }
        return MessageFormat.format(this.getFormatString(), array);
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
        if (!(o instanceof BubbleXYItemLabelGenerator)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final BubbleXYItemLabelGenerator bubbleXYItemLabelGenerator = (BubbleXYItemLabelGenerator)o;
        return ObjectUtilities.equal(this.zFormat, bubbleXYItemLabelGenerator.zFormat) && ObjectUtilities.equal(this.zDateFormat, bubbleXYItemLabelGenerator.zDateFormat);
    }
}
