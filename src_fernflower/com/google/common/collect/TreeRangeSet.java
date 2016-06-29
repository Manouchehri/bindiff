package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractRangeSet;
import com.google.common.collect.Cut;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet$1;
import com.google.common.collect.TreeRangeSet$AsRanges;
import com.google.common.collect.TreeRangeSet$Complement;
import com.google.common.collect.TreeRangeSet$SubRangeSet;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible("uses NavigableMap")
public class TreeRangeSet extends AbstractRangeSet {
   @VisibleForTesting
   final NavigableMap rangesByLowerBound;
   private transient Set asRanges;
   private transient Set asDescendingSetOfRanges;
   private transient RangeSet complement;

   public static TreeRangeSet create() {
      return new TreeRangeSet(new TreeMap());
   }

   public static TreeRangeSet create(RangeSet var0) {
      TreeRangeSet var1 = create();
      var1.addAll(var0);
      return var1;
   }

   private TreeRangeSet(NavigableMap var1) {
      this.rangesByLowerBound = var1;
   }

   public Set asRanges() {
      Set var1 = this.asRanges;
      return var1 == null?(this.asRanges = new TreeRangeSet$AsRanges(this, this.rangesByLowerBound.values())):var1;
   }

   public Set asDescendingSetOfRanges() {
      Set var1 = this.asDescendingSetOfRanges;
      return var1 == null?(this.asDescendingSetOfRanges = new TreeRangeSet$AsRanges(this, this.rangesByLowerBound.descendingMap().values())):var1;
   }

   @Nullable
   public Range rangeContaining(Comparable var1) {
      Preconditions.checkNotNull(var1);
      Entry var2 = this.rangesByLowerBound.floorEntry(Cut.belowValue(var1));
      return var2 != null && ((Range)var2.getValue()).contains(var1)?(Range)var2.getValue():null;
   }

   public boolean encloses(Range var1) {
      Preconditions.checkNotNull(var1);
      Entry var2 = this.rangesByLowerBound.floorEntry(var1.lowerBound);
      return var2 != null && ((Range)var2.getValue()).encloses(var1);
   }

   @Nullable
   private Range rangeEnclosing(Range var1) {
      Preconditions.checkNotNull(var1);
      Entry var2 = this.rangesByLowerBound.floorEntry(var1.lowerBound);
      return var2 != null && ((Range)var2.getValue()).encloses(var1)?(Range)var2.getValue():null;
   }

   public Range span() {
      Entry var1 = this.rangesByLowerBound.firstEntry();
      Entry var2 = this.rangesByLowerBound.lastEntry();
      if(var1 == null) {
         throw new NoSuchElementException();
      } else {
         return Range.create(((Range)var1.getValue()).lowerBound, ((Range)var2.getValue()).upperBound);
      }
   }

   public void add(Range var1) {
      Preconditions.checkNotNull(var1);
      if(!var1.isEmpty()) {
         Cut var2 = var1.lowerBound;
         Cut var3 = var1.upperBound;
         Entry var4 = this.rangesByLowerBound.lowerEntry(var2);
         if(var4 != null) {
            Range var5 = (Range)var4.getValue();
            if(var5.upperBound.compareTo(var2) >= 0) {
               if(var5.upperBound.compareTo(var3) >= 0) {
                  var3 = var5.upperBound;
               }

               var2 = var5.lowerBound;
            }
         }

         Entry var7 = this.rangesByLowerBound.floorEntry(var3);
         if(var7 != null) {
            Range var6 = (Range)var7.getValue();
            if(var6.upperBound.compareTo(var3) >= 0) {
               var3 = var6.upperBound;
            }
         }

         this.rangesByLowerBound.subMap(var2, var3).clear();
         this.replaceRangeWithSameLowerBound(Range.create(var2, var3));
      }
   }

   public void remove(Range var1) {
      Preconditions.checkNotNull(var1);
      if(!var1.isEmpty()) {
         Entry var2 = this.rangesByLowerBound.lowerEntry(var1.lowerBound);
         if(var2 != null) {
            Range var3 = (Range)var2.getValue();
            if(var3.upperBound.compareTo(var1.lowerBound) >= 0) {
               if(var1.hasUpperBound() && var3.upperBound.compareTo(var1.upperBound) >= 0) {
                  this.replaceRangeWithSameLowerBound(Range.create(var1.upperBound, var3.upperBound));
               }

               this.replaceRangeWithSameLowerBound(Range.create(var3.lowerBound, var1.lowerBound));
            }
         }

         Entry var5 = this.rangesByLowerBound.floorEntry(var1.upperBound);
         if(var5 != null) {
            Range var4 = (Range)var5.getValue();
            if(var1.hasUpperBound() && var4.upperBound.compareTo(var1.upperBound) >= 0) {
               this.replaceRangeWithSameLowerBound(Range.create(var1.upperBound, var4.upperBound));
            }
         }

         this.rangesByLowerBound.subMap(var1.lowerBound, var1.upperBound).clear();
      }
   }

   private void replaceRangeWithSameLowerBound(Range var1) {
      if(var1.isEmpty()) {
         this.rangesByLowerBound.remove(var1.lowerBound);
      } else {
         this.rangesByLowerBound.put(var1.lowerBound, var1);
      }

   }

   public RangeSet complement() {
      RangeSet var1 = this.complement;
      return var1 == null?(this.complement = new TreeRangeSet$Complement(this)):var1;
   }

   public RangeSet subRangeSet(Range var1) {
      return (RangeSet)(var1.equals(Range.all())?this:new TreeRangeSet$SubRangeSet(this, var1));
   }

   // $FF: synthetic method
   TreeRangeSet(NavigableMap var1, TreeRangeSet$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Range access$600(TreeRangeSet var0, Range var1) {
      return var0.rangeEnclosing(var1);
   }
}
