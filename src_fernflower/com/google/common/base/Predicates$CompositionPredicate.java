package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import java.io.Serializable;
import javax.annotation.Nullable;

class Predicates$CompositionPredicate implements Predicate, Serializable {
   final Predicate p;
   final Function f;
   private static final long serialVersionUID = 0L;

   private Predicates$CompositionPredicate(Predicate var1, Function var2) {
      this.p = (Predicate)Preconditions.checkNotNull(var1);
      this.f = (Function)Preconditions.checkNotNull(var2);
   }

   public boolean apply(@Nullable Object var1) {
      return this.p.apply(this.f.apply(var1));
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof Predicates$CompositionPredicate)) {
         return false;
      } else {
         Predicates$CompositionPredicate var2 = (Predicates$CompositionPredicate)var1;
         return this.f.equals(var2.f) && this.p.equals(var2.p);
      }
   }

   public int hashCode() {
      return this.f.hashCode() ^ this.p.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.p);
      String var2 = String.valueOf(this.f);
      return (new StringBuilder(2 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append("(").append(var2).append(")").toString();
   }

   // $FF: synthetic method
   Predicates$CompositionPredicate(Predicate var1, Function var2, Predicates$1 var3) {
      this(var1, var2);
   }
}
