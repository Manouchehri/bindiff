package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GoogleInternal
@GwtCompatible
public interface BinaryPredicate {
   boolean apply(@Nullable Object var1, @Nullable Object var2);
}
