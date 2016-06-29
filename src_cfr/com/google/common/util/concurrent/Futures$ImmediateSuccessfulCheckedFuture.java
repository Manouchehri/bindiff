/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$ImmediateFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GwtIncompatible(value="TODO")
class Futures$ImmediateSuccessfulCheckedFuture
extends Futures$ImmediateFuture
implements CheckedFuture {
    @Nullable
    private final Object value;

    Futures$ImmediateSuccessfulCheckedFuture(@Nullable Object object) {
        super(null);
        this.value = object;
    }

    @Override
    public Object get() {
        return this.value;
    }

    @Override
    public Object checkedGet() {
        return this.value;
    }

    @Override
    public Object checkedGet(long l2, TimeUnit timeUnit) {
        Preconditions.checkNotNull((Object)timeUnit);
        return this.value;
    }
}

