package com.google.common.base;

import com.google.common.base.BinaryPredicate;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

final class BinaryPredicates$Not implements BinaryPredicate, Serializable {
   final BinaryPredicate predicate;
   private static final long serialVersionUID = 7318841078083112007L;

   BinaryPredicates$Not(BinaryPredicate var1) {
      this.predicate = (BinaryPredicate)Preconditions.checkNotNull(var1);
   }

   public boolean apply(@Nullable Object var1, @Nullable Object var2) {
      return !this.predicate.apply(var1, var2);
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof BinaryPredicates$Not) {
         BinaryPredicates$Not var2 = (BinaryPredicates$Not)var1;
         return this.predicate.equals(var2.predicate);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.predicate.hashCode();
   }
}
