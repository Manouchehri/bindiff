package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;

@GwtCompatible(
   serializable = true,
   emulated = true
)
final class SingletonImmutableList extends ImmutableList {
   final transient Object element;

   SingletonImmutableList(Object var1) {
      this.element = Preconditions.checkNotNull(var1);
   }

   public Object get(int var1) {
      Preconditions.checkElementIndex(var1, 1);
      return this.element;
   }

   public UnmodifiableIterator iterator() {
      return Iterators.singletonIterator(this.element);
   }

   public int size() {
      return 1;
   }

   public ImmutableList subList(int var1, int var2) {
      Preconditions.checkPositionIndexes(var1, var2, 1);
      return (ImmutableList)(var1 == var2?ImmutableList.of():this);
   }

   public String toString() {
      String var1 = this.element.toString();
      return (new StringBuilder(var1.length() + 2)).append('[').append(var1).append(']').toString();
   }

   boolean isPartialView() {
      return false;
   }
}
