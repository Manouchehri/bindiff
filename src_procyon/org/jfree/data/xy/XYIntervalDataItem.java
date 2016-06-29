package org.jfree.data.xy;

import org.jfree.data.*;

public class XYIntervalDataItem extends ComparableObjectItem
{
    public XYIntervalDataItem(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        super(new Double(n), new XYInterval(n2, n3, n4, n5, n6));
    }
    
    public Double getX() {
        return (Double)this.getComparable();
    }
    
    public double getYValue() {
        final XYInterval xyInterval = (XYInterval)this.getObject();
        if (xyInterval != null) {
            return xyInterval.getY();
        }
        return Double.NaN;
    }
    
    public double getXLowValue() {
        final XYInterval xyInterval = (XYInterval)this.getObject();
        if (xyInterval != null) {
            return xyInterval.getXLow();
        }
        return Double.NaN;
    }
    
    public double getXHighValue() {
        final XYInterval xyInterval = (XYInterval)this.getObject();
        if (xyInterval != null) {
            return xyInterval.getXHigh();
        }
        return Double.NaN;
    }
    
    public double getYLowValue() {
        final XYInterval xyInterval = (XYInterval)this.getObject();
        if (xyInterval != null) {
            return xyInterval.getYLow();
        }
        return Double.NaN;
    }
    
    public double getYHighValue() {
        final XYInterval xyInterval = (XYInterval)this.getObject();
        if (xyInterval != null) {
            return xyInterval.getYHigh();
        }
        return Double.NaN;
    }
}
