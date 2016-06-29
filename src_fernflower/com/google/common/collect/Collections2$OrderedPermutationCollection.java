package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.Collections2$OrderedPermutationIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.math.LongMath;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

final class Collections2$OrderedPermutationCollection extends AbstractCollection {
   final ImmutableList inputList;
   final Comparator comparator;
   final int size;

   Collections2$OrderedPermutationCollection(Iterable var1, Comparator var2) {
      this.inputList = Ordering.from(var2).immutableSortedCopy(var1);
      this.comparator = var2;
      this.size = calculateSize(this.inputList, var2);
   }

   private static int calculateSize(List var0, Comparator var1) {
      long var2 = 1L;
      int var4 = 1;

      int var5;
      for(var5 = 1; var4 < var0.size(); ++var5) {
         int var6 = var1.compare(var0.get(var4 - 1), var0.get(var4));
         if(var6 < 0) {
            var2 *= LongMath.binomial(var4, var5);
            var5 = 0;
            if(!Collections2.access$000(var2)) {
               return Integer.MAX_VALUE;
            }
         }

         ++var4;
      }

      var2 *= LongMath.binomial(var4, var5);
      if(!Collections2.access$000(var2)) {
         return Integer.MAX_VALUE;
      } else {
         return (int)var2;
      }
   }

   public int size() {
      return this.size;
   }

   public boolean isEmpty() {
      return false;
   }

   public Iterator iterator() {
      return new Collections2$OrderedPermutationIterator(this.inputList, this.comparator);
   }

   public boolean contains(@Nullable Object var1) {
      if(var1 instanceof List) {
         List var2 = (List)var1;
         return Collections2.access$100(this.inputList, var2);
      } else {
         return false;
      }
   }

   public String toString() {
      String var1 = String.valueOf(this.inputList);
      return (new StringBuilder(30 + String.valueOf(var1).length())).append("orderedPermutationCollection(").append(var1).append(")").toString();
   }
}
