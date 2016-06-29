package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

class LocalCache$SoftValueReference extends SoftReference implements LocalCache$ValueReference {
   final LocalCache$ReferenceEntry entry;

   LocalCache$SoftValueReference(ReferenceQueue var1, Object var2, LocalCache$ReferenceEntry var3) {
      super(var2, var1);
      this.entry = var3;
   }

   public int getWeight() {
      return 1;
   }

   public LocalCache$ReferenceEntry getEntry() {
      return this.entry;
   }

   public void notifyNewValue(Object var1) {
   }

   public LocalCache$ValueReference copyFor(ReferenceQueue var1, Object var2, LocalCache$ReferenceEntry var3) {
      return new LocalCache$SoftValueReference(var1, var2, var3);
   }

   public boolean isLoading() {
      return false;
   }

   public boolean isActive() {
      return true;
   }

   public Object waitForValue() {
      return this.get();
   }
}
