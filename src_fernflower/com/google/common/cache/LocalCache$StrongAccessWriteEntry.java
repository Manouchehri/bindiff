package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$StrongEntry;
import javax.annotation.Nullable;

final class LocalCache$StrongAccessWriteEntry extends LocalCache$StrongEntry {
   volatile long accessTime = Long.MAX_VALUE;
   LocalCache$ReferenceEntry nextAccess = LocalCache.nullEntry();
   LocalCache$ReferenceEntry previousAccess = LocalCache.nullEntry();
   volatile long writeTime = Long.MAX_VALUE;
   LocalCache$ReferenceEntry nextWrite = LocalCache.nullEntry();
   LocalCache$ReferenceEntry previousWrite = LocalCache.nullEntry();

   LocalCache$StrongAccessWriteEntry(Object var1, int var2, @Nullable LocalCache$ReferenceEntry var3) {
      super(var1, var2, var3);
   }

   public long getAccessTime() {
      return this.accessTime;
   }

   public void setAccessTime(long var1) {
      this.accessTime = var1;
   }

   public LocalCache$ReferenceEntry getNextInAccessQueue() {
      return this.nextAccess;
   }

   public void setNextInAccessQueue(LocalCache$ReferenceEntry var1) {
      this.nextAccess = var1;
   }

   public LocalCache$ReferenceEntry getPreviousInAccessQueue() {
      return this.previousAccess;
   }

   public void setPreviousInAccessQueue(LocalCache$ReferenceEntry var1) {
      this.previousAccess = var1;
   }

   public long getWriteTime() {
      return this.writeTime;
   }

   public void setWriteTime(long var1) {
      this.writeTime = var1;
   }

   public LocalCache$ReferenceEntry getNextInWriteQueue() {
      return this.nextWrite;
   }

   public void setNextInWriteQueue(LocalCache$ReferenceEntry var1) {
      this.nextWrite = var1;
   }

   public LocalCache$ReferenceEntry getPreviousInWriteQueue() {
      return this.previousWrite;
   }

   public void setPreviousInWriteQueue(LocalCache$ReferenceEntry var1) {
      this.previousWrite = var1;
   }
}
