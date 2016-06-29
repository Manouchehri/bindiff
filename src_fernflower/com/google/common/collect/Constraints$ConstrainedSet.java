package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.Set;

class Constraints$ConstrainedSet extends ForwardingSet {
   private final Set delegate;
   private final Constraint constraint;

   public Constraints$ConstrainedSet(Set var1, Constraint var2) {
      this.delegate = (Set)Preconditions.checkNotNull(var1);
      this.constraint = (Constraint)Preconditions.checkNotNull(var2);
   }

   protected Set delegate() {
      return this.delegate;
   }

   public boolean add(Object var1) {
      this.constraint.checkElement(var1);
      return this.delegate.add(var1);
   }

   public boolean addAll(Collection var1) {
      return this.delegate.addAll(Constraints.access$000(var1, this.constraint));
   }
}
