package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$StrongEntry;
import javax.annotation.Nullable;

final class LocalCache$StrongWriteEntry extends LocalCache$StrongEntry {
   volatile long writeTime = Long.MAX_VALUE;
   LocalCache$ReferenceEntry nextWrite = LocalCache.nullEntry();
   LocalCache$ReferenceEntry previousWrite = LocalCache.nullEntry();

   LocalCache$StrongWriteEntry(Object var1, int var2, @Nullable LocalCache$ReferenceEntry var3) {
      super(var1, var2, var3);
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
