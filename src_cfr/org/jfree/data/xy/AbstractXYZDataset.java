/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYZDataset;

public abstract class AbstractXYZDataset
extends AbstractXYDataset
implements XYZDataset {
    @Override
    public double getZValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getZ(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }
}

