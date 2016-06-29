/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general.comparators;

import java.io.Serializable;
import java.util.Comparator;

public class DoubleComparator
implements Serializable,
Comparator {
    public int compare(Double d2, Double d3) {
        return Double.compare(d2, d3);
    }
}

