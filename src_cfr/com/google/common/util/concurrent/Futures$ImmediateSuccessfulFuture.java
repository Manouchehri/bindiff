/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$ImmediateFuture;
import javax.annotation.Nullable;

class Futures$ImmediateSuccessfulFuture
extends Futures$ImmediateFuture {
    static final Futures$ImmediateSuccessfulFuture NULL = new Futures$ImmediateSuccessfulFuture(null);
    @Nullable
    private final Object value;

    Futures$ImmediateSuccessfulFuture(@Nullable Object object) {
        super(null);
        this.value = object;
    }

    @Override
    public Object get() {
        return this.value;
    }
}

