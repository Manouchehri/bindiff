package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Lists$ReverseList$1;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

class Lists$ReverseList extends AbstractList {
   private final List forwardList;

   Lists$ReverseList(List var1) {
      this.forwardList = (List)Preconditions.checkNotNull(var1);
   }

   List getForwardList() {
      return this.forwardList;
   }

   private int reverseIndex(int var1) {
      int var2 = this.size();
      Preconditions.checkElementIndex(var1, var2);
      return var2 - 1 - var1;
   }

   private int reversePosition(int var1) {
      int var2 = this.size();
      Preconditions.checkPositionIndex(var1, var2);
      return var2 - var1;
   }

   public void add(int var1, @Nullable Object var2) {
      this.forwardList.add(this.reversePosition(var1), var2);
   }

   public void clear() {
      this.forwardList.clear();
   }

   public Object remove(int var1) {
      return this.forwardList.remove(this.reverseIndex(var1));
   }

   protected void removeRange(int var1, int var2) {
      this.subList(var1, var2).clear();
   }

   public Object set(int var1, @Nullable Object var2) {
      return this.forwardList.set(this.reverseIndex(var1), var2);
   }

   public Object get(int var1) {
      return this.forwardList.get(this.reverseIndex(var1));
   }

   public int size() {
      return this.forwardList.size();
   }

   public List subList(int var1, int var2) {
      Preconditions.checkPositionIndexes(var1, var2, this.size());
      return Lists.reverse(this.forwardList.subList(this.reversePosition(var2), this.reversePosition(var1)));
   }

   public Iterator iterator() {
      return this.listIterator();
   }

   public ListIterator listIterator(int var1) {
      int var2 = this.reversePosition(var1);
      ListIterator var3 = this.forwardList.listIterator(var2);
      return new Lists$ReverseList$1(this, var3);
   }

   // $FF: synthetic method
   static int access$000(Lists$ReverseList var0, int var1) {
      return var0.reversePosition(var1);
   }
}
