package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets$PowerSet$1;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Sets$PowerSet extends AbstractSet {
   final ImmutableMap inputSet;

   Sets$PowerSet(Set var1) {
      this.inputSet = Maps.indexMap(var1);
      Preconditions.checkArgument(this.inputSet.size() <= 30, "Too many elements to create power set: %s > 30", new Object[]{Integer.valueOf(this.inputSet.size())});
   }

   public int size() {
      return 1 << this.inputSet.size();
   }

   public boolean isEmpty() {
      return false;
   }

   public Iterator iterator() {
      return new Sets$PowerSet$1(this, this.size());
   }

   public boolean contains(@Nullable Object var1) {
      if(var1 instanceof Set) {
         Set var2 = (Set)var1;
         return this.inputSet.keySet().containsAll(var2);
      } else {
         return false;
      }
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Sets$PowerSet) {
         Sets$PowerSet var2 = (Sets$PowerSet)var1;
         return this.inputSet.equals(var2.inputSet);
      } else {
         return super.equals(var1);
      }
   }

   public int hashCode() {
      return this.inputSet.keySet().hashCode() << this.inputSet.size() - 1;
   }

   public String toString() {
      String var1 = String.valueOf(this.inputSet);
      return (new StringBuilder(10 + String.valueOf(var1).length())).append("powerSet(").append(var1).append(")").toString();
   }
}
