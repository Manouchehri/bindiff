package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.Collections2$PermutationIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

final class Collections2$PermutationCollection extends AbstractCollection {
   final ImmutableList inputList;

   Collections2$PermutationCollection(ImmutableList var1) {
      this.inputList = var1;
   }

   public int size() {
      return IntMath.factorial(this.inputList.size());
   }

   public boolean isEmpty() {
      return false;
   }

   public Iterator iterator() {
      return new Collections2$PermutationIterator(this.inputList);
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
      return (new StringBuilder(14 + String.valueOf(var1).length())).append("permutations(").append(var1).append(")").toString();
   }
}
