package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.*;

@Beta
@GwtCompatible
public interface CheckedFuture extends ListenableFuture
{
    Object checkedGet();
    
    Object checkedGet(final long p0, final TimeUnit p1);
}
