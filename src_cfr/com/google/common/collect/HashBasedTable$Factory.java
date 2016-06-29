/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Map;

class HashBasedTable$Factory
implements Supplier,
Serializable {
    final int expectedSize;
    private static final long serialVersionUID = 0;

    HashBasedTable$Factory(int n2) {
        this.expectedSize = n2;
    }

    @Override
    public Map get() {
        return Maps.newHashMapWithExpectedSize(this.expectedSize);
    }
}

