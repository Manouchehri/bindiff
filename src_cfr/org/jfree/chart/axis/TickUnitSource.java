/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import org.jfree.chart.axis.TickUnit;

public interface TickUnitSource {
    public TickUnit getLargerTickUnit(TickUnit var1);

    public TickUnit getCeilingTickUnit(TickUnit var1);

    public TickUnit getCeilingTickUnit(double var1);
}

