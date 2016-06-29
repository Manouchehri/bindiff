package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public interface FutureCallback {
   void onSuccess(@Nullable Object var1);

   void onFailure(Throwable var1);
}
