package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap$1;
import com.google.common.collect.TreeRangeMap$AsMapOfRanges;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import com.google.common.collect.TreeRangeMap$SubRangeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible("NavigableMap")
public final class TreeRangeMap implements RangeMap {
   private final NavigableMap entriesByLowerBound = Maps.newTreeMap();
   private static final RangeMap EMPTY_SUB_RANGE_MAP = new TreeRangeMap$1();

   public static TreeRangeMap create() {
      return new TreeRangeMap();
   }

   @Nullable
   public Object get(Comparable var1) {
      Entry var2 = this.getEntry(var1);
      return var2 == null?null:var2.getValue();
   }

   @Nullable
   public Entry getEntry(Comparable var1) {
      Entry var2 = this.entriesByLowerBound.floorEntry(Cut.belowValue(var1));
      return var2 != null && ((TreeRangeMap$RangeMapEntry)var2.getValue()).contains(var1)?(Entry)var2.getValue():null;
   }

   public void put(Range var1, Object var2) {
      if(!var1.isEmpty()) {
         Preconditions.checkNotNull(var2);
         this.remove(var1);
         this.entriesByLowerBound.put(var1.lowerBound, new TreeRangeMap$RangeMapEntry(var1, var2));
      }

   }

   public void putAll(RangeMap var1) {
      Iterator var2 = var1.asMapOfRanges().entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.put((Range)var3.getKey(), var3.getValue());
      }

   }

   public void clear() {
      this.entriesByLowerBound.clear();
   }

   public Range span() {
      Entry var1 = this.entriesByLowerBound.firstEntry();
      Entry var2 = this.entriesByLowerBound.lastEntry();
      if(var1 == null) {
         throw new NoSuchElementException();
      } else {
         return Range.create(((TreeRangeMap$RangeMapEntry)var1.getValue()).getKey().lowerBound, ((TreeRangeMap$RangeMapEntry)var2.getValue()).getKey().upperBound);
      }
   }

   private void putRangeMapEntry(Cut var1, Cut var2, Object var3) {
      this.entriesByLowerBound.put(var1, new TreeRangeMap$RangeMapEntry(var1, var2, var3));
   }

   public void remove(Range var1) {
      if(!var1.isEmpty()) {
         Entry var2 = this.entriesByLowerBound.lowerEntry(var1.lowerBound);
         if(var2 != null) {
            TreeRangeMap$RangeMapEntry var3 = (TreeRangeMap$RangeMapEntry)var2.getValue();
            if(var3.getUpperBound().compareTo(var1.lowerBound) > 0) {
               if(var3.getUpperBound().compareTo(var1.upperBound) > 0) {
                  this.putRangeMapEntry(var1.upperBound, var3.getUpperBound(), ((TreeRangeMap$RangeMapEntry)var2.getValue()).getValue());
               }

               this.putRangeMapEntry(var3.getLowerBound(), var1.lowerBound, ((TreeRangeMap$RangeMapEntry)var2.getValue()).getValue());
            }
         }

         Entry var5 = this.entriesByLowerBound.lowerEntry(var1.upperBound);
         if(var5 != null) {
            TreeRangeMap$RangeMapEntry var4 = (TreeRangeMap$RangeMapEntry)var5.getValue();
            if(var4.getUpperBound().compareTo(var1.upperBound) > 0) {
               this.putRangeMapEntry(var1.upperBound, var4.getUpperBound(), ((TreeRangeMap$RangeMapEntry)var5.getValue()).getValue());
               this.entriesByLowerBound.remove(var1.lowerBound);
            }
         }

         this.entriesByLowerBound.subMap(var1.lowerBound, var1.upperBound).clear();
      }
   }

   public Map asMapOfRanges() {
      return new TreeRangeMap$AsMapOfRanges(this, this.entriesByLowerBound.values());
   }

   public Map asDescendingMapOfRanges() {
      return new TreeRangeMap$AsMapOfRanges(this, this.entriesByLowerBound.descendingMap().values());
   }

   public RangeMap subRangeMap(Range var1) {
      return (RangeMap)(var1.equals(Range.all())?this:new TreeRangeMap$SubRangeMap(this, var1));
   }

   private RangeMap emptySubRangeMap() {
      return EMPTY_SUB_RANGE_MAP;
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
      return this.entriesByLowerBound.values().toString();
   }

   // $FF: synthetic method
   static NavigableMap access$000(TreeRangeMap var0) {
      return var0.entriesByLowerBound;
   }

   // $FF: synthetic method
   static RangeMap access$100(TreeRangeMap var0) {
      return var0.emptySubRangeMap();
   }
}
