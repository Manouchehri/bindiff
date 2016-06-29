/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general.comparators;

import java.io.Serializable;
import java.util.Comparator;

public class LexicalComparator
implements Serializable,
Comparator {
    public int compare(String string, String string2) {
        return string.compareToIgnoreCase(string2);
    }
}

