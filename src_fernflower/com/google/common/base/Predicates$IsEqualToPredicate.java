package com.google.common.base;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import java.io.Serializable;
import javax.annotation.Nullable;

class Predicates$IsEqualToPredicate implements Predicate, Serializable {
   private final Object target;
   private static final long serialVersionUID = 0L;

   private Predicates$IsEqualToPredicate(Object var1) {
      this.target = var1;
   }

   public boolean apply(Object var1) {
      return this.target.equals(var1);
   }

   public int hashCode() {
      return this.target.hashCode();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Predicates$IsEqualToPredicate) {
         Predicates$IsEqualToPredicate var2 = (Predicates$IsEqualToPredicate)var1;
         return this.target.equals(var2.target);
      } else {
         return false;
      }
   }

   public String toString() {
      String var1 = String.valueOf(this.target);
      return (new StringBuilder(20 + String.valueOf(var1).length())).append("Predicates.equalTo(").append(var1).append(")").toString();
   }

   // $FF: synthetic method
   Predicates$IsEqualToPredicate(Object var1, Predicates$1 var2) {
      this(var1);
   }
}
