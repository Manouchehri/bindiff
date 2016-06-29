/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractCheckedFuture;
import com.google.common.util.concurrent.ListenableFuture;

@GwtIncompatible(value="TODO")
class Futures$MappingCheckedFuture
extends AbstractCheckedFuture {
    final Function mapper;

    Futures$MappingCheckedFuture(ListenableFuture listenableFuture, Function function) {
        super(listenableFuture);
        this.mapper = (Function)Preconditions.checkNotNull(function);
    }

    @Override
    protected Exception mapException(Exception exception) {
        return (Exception)this.mapper.apply(exception);
    }
}

