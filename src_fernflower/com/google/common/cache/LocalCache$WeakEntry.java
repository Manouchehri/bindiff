package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

class LocalCache$WeakEntry extends WeakReference implements LocalCache$ReferenceEntry {
   final int hash;
   final LocalCache$ReferenceEntry next;
   volatile LocalCache$ValueReference valueReference = LocalCache.unset();

   LocalCache$WeakEntry(ReferenceQueue var1, Object var2, int var3, @Nullable LocalCache$ReferenceEntry var4) {
      super(var2, var1);
      this.hash = var3;
      this.next = var4;
   }

   public Object getKey() {
      return this.get();
   }

   public long getAccessTime() {
      throw new UnsupportedOperationException();
   }

   public void setAccessTime(long var1) {
      throw new UnsupportedOperationException();
   }

   public LocalCache$ReferenceEntry getNextInAccessQueue() {
      throw new UnsupportedOperationException();
   }

   public void setNextInAccessQueue(LocalCache$ReferenceEntry var1) {
      throw new UnsupportedOperationException();
   }

   public LocalCache$ReferenceEntry getPreviousInAccessQueue() {
      throw new UnsupportedOperationException();
   }

   public void setPreviousInAccessQueue(LocalCache$ReferenceEntry var1) {
      throw new UnsupportedOperationException();
   }

   public long getWriteTime() {
      throw new UnsupportedOperationException();
   }

   public void setWriteTime(long var1) {
      throw new UnsupportedOperationException();
   }

   public LocalCache$ReferenceEntry getNextInWriteQueue() {
      throw new UnsupportedOperationException();
   }

   public void setNextInWriteQueue(LocalCache$ReferenceEntry var1) {
      throw new UnsupportedOperationException();
   }

   public LocalCache$ReferenceEntry getPreviousInWriteQueue() {
      throw new UnsupportedOperationException();
   }

   public void setPreviousInWriteQueue(LocalCache$ReferenceEntry var1) {
      throw new UnsupportedOperationException();
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
