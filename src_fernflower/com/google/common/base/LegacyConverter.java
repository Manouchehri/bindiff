package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import javax.annotation.Nullable;

@Deprecated
@GoogleInternal
@GwtCompatible
public abstract class LegacyConverter extends Converter {
   protected LegacyConverter() {
      super(false);
   }

   @Nullable
   protected abstract Object doForward(@Nullable Object var1);

   @Nullable
   protected abstract Object doBackward(@Nullable Object var1);
}
