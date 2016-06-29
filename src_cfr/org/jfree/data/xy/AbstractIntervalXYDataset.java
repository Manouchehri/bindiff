/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.IntervalXYDataset;

public abstract class AbstractIntervalXYDataset
extends AbstractXYDataset
implements IntervalXYDataset {
    @Override
    public double getStartXValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getStartX(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }

    @Override
    public double getEndXValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getEndX(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }

    @Override
    public double getStartYValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getStartY(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }

    @Override
    public double getEndYValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getEndY(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }
}

