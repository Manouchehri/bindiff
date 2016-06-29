package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;

enum LocalCache$NullEntry implements LocalCache$ReferenceEntry {
   INSTANCE;

   public LocalCache$ValueReference getValueReference() {
      return null;
   }

   public void setValueReference(LocalCache$ValueReference var1) {
   }

   public LocalCache$ReferenceEntry getNext() {
      return null;
   }

   public int getHash() {
      return 0;
   }

   public Object getKey() {
      return null;
   }

   public long getAccessTime() {
      return 0L;
   }

   public void setAccessTime(long var1) {
   }

   public LocalCache$ReferenceEntry getNextInAccessQueue() {
      return this;
   }

   public void setNextInAccessQueue(LocalCache$ReferenceEntry var1) {
   }

   public LocalCache$ReferenceEntry getPreviousInAccessQueue() {
      return this;
   }

   public void setPreviousInAccessQueue(LocalCache$ReferenceEntry var1) {
   }

   public long getWriteTime() {
      return 0L;
   }

   public void setWriteTime(long var1) {
   }

   public LocalCache$ReferenceEntry getNextInWriteQueue() {
      return this;
   }

   public void setNextInWriteQueue(LocalCache$ReferenceEntry var1) {
   }

   public LocalCache$ReferenceEntry getPreviousInWriteQueue() {
      return this;
   }

   public void setPreviousInWriteQueue(LocalCache$ReferenceEntry var1) {
   }
}
