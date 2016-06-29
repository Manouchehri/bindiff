package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import java.util.Iterator;

public class ImmutableRangeSet$Builder {
   private final RangeSet rangeSet = TreeRangeSet.create();

   public ImmutableRangeSet$Builder add(Range var1) {
      if(var1.isEmpty()) {
         String var4 = String.valueOf(var1);
         throw new IllegalArgumentException((new StringBuilder(33 + String.valueOf(var4).length())).append("range must not be empty, but was ").append(var4).toString());
      } else if(this.rangeSet.complement().encloses(var1)) {
         this.rangeSet.add(var1);
         return this;
      } else {
         Iterator var2 = this.rangeSet.asRanges().iterator();

         while(var2.hasNext()) {
            Range var3 = (Range)var2.next();
            Preconditions.checkArgument(!var3.isConnected(var1) || var3.intersection(var1).isEmpty(), "Ranges may not overlap, but received %s and %s", new Object[]{var3, var1});
         }

         throw new AssertionError("should have thrown an IAE above");
      }
   }

   public ImmutableRangeSet$Builder addAll(RangeSet var1) {
      Iterator var2 = var1.asRanges().iterator();

      while(var2.hasNext()) {
         Range var3 = (Range)var2.next();
         this.add(var3);
      }

      return this;
   }

   public ImmutableRangeSet build() {
      return ImmutableRangeSet.copyOf(this.rangeSet);
   }
}
