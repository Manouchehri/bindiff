package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Functions$1;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$PredicateFunction implements Function, Serializable {
   private final Predicate predicate;
   private static final long serialVersionUID = 0L;

   private Functions$PredicateFunction(Predicate var1) {
      this.predicate = (Predicate)Preconditions.checkNotNull(var1);
   }

   public Boolean apply(@Nullable Object var1) {
      return Boolean.valueOf(this.predicate.apply(var1));
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Functions$PredicateFunction) {
         Functions$PredicateFunction var2 = (Functions$PredicateFunction)var1;
         return this.predicate.equals(var2.predicate);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.predicate.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.predicate);
      return (new StringBuilder(24 + String.valueOf(var1).length())).append("Functions.forPredicate(").append(var1).append(")").toString();
   }

   // $FF: synthetic method
   Functions$PredicateFunction(Predicate var1, Functions$1 var2) {
      this(var1);
   }
}
