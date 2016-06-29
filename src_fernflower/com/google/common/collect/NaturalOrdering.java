package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.collect.ReverseNaturalOrdering;
import java.io.Serializable;

@GwtCompatible(
   serializable = true
)
final class NaturalOrdering extends Ordering implements Serializable {
   static final NaturalOrdering INSTANCE = new NaturalOrdering();
   private static final long serialVersionUID = 0L;

   public int compare(Comparable var1, Comparable var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      return var1.compareTo(var2);
   }

   public Ordering reverse() {
      return ReverseNaturalOrdering.INSTANCE;
   }

   private Object readResolve() {
      return INSTANCE;
   }

   public String toString() {
      return "Ordering.natural()";
   }
}
