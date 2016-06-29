package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class ImmutableRangeMap$Builder {
   private final RangeSet keyRanges = TreeRangeSet.create();
   private final RangeMap rangeMap = TreeRangeMap.create();

   public ImmutableRangeMap$Builder put(Range var1, Object var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      Preconditions.checkArgument(!var1.isEmpty(), "Range must not be empty, but was %s", new Object[]{var1});
      if(!this.keyRanges.complement().encloses(var1)) {
         Iterator var3 = this.rangeMap.asMapOfRanges().entrySet().iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            Range var5 = (Range)var4.getKey();
            if(var5.isConnected(var1) && !var5.intersection(var1).isEmpty()) {
               String var6 = String.valueOf(var1);
               String var7 = String.valueOf(var4);
               throw new IllegalArgumentException((new StringBuilder(47 + String.valueOf(var6).length() + String.valueOf(var7).length())).append("Overlapping ranges: range ").append(var6).append(" overlaps with entry ").append(var7).toString());
            }
         }
      }

      this.keyRanges.add(var1);
      this.rangeMap.put(var1, var2);
      return this;
   }

   public ImmutableRangeMap$Builder putAll(RangeMap var1) {
      Iterator var2 = var1.asMapOfRanges().entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.put((Range)var3.getKey(), var3.getValue());
      }

      return this;
   }

   public ImmutableRangeMap build() {
      Map var1 = this.rangeMap.asMapOfRanges();
      ImmutableList$Builder var2 = new ImmutableList$Builder(var1.size());
      ImmutableList$Builder var3 = new ImmutableList$Builder(var1.size());
      Iterator var4 = var1.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         var2.add(var5.getKey());
         var3.add(var5.getValue());
      }

      return new ImmutableRangeMap(var2.build(), var3.build());
   }
}
