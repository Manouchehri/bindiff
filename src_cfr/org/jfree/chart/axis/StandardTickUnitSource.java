/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;

public class StandardTickUnitSource
implements TickUnitSource {
    private static final double LOG_10_VALUE = Math.log(10.0);

    @Override
    public TickUnit getLargerTickUnit(TickUnit tickUnit) {
        double d2 = tickUnit.getSize();
        double d3 = Math.log(d2) / LOG_10_VALUE;
        double d4 = Math.ceil(d3);
        return new NumberTickUnit(Math.pow(10.0, d4), new DecimalFormat("0.0E0"));
    }

    @Override
    public TickUnit getCeilingTickUnit(TickUnit tickUnit) {
        return this.getLargerTickUnit(tickUnit);
    }

    @Override
    public TickUnit getCeilingTickUnit(double d2) {
        double d3 = Math.log(d2) / LOG_10_VALUE;
        double d4 = Math.ceil(d3);
        return new NumberTickUnit(Math.pow(10.0, d4), new DecimalFormat("0.0E0"));
    }
}

