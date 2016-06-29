package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;
import java.lang.ref.ReferenceQueue;

class LocalCache$StrongValueReference implements LocalCache$ValueReference {
   final Object referent;

   LocalCache$StrongValueReference(Object var1) {
      this.referent = var1;
   }

   public Object get() {
      return this.referent;
   }

   public int getWeight() {
      return 1;
   }

   public LocalCache$ReferenceEntry getEntry() {
      return null;
   }

   public LocalCache$ValueReference copyFor(ReferenceQueue var1, Object var2, LocalCache$ReferenceEntry var3) {
      return this;
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

   public void notifyNewValue(Object var1) {
   }
}
