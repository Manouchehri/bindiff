/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import org.jfree.chart.axis.ValueTick;
import org.jfree.ui.TextAnchor;

public class NumberTick
extends ValueTick {
    private Number number;

    public NumberTick(Number number, String string, TextAnchor textAnchor, TextAnchor textAnchor2, double d2) {
        super(number.doubleValue(), string, textAnchor, textAnchor2, d2);
        this.number = number;
    }

    public Number getNumber() {
        return this.number;
    }
}

