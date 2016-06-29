package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

interface LocalCache$ValueReference {
   @Nullable
   Object get();

   Object waitForValue();

   int getWeight();

   @Nullable
   LocalCache$ReferenceEntry getEntry();

   LocalCache$ValueReference copyFor(ReferenceQueue var1, @Nullable Object var2, LocalCache$ReferenceEntry var3);

   void notifyNewValue(@Nullable Object var1);

   boolean isLoading();

   boolean isActive();
}
