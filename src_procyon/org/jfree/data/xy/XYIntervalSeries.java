package org.jfree.data.xy;

import org.jfree.data.*;

public class XYIntervalSeries extends ComparableObjectSeries
{
    public XYIntervalSeries(final Comparable comparable) {
        this(comparable, true, true);
    }
    
    public XYIntervalSeries(final Comparable comparable, final boolean b, final boolean b2) {
        super(comparable, b, b2);
    }
    
    public void add(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        super.add(new XYIntervalDataItem(n, n2, n3, n4, n5, n6), true);
    }
    
    public Number getX(final int n) {
        return ((XYIntervalDataItem)this.getDataItem(n)).getX();
    }
    
    public double getXLowValue(final int n) {
        return ((XYIntervalDataItem)this.getDataItem(n)).getXLowValue();
    }
    
    public double getXHighValue(final int n) {
        return ((XYIntervalDataItem)this.getDataItem(n)).getXHighValue();
    }
    
    public double getYValue(final int n) {
        return ((XYIntervalDataItem)this.getDataItem(n)).getYValue();
    }
    
    public double getYLowValue(final int n) {
        return ((XYIntervalDataItem)this.getDataItem(n)).getYLowValue();
    }
    
    public double getYHighValue(final int n) {
        return ((XYIntervalDataItem)this.getDataItem(n)).getYHighValue();
    }
    
    public ComparableObjectItem getDataItem(final int n) {
        return super.getDataItem(n);
    }
}
