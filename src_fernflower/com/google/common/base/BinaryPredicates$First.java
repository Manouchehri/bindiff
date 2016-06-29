package com.google.common.base;

import com.google.common.base.BinaryPredicate;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import javax.annotation.Nullable;

final class BinaryPredicates$First implements BinaryPredicate, Serializable {
   final Predicate predicate;
   private static final long serialVersionUID = 5389902773091803723L;

   BinaryPredicates$First(Predicate var1) {
      this.predicate = (Predicate)Preconditions.checkNotNull(var1);
   }

   public boolean apply(@Nullable Object var1, @Nullable Object var2) {
      return this.predicate.apply(var1);
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof BinaryPredicates$First) {
         BinaryPredicates$First var2 = (BinaryPredicates$First)var1;
         return this.predicate.equals(var2.predicate);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.predicate.hashCode();
   }
}
