package com.google.common.base;

import com.google.common.base.BinaryPredicate;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import javax.annotation.Nullable;

final class BinaryPredicates$Second implements BinaryPredicate, Serializable {
   final Predicate predicate;
   private static final long serialVersionUID = -7134579481937611424L;

   BinaryPredicates$Second(Predicate var1) {
      this.predicate = (Predicate)Preconditions.checkNotNull(var1);
   }

   public boolean apply(@Nullable Object var1, @Nullable Object var2) {
      return this.predicate.apply(var2);
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof BinaryPredicates$Second) {
         BinaryPredicates$Second var2 = (BinaryPredicates$Second)var1;
         return this.predicate.equals(var2.predicate);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.predicate.hashCode();
   }
}
