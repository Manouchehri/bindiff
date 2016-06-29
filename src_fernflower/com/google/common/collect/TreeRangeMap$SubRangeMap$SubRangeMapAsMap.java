package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Predicate;
import com.google.common.collect.Cut;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import com.google.common.collect.TreeRangeMap$SubRangeMap;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap extends AbstractMap {
   // $FF: synthetic field
   final TreeRangeMap$SubRangeMap this$1;

   TreeRangeMap$SubRangeMap$SubRangeMapAsMap(TreeRangeMap$SubRangeMap var1) {
      this.this$1 = var1;
   }

   public boolean containsKey(Object var1) {
      return this.get(var1) != null;
   }

   public Object get(Object var1) {
      try {
         if(var1 instanceof Range) {
            Range var2 = (Range)var1;
            if(!TreeRangeMap$SubRangeMap.access$200(this.this$1).encloses(var2) || var2.isEmpty()) {
               return null;
            }

            TreeRangeMap$RangeMapEntry var3 = null;
            if(var2.lowerBound.compareTo(TreeRangeMap$SubRangeMap.access$200(this.this$1).lowerBound) == 0) {
               Entry var4 = TreeRangeMap.access$000(this.this$1.this$0).floorEntry(var2.lowerBound);
               if(var4 != null) {
                  var3 = (TreeRangeMap$RangeMapEntry)var4.getValue();
               }
            } else {
               var3 = (TreeRangeMap$RangeMapEntry)TreeRangeMap.access$000(this.this$1.this$0).get(var2.lowerBound);
            }

            if(var3 != null && var3.getKey().isConnected(TreeRangeMap$SubRangeMap.access$200(this.this$1)) && var3.getKey().intersection(TreeRangeMap$SubRangeMap.access$200(this.this$1)).equals(var2)) {
               return var3.getValue();
            }
         }

         return null;
      } catch (ClassCastException var5) {
         return null;
      }
   }

   public Object remove(Object var1) {
      Object var2 = this.get(var1);
      if(var2 != null) {
         Range var3 = (Range)var1;
         this.this$1.this$0.remove(var3);
         return var2;
      } else {
         return null;
      }
   }

   public void clear() {
      this.this$1.clear();
   }

   private boolean removeEntryIf(Predicate var1) {
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = this.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         if(var1.apply(var4)) {
            var2.add(var4.getKey());
         }
      }

      var3 = var2.iterator();

      while(var3.hasNext()) {
         Range var5 = (Range)var3.next();
         this.this$1.this$0.remove(var5);
      }

      return !var2.isEmpty();
   }

   public Set keySet() {
      return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1(this, this);
   }

   public Set entrySet() {
      return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2(this);
   }

   Iterator entryIterator() {
      if(TreeRangeMap$SubRangeMap.access$200(this.this$1).isEmpty()) {
         return Iterators.emptyIterator();
      } else {
         Cut var1 = (Cut)MoreObjects.firstNonNull(TreeRangeMap.access$000(this.this$1.this$0).floorKey(TreeRangeMap$SubRangeMap.access$200(this.this$1).lowerBound), TreeRangeMap$SubRangeMap.access$200(this.this$1).lowerBound);
         Iterator var2 = TreeRangeMap.access$000(this.this$1.this$0).tailMap(var1, true).values().iterator();
         return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3(this, var2);
      }
   }

   public Collection values() {
      return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4(this, this);
   }

   // $FF: synthetic method
   static boolean access$300(TreeRangeMap$SubRangeMap$SubRangeMapAsMap var0, Predicate var1) {
      return var0.removeEntryIf(var1);
   }
}
