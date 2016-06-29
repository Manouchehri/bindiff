package com.google.common.cache;

import com.google.common.cache.LocalCache$AbstractReferenceEntry;
import com.google.common.cache.LocalCache$AccessQueue;
import com.google.common.cache.LocalCache$ReferenceEntry;

class LocalCache$AccessQueue$1 extends LocalCache$AbstractReferenceEntry {
   LocalCache$ReferenceEntry nextAccess;
   LocalCache$ReferenceEntry previousAccess;
   // $FF: synthetic field
   final LocalCache$AccessQueue this$0;

   LocalCache$AccessQueue$1(LocalCache$AccessQueue var1) {
      this.this$0 = var1;
      this.nextAccess = this;
      this.previousAccess = this;
   }

   public long getAccessTime() {
      return Long.MAX_VALUE;
   }

   public void setAccessTime(long var1) {
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
}
