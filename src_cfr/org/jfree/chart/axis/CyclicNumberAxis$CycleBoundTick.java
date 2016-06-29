/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import org.jfree.chart.axis.NumberTick;
import org.jfree.ui.TextAnchor;

public class CyclicNumberAxis$CycleBoundTick
extends NumberTick {
    public boolean mapToLastCycle;

    public CyclicNumberAxis$CycleBoundTick(boolean bl2, Number number, String string, TextAnchor textAnchor, TextAnchor textAnchor2, double d2) {
        super(number, string, textAnchor, textAnchor2, d2);
        this.mapToLastCycle = bl2;
    }
}

