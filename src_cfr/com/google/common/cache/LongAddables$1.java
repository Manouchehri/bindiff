/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Supplier;
import com.google.common.cache.LongAddable;
import com.google.common.cache.LongAdder;

final class LongAddables$1
implements Supplier {
    LongAddables$1() {
    }

    @Override
    public LongAddable get() {
        return new LongAdder();
    }
}

