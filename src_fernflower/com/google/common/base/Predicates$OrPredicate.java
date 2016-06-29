package com.google.common.base;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Predicates$1;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

class Predicates$OrPredicate implements Predicate, Serializable {
   private final List components;
   private static final long serialVersionUID = 0L;

   private Predicates$OrPredicate(List var1) {
      this.components = var1;
   }

   public boolean apply(@Nullable Object var1) {
      for(int var2 = 0; var2 < this.components.size(); ++var2) {
         if(((Predicate)this.components.get(var2)).apply(var1)) {
            return true;
         }
      }

      return false;
   }

   public int hashCode() {
      return this.components.hashCode() + 87855567;
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Predicates$OrPredicate) {
         Predicates$OrPredicate var2 = (Predicates$OrPredicate)var1;
         return this.components.equals(var2.components);
      } else {
         return false;
      }
   }

   public String toString() {
      String var1 = Predicates.access$800().join((Iterable)this.components);
      return (new StringBuilder(15 + String.valueOf(var1).length())).append("Predicates.or(").append(var1).append(")").toString();
   }

   // $FF: synthetic method
   Predicates$OrPredicate(List var1, Predicates$1 var2) {
      this(var1);
   }
}
