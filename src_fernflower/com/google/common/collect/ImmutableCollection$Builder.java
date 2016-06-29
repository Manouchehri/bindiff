package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.util.Iterator;

public abstract class ImmutableCollection$Builder {
   static final int DEFAULT_INITIAL_CAPACITY = 4;

   static int expandedCapacity(int var0, int var1) {
      if(var1 < 0) {
         throw new AssertionError("cannot store more than MAX_VALUE elements");
      } else {
         int var2 = var0 + (var0 >> 1) + 1;
         if(var2 < var1) {
            var2 = Integer.highestOneBit(var1 - 1) << 1;
         }

         if(var2 < 0) {
            var2 = Integer.MAX_VALUE;
         }

         return var2;
      }
   }

   public abstract ImmutableCollection$Builder add(Object var1);

   public ImmutableCollection$Builder add(Object... var1) {
      Object[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Object var5 = var2[var4];
         this.add(var5);
      }

      return this;
   }

   public ImmutableCollection$Builder addAll(Iterable var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         this.add(var3);
      }

      return this;
   }

   public ImmutableCollection$Builder addAll(Iterator var1) {
      while(var1.hasNext()) {
         this.add(var1.next());
      }

      return this;
   }

   public abstract ImmutableCollection build();
}
