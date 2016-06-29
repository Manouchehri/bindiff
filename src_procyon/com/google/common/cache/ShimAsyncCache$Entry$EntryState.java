package com.google.common.cache;

import javax.annotation.*;
import com.google.common.util.concurrent.*;

interface ShimAsyncCache$Entry$EntryState
{
    @Nullable
    Object getIfPresent();
    
    ListenableFuture getOrLoadFuture();
    
    void maybeLoad(final ShimAsyncCache$LoadWhen p0);
    
    void addFuture(final ListenableFuture p0);
    
    void handleCompletion(final ListenableFuture p0);
}
