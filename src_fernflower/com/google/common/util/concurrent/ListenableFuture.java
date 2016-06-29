package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@GwtCompatible
public interface ListenableFuture extends Future {
   void addListener(Runnable var1, Executor var2);
}
