package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GoogleInternal
@GwtCompatible
public interface Receiver {
   void accept(@Nullable Object var1);
}
