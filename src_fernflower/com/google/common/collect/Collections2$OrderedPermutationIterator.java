package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class Collections2$OrderedPermutationIterator extends AbstractIterator {
   List nextPermutation;
   final Comparator comparator;

   Collections2$OrderedPermutationIterator(List var1, Comparator var2) {
      this.nextPermutation = Lists.newArrayList((Iterable)var1);
      this.comparator = var2;
   }

   protected List computeNext() {
      if(this.nextPermutation == null) {
         return (List)this.endOfData();
      } else {
         ImmutableList var1 = ImmutableList.copyOf((Collection)this.nextPermutation);
         this.calculateNextPermutation();
         return var1;
      }
   }

   void calculateNextPermutation() {
      int var1 = this.findNextJ();
      if(var1 == -1) {
         this.nextPermutation = null;
      } else {
         int var2 = this.findNextL(var1);
         Collections.swap(this.nextPermutation, var1, var2);
         int var3 = this.nextPermutation.size();
         Collections.reverse(this.nextPermutation.subList(var1 + 1, var3));
      }
   }

   int findNextJ() {
      for(int var1 = this.nextPermutation.size() - 2; var1 >= 0; --var1) {
         if(this.comparator.compare(this.nextPermutation.get(var1), this.nextPermutation.get(var1 + 1)) < 0) {
            return var1;
         }
      }

      return -1;
   }

   int findNextL(int var1) {
      Object var2 = this.nextPermutation.get(var1);

      for(int var3 = this.nextPermutation.size() - 1; var3 > var1; --var3) {
         if(this.comparator.compare(var2, this.nextPermutation.get(var3)) < 0) {
            return var3;
         }
      }

      throw new AssertionError("this statement should be unreachable");
   }
}
