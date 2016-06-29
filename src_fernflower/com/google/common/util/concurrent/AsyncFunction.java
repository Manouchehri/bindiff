package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

@GwtCompatible
public interface AsyncFunction {
   ListenableFuture apply(@Nullable Object var1);
}
