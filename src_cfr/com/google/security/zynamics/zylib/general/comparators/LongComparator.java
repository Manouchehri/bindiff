/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general.comparators;

import java.io.Serializable;
import java.util.Comparator;

public class LongComparator
implements Serializable,
Comparator {
    private static final long serialVersionUID = 2814764330420080628L;

    public int compare(Long l2, Long l3) {
        long l4 = l2 - l3;
        if (l4 > 0) {
            return 1;
        }
        if (l4 >= 0) return 0;
        return -1;
    }
}

