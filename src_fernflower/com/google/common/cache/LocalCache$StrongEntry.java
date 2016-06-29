package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AbstractReferenceEntry;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;
import javax.annotation.Nullable;

class LocalCache$StrongEntry extends LocalCache$AbstractReferenceEntry {
   final Object key;
   final int hash;
   final LocalCache$ReferenceEntry next;
   volatile LocalCache$ValueReference valueReference = LocalCache.unset();

   LocalCache$StrongEntry(Object var1, int var2, @Nullable LocalCache$ReferenceEntry var3) {
      this.key = var1;
      this.hash = var2;
      this.next = var3;
   }

   public Object getKey() {
      return this.key;
   }

   public LocalCache$ValueReference getValueReference() {
      return this.valueReference;
   }

   public void setValueReference(LocalCache$ValueReference var1) {
      this.valueReference = var1;
   }

   public int getHash() {
      return this.hash;
   }

   public LocalCache$ReferenceEntry getNext() {
      return this.next;
   }
}
