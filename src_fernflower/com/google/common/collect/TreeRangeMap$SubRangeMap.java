package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import com.google.common.collect.TreeRangeMap$SubRangeMap$1;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;
import javax.annotation.Nullable;

class TreeRangeMap$SubRangeMap implements RangeMap {
   private final Range subRange;
   // $FF: synthetic field
   final TreeRangeMap this$0;

   TreeRangeMap$SubRangeMap(TreeRangeMap var1, Range var2) {
      this.this$0 = var1;
      this.subRange = var2;
   }

   @Nullable
   public Object get(Comparable var1) {
      return this.subRange.contains(var1)?this.this$0.get(var1):null;
   }

   @Nullable
   public Entry getEntry(Comparable var1) {
      if(this.subRange.contains(var1)) {
         Entry var2 = this.this$0.getEntry(var1);
         if(var2 != null) {
            return Maps.immutableEntry(((Range)var2.getKey()).intersection(this.subRange), var2.getValue());
         }
      }

      return null;
   }

   public Range span() {
      Entry var2 = TreeRangeMap.access$000(this.this$0).floorEntry(this.subRange.lowerBound);
      Cut var1;
      if(var2 != null && ((TreeRangeMap$RangeMapEntry)var2.getValue()).getUpperBound().compareTo(this.subRange.lowerBound) > 0) {
         var1 = this.subRange.lowerBound;
      } else {
         var1 = (Cut)TreeRangeMap.access$000(this.this$0).ceilingKey(this.subRange.lowerBound);
         if(var1 == null || var1.compareTo(this.subRange.upperBound) >= 0) {
            throw new NoSuchElementException();
         }
      }

      Entry var4 = TreeRangeMap.access$000(this.this$0).lowerEntry(this.subRange.upperBound);
      if(var4 == null) {
         throw new NoSuchElementException();
      } else {
         Cut var3;
         if(((TreeRangeMap$RangeMapEntry)var4.getValue()).getUpperBound().compareTo(this.subRange.upperBound) >= 0) {
            var3 = this.subRange.upperBound;
         } else {
            var3 = ((TreeRangeMap$RangeMapEntry)var4.getValue()).getUpperBound();
         }

         return Range.create(var1, var3);
      }
   }

   public void put(Range var1, Object var2) {
      Preconditions.checkArgument(this.subRange.encloses(var1), "Cannot put range %s into a subRangeMap(%s)", new Object[]{var1, this.subRange});
      this.this$0.put(var1, var2);
   }

   public void putAll(RangeMap var1) {
      if(!var1.asMapOfRanges().isEmpty()) {
         Range var2 = var1.span();
         Preconditions.checkArgument(this.subRange.encloses(var2), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", new Object[]{var2, this.subRange});
         this.this$0.putAll(var1);
      }
   }

   public void clear() {
      this.this$0.remove(this.subRange);
   }

   public void remove(Range var1) {
      if(var1.isConnected(this.subRange)) {
         this.this$0.remove(var1.intersection(this.subRange));
      }

   }

   public RangeMap subRangeMap(Range var1) {
      return !var1.isConnected(this.subRange)?TreeRangeMap.access$100(this.this$0):this.this$0.subRangeMap(var1.intersection(this.subRange));
   }

   public Map asMapOfRanges() {
      return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap(this);
   }

   public Map asDescendingMapOfRanges() {
      return new TreeRangeMap$SubRangeMap$1(this);
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof RangeMap) {
         RangeMap var2 = (RangeMap)var1;
         return this.asMapOfRanges().equals(var2.asMapOfRanges());
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.asMapOfRanges().hashCode();
   }

   public String toString() {
      return this.asMapOfRanges().toString();
   }

   // $FF: synthetic method
   static Range access$200(TreeRangeMap$SubRangeMap var0) {
      return var0.subRange;
   }
}
