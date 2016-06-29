package org.jfree.data.xy;

import org.jfree.data.*;

public class YIntervalDataItem extends ComparableObjectItem
{
    public YIntervalDataItem(final double n, final double n2, final double n3, final double n4) {
        super(new Double(n), new YInterval(n2, n3, n4));
    }
    
    public Double getX() {
        return (Double)this.getComparable();
    }
    
    public double getYValue() {
        final YInterval yInterval = (YInterval)this.getObject();
        if (yInterval != null) {
            return yInterval.getY();
        }
        return Double.NaN;
    }
    
    public double getYLowValue() {
        final YInterval yInterval = (YInterval)this.getObject();
        if (yInterval != null) {
            return yInterval.getYLow();
        }
        return Double.NaN;
    }
    
    public double getYHighValue() {
        final YInterval yInterval = (YInterval)this.getObject();
        if (yInterval != null) {
            return yInterval.getYHigh();
        }
        return Double.NaN;
    }
}
