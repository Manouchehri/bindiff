package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

class ImmutableList$ReverseImmutableList extends ImmutableList {
   private final transient ImmutableList forwardList;

   ImmutableList$ReverseImmutableList(ImmutableList var1) {
      this.forwardList = var1;
   }

   private int reverseIndex(int var1) {
      return this.size() - 1 - var1;
   }

   private int reversePosition(int var1) {
      return this.size() - var1;
   }

   public ImmutableList reverse() {
      return this.forwardList;
   }

   public boolean contains(@Nullable Object var1) {
      return this.forwardList.contains(var1);
   }

   public int indexOf(@Nullable Object var1) {
      int var2 = this.forwardList.lastIndexOf(var1);
      return var2 >= 0?this.reverseIndex(var2):-1;
   }

   public int lastIndexOf(@Nullable Object var1) {
      int var2 = this.forwardList.indexOf(var1);
      return var2 >= 0?this.reverseIndex(var2):-1;
   }

   public ImmutableList subList(int var1, int var2) {
      Preconditions.checkPositionIndexes(var1, var2, this.size());
      return this.forwardList.subList(this.reversePosition(var2), this.reversePosition(var1)).reverse();
   }

   public Object get(int var1) {
      Preconditions.checkElementIndex(var1, this.size());
      return this.forwardList.get(this.reverseIndex(var1));
   }

   public int size() {
      return this.forwardList.size();
   }

   boolean isPartialView() {
      return this.forwardList.isPartialView();
   }
}
