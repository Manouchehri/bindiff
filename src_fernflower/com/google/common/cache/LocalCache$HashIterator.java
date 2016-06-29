package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$WriteThroughEntry;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class LocalCache$HashIterator implements Iterator {
   int nextSegmentIndex;
   int nextTableIndex;
   LocalCache$Segment currentSegment;
   AtomicReferenceArray currentTable;
   LocalCache$ReferenceEntry nextEntry;
   LocalCache$WriteThroughEntry nextExternal;
   LocalCache$WriteThroughEntry lastReturned;
   // $FF: synthetic field
   final LocalCache this$0;

   LocalCache$HashIterator(LocalCache var1) {
      this.this$0 = var1;
      this.nextSegmentIndex = var1.segments.length - 1;
      this.nextTableIndex = -1;
      this.advance();
   }

   public abstract Object next();

   final void advance() {
      this.nextExternal = null;
      if(!this.nextInChain()) {
         if(!this.nextInTable()) {
            while(this.nextSegmentIndex >= 0) {
               this.currentSegment = this.this$0.segments[this.nextSegmentIndex--];
               if(this.currentSegment.count != 0) {
                  this.currentTable = this.currentSegment.table;
                  this.nextTableIndex = this.currentTable.length() - 1;
                  if(this.nextInTable()) {
                     return;
                  }
               }
            }

         }
      }
   }

   boolean nextInChain() {
      if(this.nextEntry != null) {
         for(this.nextEntry = this.nextEntry.getNext(); this.nextEntry != null; this.nextEntry = this.nextEntry.getNext()) {
            if(this.advanceTo(this.nextEntry)) {
               return true;
            }
         }
      }

      return false;
   }

   boolean nextInTable() {
      while(true) {
         if(this.nextTableIndex >= 0) {
            if((this.nextEntry = (LocalCache$ReferenceEntry)this.currentTable.get(this.nextTableIndex--)) == null || !this.advanceTo(this.nextEntry) && !this.nextInChain()) {
               continue;
            }

            return true;
         }

         return false;
      }
   }

   boolean advanceTo(LocalCache$ReferenceEntry var1) {
      boolean var6;
      try {
         long var2 = this.this$0.ticker.read();
         Object var4 = var1.getKey();
         Object var5 = this.this$0.getLiveValue(var1, var2);
         if(var5 != null) {
            this.nextExternal = new LocalCache$WriteThroughEntry(this.this$0, var4, var5);
            var6 = true;
            return var6;
         }

         var6 = false;
      } finally {
         this.currentSegment.postReadCleanup();
      }

      return var6;
   }

   public boolean hasNext() {
      return this.nextExternal != null;
   }

   LocalCache$WriteThroughEntry nextEntry() {
      if(this.nextExternal == null) {
         throw new NoSuchElementException();
      } else {
         this.lastReturned = this.nextExternal;
         this.advance();
         return this.lastReturned;
      }
   }

   public void remove() {
      Preconditions.checkState(this.lastReturned != null);
      this.this$0.remove(this.lastReturned.getKey());
      this.lastReturned = null;
   }
}
