/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import com.google.common.cache.LongAddable;
import com.google.common.cache.LongAddables$1;
import com.google.common.cache.LongAddables$2;
import com.google.common.cache.LongAdder;

@GwtCompatible(emulated=1)
final class LongAddables {
    private static final Supplier SUPPLIER;

    LongAddables() {
    }

    public static LongAddable create() {
        return (LongAddable)SUPPLIER.get();
    }

    static {
        Supplier supplier2;
        Supplier supplier2;
        try {
            new LongAdder();
            supplier2 = new LongAddables$1();
        }
        catch (Throwable var1_1) {
            supplier2 = new LongAddables$2();
        }
        SUPPLIER = supplier2;
    }
}

