/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

final class MultimapBuilder$TreeSetSupplier
implements Supplier,
Serializable {
    private final Comparator comparator;

    MultimapBuilder$TreeSetSupplier(Comparator comparator) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }

    @Override
    public SortedSet get() {
        return new TreeSet(this.comparator);
    }
}

