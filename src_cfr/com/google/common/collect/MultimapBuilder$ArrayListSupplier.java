/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Supplier;
import com.google.common.collect.CollectPreconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

final class MultimapBuilder$ArrayListSupplier
implements Supplier,
Serializable {
    private final int expectedValuesPerKey;

    MultimapBuilder$ArrayListSupplier(int n2) {
        this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(n2, "expectedValuesPerKey");
    }

    @Override
    public List get() {
        return new ArrayList(this.expectedValuesPerKey);
    }
}

