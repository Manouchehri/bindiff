package org.jfree.data.xy;

public abstract class AbstractIntervalXYDataset extends AbstractXYDataset implements IntervalXYDataset
{
    public double getStartXValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number startX = this.getStartX(n, n2);
        if (startX != null) {
            doubleValue = startX.doubleValue();
        }
        return doubleValue;
    }
    
    public double getEndXValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number endX = this.getEndX(n, n2);
        if (endX != null) {
            doubleValue = endX.doubleValue();
        }
        return doubleValue;
    }
    
    public double getStartYValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number startY = this.getStartY(n, n2);
        if (startY != null) {
            doubleValue = startY.doubleValue();
        }
        return doubleValue;
    }
    
    public double getEndYValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number endY = this.getEndY(n, n2);
        if (endY != null) {
            doubleValue = endY.doubleValue();
        }
        return doubleValue;
    }
}
