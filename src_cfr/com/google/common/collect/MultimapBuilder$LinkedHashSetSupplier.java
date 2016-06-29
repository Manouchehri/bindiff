/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Supplier;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Set;

final class MultimapBuilder$LinkedHashSetSupplier
implements Supplier,
Serializable {
    private final int expectedValuesPerKey;

    MultimapBuilder$LinkedHashSetSupplier(int n2) {
        this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(n2, "expectedValuesPerKey");
    }

    @Override
    public Set get() {
        return Sets.newLinkedHashSetWithExpectedSize(this.expectedValuesPerKey);
    }
}

