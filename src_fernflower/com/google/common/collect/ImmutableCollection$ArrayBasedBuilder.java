package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ObjectArrays;
import java.util.Collection;

abstract class ImmutableCollection$ArrayBasedBuilder extends ImmutableCollection$Builder {
   Object[] contents;
   int size;

   ImmutableCollection$ArrayBasedBuilder(int var1) {
      CollectPreconditions.checkNonnegative(var1, "initialCapacity");
      this.contents = new Object[var1];
      this.size = 0;
   }

   private void ensureCapacity(int var1) {
      if(this.contents.length < var1) {
         this.contents = ObjectArrays.arraysCopyOf(this.contents, expandedCapacity(this.contents.length, var1));
      }

   }

   public ImmutableCollection$ArrayBasedBuilder add(Object var1) {
      Preconditions.checkNotNull(var1);
      this.ensureCapacity(this.size + 1);
      this.contents[this.size++] = var1;
      return this;
   }

   public ImmutableCollection$Builder add(Object... var1) {
      ObjectArrays.checkElementsNotNull(var1);
      this.ensureCapacity(this.size + var1.length);
      System.arraycopy(var1, 0, this.contents, this.size, var1.length);
      this.size += var1.length;
      return this;
   }

   public ImmutableCollection$Builder addAll(Iterable var1) {
      if(var1 instanceof Collection) {
         Collection var2 = (Collection)var1;
         this.ensureCapacity(this.size + var2.size());
      }

      super.addAll(var1);
      return this;
   }
}
