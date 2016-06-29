package com.google.common.collect;

import com.google.common.collect.Constraint;
import com.google.common.collect.ForwardingListIterator;
import java.util.ListIterator;

class Constraints$ConstrainedListIterator extends ForwardingListIterator {
   private final ListIterator delegate;
   private final Constraint constraint;

   public Constraints$ConstrainedListIterator(ListIterator var1, Constraint var2) {
      this.delegate = var1;
      this.constraint = var2;
   }

   protected ListIterator delegate() {
      return this.delegate;
   }

   public void add(Object var1) {
      this.constraint.checkElement(var1);
      this.delegate.add(var1);
   }

   public void set(Object var1) {
      this.constraint.checkElement(var1);
      this.delegate.set(var1);
   }
}
