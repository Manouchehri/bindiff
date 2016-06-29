package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.ForwardingSortedSet;
import java.util.Collection;
import java.util.SortedSet;

class Constraints$ConstrainedSortedSet extends ForwardingSortedSet {
   final SortedSet delegate;
   final Constraint constraint;

   Constraints$ConstrainedSortedSet(SortedSet var1, Constraint var2) {
      this.delegate = (SortedSet)Preconditions.checkNotNull(var1);
      this.constraint = (Constraint)Preconditions.checkNotNull(var2);
   }

   protected SortedSet delegate() {
      return this.delegate;
   }

   public SortedSet headSet(Object var1) {
      return Constraints.constrainedSortedSet(this.delegate.headSet(var1), this.constraint);
   }

   public SortedSet subSet(Object var1, Object var2) {
      return Constraints.constrainedSortedSet(this.delegate.subSet(var1, var2), this.constraint);
   }

   public SortedSet tailSet(Object var1) {
      return Constraints.constrainedSortedSet(this.delegate.tailSet(var1), this.constraint);
   }

   public boolean add(Object var1) {
      this.constraint.checkElement(var1);
      return this.delegate.add(var1);
   }

   public boolean addAll(Collection var1) {
      return this.delegate.addAll(Constraints.access$000(var1, this.constraint));
   }
}
