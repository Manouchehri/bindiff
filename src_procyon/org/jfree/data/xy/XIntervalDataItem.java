package org.jfree.data.xy;

import org.jfree.data.*;

public class XIntervalDataItem extends ComparableObjectItem
{
    public XIntervalDataItem(final double n, final double n2, final double n3, final double n4) {
        super(new Double(n), new YWithXInterval(n4, n2, n3));
    }
    
    public Number getX() {
        return (Number)this.getComparable();
    }
    
    public double getYValue() {
        final YWithXInterval yWithXInterval = (YWithXInterval)this.getObject();
        if (yWithXInterval != null) {
            return yWithXInterval.getY();
        }
        return Double.NaN;
    }
    
    public double getXLowValue() {
        final YWithXInterval yWithXInterval = (YWithXInterval)this.getObject();
        if (yWithXInterval != null) {
            return yWithXInterval.getXLow();
        }
        return Double.NaN;
    }
    
    public double getXHighValue() {
        final YWithXInterval yWithXInterval = (YWithXInterval)this.getObject();
        if (yWithXInterval != null) {
            return yWithXInterval.getXHigh();
        }
        return Double.NaN;
    }
}
