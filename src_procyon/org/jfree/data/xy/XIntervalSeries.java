package org.jfree.data.xy;

import org.jfree.data.*;

public class XIntervalSeries extends ComparableObjectSeries
{
    public XIntervalSeries(final Comparable comparable) {
        this(comparable, true, true);
    }
    
    public XIntervalSeries(final Comparable comparable, final boolean b, final boolean b2) {
        super(comparable, b, b2);
    }
    
    public void add(final double n, final double n2, final double n3, final double n4) {
        super.add(new XIntervalDataItem(n, n2, n3, n4), true);
    }
    
    public Number getX(final int n) {
        return ((XIntervalDataItem)this.getDataItem(n)).getX();
    }
    
    public double getYValue(final int n) {
        return ((XIntervalDataItem)this.getDataItem(n)).getYValue();
    }
    
    public ComparableObjectItem getDataItem(final int n) {
        return super.getDataItem(n);
    }
}
