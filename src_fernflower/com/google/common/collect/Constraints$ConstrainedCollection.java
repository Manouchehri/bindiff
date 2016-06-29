package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.ForwardingCollection;
import java.util.Collection;

class Constraints$ConstrainedCollection extends ForwardingCollection {
   private final Collection delegate;
   private final Constraint constraint;

   public Constraints$ConstrainedCollection(Collection var1, Constraint var2) {
      this.delegate = (Collection)Preconditions.checkNotNull(var1);
      this.constraint = (Constraint)Preconditions.checkNotNull(var2);
   }

   protected Collection delegate() {
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
