/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.tables;

import java.util.Comparator;

final class CTableSorter$1
implements Comparator {
    CTableSorter$1() {
    }

    public int compare(Object object, Object object2) {
        return ((Comparable)object).compareTo(object2);
    }
}

