/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Supplier;
import com.google.common.cache.LongAddable;
import com.google.common.cache.LongAddables$1;
import com.google.common.cache.LongAddables$PureJavaLongAddable;

final class LongAddables$2
implements Supplier {
    LongAddables$2() {
    }

    @Override
    public LongAddable get() {
        return new LongAddables$PureJavaLongAddable(null);
    }
}

