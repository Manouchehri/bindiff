package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps$SortedKeySet;
import com.google.common.collect.StandardTable$Row;
import com.google.common.collect.TreeBasedTable;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

class TreeBasedTable$TreeRow extends StandardTable$Row implements SortedMap {
   @Nullable
   final Object lowerBound;
   @Nullable
   final Object upperBound;
   transient SortedMap wholeRow;
   // $FF: synthetic field
   final TreeBasedTable this$0;

   TreeBasedTable$TreeRow(TreeBasedTable var1, Object var2) {
      this(var1, var2, (Object)null, (Object)null);
   }

   TreeBasedTable$TreeRow(TreeBasedTable var1, Object var2, @Nullable Object var3, @Nullable Object var4) {
      super(var1, var2);
      this.this$0 = var1;
      this.lowerBound = var3;
      this.upperBound = var4;
      Preconditions.checkArgument(var3 == null || var4 == null || this.compare(var3, var4) <= 0);
   }

   public SortedSet keySet() {
      return new Maps$SortedKeySet(this);
   }

   public Comparator comparator() {
      return this.this$0.columnComparator();
   }

   int compare(Object var1, Object var2) {
      Comparator var3 = this.comparator();
      return var3.compare(var1, var2);
   }

   boolean rangeContains(@Nullable Object var1) {
      return var1 != null && (this.lowerBound == null || this.compare(this.lowerBound, var1) <= 0) && (this.upperBound == null || this.compare(this.upperBound, var1) > 0);
   }

   public SortedMap subMap(Object var1, Object var2) {
      Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(var1)) && this.rangeContains(Preconditions.checkNotNull(var2)));
      return new TreeBasedTable$TreeRow(this.this$0, this.rowKey, var1, var2);
   }

   public SortedMap headMap(Object var1) {
      Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(var1)));
      return new TreeBasedTable$TreeRow(this.this$0, this.rowKey, this.lowerBound, var1);
   }

   public SortedMap tailMap(Object var1) {
      Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(var1)));
      return new TreeBasedTable$TreeRow(this.this$0, this.rowKey, var1, this.upperBound);
   }

   public Object firstKey() {
      SortedMap var1 = this.backingRowMap();
      if(var1 == null) {
         throw new NoSuchElementException();
      } else {
         return this.backingRowMap().firstKey();
      }
   }

   public Object lastKey() {
      SortedMap var1 = this.backingRowMap();
      if(var1 == null) {
         throw new NoSuchElementException();
      } else {
         return this.backingRowMap().lastKey();
      }
   }

   SortedMap wholeRow() {
      if(this.wholeRow == null || this.wholeRow.isEmpty() && this.this$0.backingMap.containsKey(this.rowKey)) {
         this.wholeRow = (SortedMap)this.this$0.backingMap.get(this.rowKey);
      }

      return this.wholeRow;
   }

   SortedMap backingRowMap() {
      return (SortedMap)super.backingRowMap();
   }

   SortedMap computeBackingRowMap() {
      SortedMap var1 = this.wholeRow();
      if(var1 != null) {
         if(this.lowerBound != null) {
            var1 = var1.tailMap(this.lowerBound);
         }

         if(this.upperBound != null) {
            var1 = var1.headMap(this.upperBound);
         }

         return var1;
      } else {
         return null;
      }
   }

   void maintainEmptyInvariant() {
      if(this.wholeRow() != null && this.wholeRow.isEmpty()) {
         this.this$0.backingMap.remove(this.rowKey);
         this.wholeRow = null;
         this.backingRowMap = null;
      }

   }

   public boolean containsKey(Object var1) {
      return this.rangeContains(var1) && super.containsKey(var1);
   }

   public Object put(Object var1, Object var2) {
      Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(var1)));
      return super.put(var1, var2);
   }
}
