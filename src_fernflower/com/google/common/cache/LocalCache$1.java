package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class LocalCache$1 implements LocalCache$ValueReference {
   public Object get() {
      return null;
   }

   public int getWeight() {
      return 0;
   }

   public LocalCache$ReferenceEntry getEntry() {
      return null;
   }

   public LocalCache$ValueReference copyFor(ReferenceQueue var1, @Nullable Object var2, LocalCache$ReferenceEntry var3) {
      return this;
   }

   public boolean isLoading() {
      return false;
   }

   public boolean isActive() {
      return false;
   }

   public Object waitForValue() {
      return null;
   }

   public void notifyNewValue(Object var1) {
   }
}
