package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.*;

@GwtCompatible
public interface ListenableFuture extends Future
{
    void addListener(final Runnable p0, final Executor p1);
}
