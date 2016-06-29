/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.DomainOrder;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.xy.XYDataset;

public abstract class AbstractXYDataset
extends AbstractSeriesDataset
implements XYDataset {
    @Override
    public DomainOrder getDomainOrder() {
        return DomainOrder.NONE;
    }

    @Override
    public double getXValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getX(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }

    @Override
    public double getYValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getY(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }
}

