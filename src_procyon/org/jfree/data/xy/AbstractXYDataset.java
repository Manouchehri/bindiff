package org.jfree.data.xy;

import org.jfree.data.general.*;
import org.jfree.data.*;

public abstract class AbstractXYDataset extends AbstractSeriesDataset implements XYDataset
{
    public DomainOrder getDomainOrder() {
        return DomainOrder.NONE;
    }
    
    public double getXValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number x = this.getX(n, n2);
        if (x != null) {
            doubleValue = x.doubleValue();
        }
        return doubleValue;
    }
    
    public double getYValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number y = this.getY(n, n2);
        if (y != null) {
            doubleValue = y.doubleValue();
        }
        return doubleValue;
    }
}
