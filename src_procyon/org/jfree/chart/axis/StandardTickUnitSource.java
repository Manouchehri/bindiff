package org.jfree.chart.axis;

import java.text.*;

public class StandardTickUnitSource implements TickUnitSource
{
    private static final double LOG_10_VALUE;
    
    public TickUnit getLargerTickUnit(final TickUnit tickUnit) {
        return new NumberTickUnit(Math.pow(10.0, Math.ceil(Math.log(tickUnit.getSize()) / StandardTickUnitSource.LOG_10_VALUE)), new DecimalFormat("0.0E0"));
    }
    
    public TickUnit getCeilingTickUnit(final TickUnit tickUnit) {
        return this.getLargerTickUnit(tickUnit);
    }
    
    public TickUnit getCeilingTickUnit(final double n) {
        return new NumberTickUnit(Math.pow(10.0, Math.ceil(Math.log(n) / StandardTickUnitSource.LOG_10_VALUE)), new DecimalFormat("0.0E0"));
    }
    
    static {
        LOG_10_VALUE = Math.log(10.0);
    }
}
