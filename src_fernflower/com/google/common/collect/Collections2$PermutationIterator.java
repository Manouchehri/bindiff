package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Collections2$PermutationIterator extends AbstractIterator {
   final List list;
   final int[] c;
   final int[] o;
   int j;

   Collections2$PermutationIterator(List var1) {
      this.list = new ArrayList(var1);
      int var2 = var1.size();
      this.c = new int[var2];
      this.o = new int[var2];
      Arrays.fill(this.c, 0);
      Arrays.fill(this.o, 1);
      this.j = Integer.MAX_VALUE;
   }

   protected List computeNext() {
      if(this.j <= 0) {
         return (List)this.endOfData();
      } else {
         ImmutableList var1 = ImmutableList.copyOf((Collection)this.list);
         this.calculateNextPermutation();
         return var1;
      }
   }

   void calculateNextPermutation() {
      this.j = this.list.size() - 1;
      int var1 = 0;
      if(this.j != -1) {
         while(true) {
            while(true) {
               int var2 = this.c[this.j] + this.o[this.j];
               if(var2 >= 0) {
                  if(var2 != this.j + 1) {
                     Collections.swap(this.list, this.j - this.c[this.j] + var1, this.j - var2 + var1);
                     this.c[this.j] = var2;
                     return;
                  }

                  if(this.j == 0) {
                     return;
                  }

                  ++var1;
                  this.switchDirection();
               } else {
                  this.switchDirection();
               }
            }
         }
      }
   }

   void switchDirection() {
      this.o[this.j] = -this.o[this.j];
      --this.j;
   }
}
