package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$WriteThroughEntry;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class MapMakerInternalMap$HashIterator implements Iterator {
   int nextSegmentIndex;
   int nextTableIndex;
   MapMakerInternalMap$Segment currentSegment;
   AtomicReferenceArray currentTable;
   MapMakerInternalMap$ReferenceEntry nextEntry;
   MapMakerInternalMap$WriteThroughEntry nextExternal;
   MapMakerInternalMap$WriteThroughEntry lastReturned;
   // $FF: synthetic field
   final MapMakerInternalMap this$0;

   MapMakerInternalMap$HashIterator(MapMakerInternalMap var1) {
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
            if((this.nextEntry = (MapMakerInternalMap$ReferenceEntry)this.currentTable.get(this.nextTableIndex--)) == null || !this.advanceTo(this.nextEntry) && !this.nextInChain()) {
               continue;
            }

            return true;
         }

         return false;
      }
   }

   boolean advanceTo(MapMakerInternalMap$ReferenceEntry var1) {
      boolean var4;
      try {
         Object var2 = var1.getKey();
         Object var3 = this.this$0.getLiveValue(var1);
         if(var3 != null) {
            this.nextExternal = new MapMakerInternalMap$WriteThroughEntry(this.this$0, var2, var3);
            var4 = true;
            return var4;
         }

         var4 = false;
      } finally {
         this.currentSegment.postReadCleanup();
      }

      return var4;
   }

   public boolean hasNext() {
      return this.nextExternal != null;
   }

   MapMakerInternalMap$WriteThroughEntry nextEntry() {
      if(this.nextExternal == null) {
         throw new NoSuchElementException();
      } else {
         this.lastReturned = this.nextExternal;
         this.advance();
         return this.lastReturned;
      }
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.lastReturned != null);
      this.this$0.remove(this.lastReturned.getKey());
      this.lastReturned = null;
   }
}
