package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.ListenableFuture;

@GoogleInternal
@GwtCompatible
public interface AsyncCallable {
   ListenableFuture call();
}
