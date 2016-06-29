package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.ForwardingList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

@GwtCompatible
class Constraints$ConstrainedList extends ForwardingList {
   final List delegate;
   final Constraint constraint;

   Constraints$ConstrainedList(List var1, Constraint var2) {
      this.delegate = (List)Preconditions.checkNotNull(var1);
      this.constraint = (Constraint)Preconditions.checkNotNull(var2);
   }

   protected List delegate() {
      return this.delegate;
   }

   public boolean add(Object var1) {
      this.constraint.checkElement(var1);
      return this.delegate.add(var1);
   }

   public void add(int var1, Object var2) {
      this.constraint.checkElement(var2);
      this.delegate.add(var1, var2);
   }

   public boolean addAll(Collection var1) {
      return this.delegate.addAll(Constraints.access$000(var1, this.constraint));
   }

   public boolean addAll(int var1, Collection var2) {
      return this.delegate.addAll(var1, Constraints.access$000(var2, this.constraint));
   }

   public ListIterator listIterator() {
      return Constraints.access$100(this.delegate.listIterator(), this.constraint);
   }

   public ListIterator listIterator(int var1) {
      return Constraints.access$100(this.delegate.listIterator(var1), this.constraint);
   }

   public Object set(int var1, Object var2) {
      this.constraint.checkElement(var2);
      return this.delegate.set(var1, var2);
   }

   public List subList(int var1, int var2) {
      return Constraints.constrainedList(this.delegate.subList(var1, var2), this.constraint);
   }
}
