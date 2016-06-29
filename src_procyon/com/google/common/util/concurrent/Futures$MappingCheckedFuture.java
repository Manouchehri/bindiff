package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;

@GwtIncompatible("TODO")
class Futures$MappingCheckedFuture extends AbstractCheckedFuture
{
    final Function mapper;
    
    Futures$MappingCheckedFuture(final ListenableFuture listenableFuture, final Function function) {
        super(listenableFuture);
        this.mapper = (Function)Preconditions.checkNotNull(function);
    }
    
    @Override
    protected Exception mapException(final Exception ex) {
        return (Exception)this.mapper.apply(ex);
    }
}
