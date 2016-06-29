package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;

abstract class LocalCache$AbstractReferenceEntry implements LocalCache$ReferenceEntry {
   public LocalCache$ValueReference getValueReference() {
      throw new UnsupportedOperationException();
   }

   public void setValueReference(LocalCache$ValueReference var1) {
      throw new UnsupportedOperationException();
   }

   public LocalCache$ReferenceEntry getNext() {
      throw new UnsupportedOperationException();
   }

   public int getHash() {
      throw new UnsupportedOperationException();
   }

   public Object getKey() {
      throw new UnsupportedOperationException();
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
}
