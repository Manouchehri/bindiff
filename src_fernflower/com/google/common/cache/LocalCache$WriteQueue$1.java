package com.google.common.cache;

import com.google.common.cache.LocalCache$AbstractReferenceEntry;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$WriteQueue;

class LocalCache$WriteQueue$1 extends LocalCache$AbstractReferenceEntry {
   LocalCache$ReferenceEntry nextWrite;
   LocalCache$ReferenceEntry previousWrite;
   // $FF: synthetic field
   final LocalCache$WriteQueue this$0;

   LocalCache$WriteQueue$1(LocalCache$WriteQueue var1) {
      this.this$0 = var1;
      this.nextWrite = this;
      this.previousWrite = this;
   }

   public long getWriteTime() {
      return Long.MAX_VALUE;
   }

   public void setWriteTime(long var1) {
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
