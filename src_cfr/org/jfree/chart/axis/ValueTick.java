/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import org.jfree.chart.axis.Tick;
import org.jfree.ui.TextAnchor;

public abstract class ValueTick
extends Tick {
    private double value;

    public ValueTick(double d2, String string, TextAnchor textAnchor, TextAnchor textAnchor2, double d3) {
        super(string, textAnchor, textAnchor2, d3);
        this.value = d2;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ValueTick)) return false;
        if (!super.equals(object)) return false;
        ValueTick valueTick = (ValueTick)object;
        if (this.value == valueTick.value) return true;
        return false;
    }
}

