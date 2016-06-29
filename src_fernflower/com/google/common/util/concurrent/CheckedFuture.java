package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.TimeUnit;

@Beta
@GwtCompatible
public interface CheckedFuture extends ListenableFuture {
   Object checkedGet();

   Object checkedGet(long var1, TimeUnit var3);
}
