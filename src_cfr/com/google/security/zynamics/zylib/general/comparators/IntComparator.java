/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general.comparators;

import java.io.Serializable;
import java.util.Comparator;

public class IntComparator
implements Serializable,
Comparator {
    private static final long serialVersionUID = -9039204490352575348L;

    public int compare(Integer n2, Integer n3) {
        return n2 - n3;
    }
}

