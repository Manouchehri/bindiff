package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import javax.annotation.Nullable;

class Predicates$NotPredicate implements Predicate, Serializable {
   final Predicate predicate;
   private static final long serialVersionUID = 0L;

   Predicates$NotPredicate(Predicate var1) {
      this.predicate = (Predicate)Preconditions.checkNotNull(var1);
   }

   public boolean apply(@Nullable Object var1) {
      return !this.predicate.apply(var1);
   }

   public int hashCode() {
      return ~this.predicate.hashCode();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Predicates$NotPredicate) {
         Predicates$NotPredicate var2 = (Predicates$NotPredicate)var1;
         return this.predicate.equals(var2.predicate);
      } else {
         return false;
      }
   }

   public String toString() {
      String var1 = String.valueOf(this.predicate);
      return (new StringBuilder(16 + String.valueOf(var1).length())).append("Predicates.not(").append(var1).append(")").toString();
   }
}
