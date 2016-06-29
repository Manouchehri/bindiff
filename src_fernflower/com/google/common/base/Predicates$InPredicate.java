package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

class Predicates$InPredicate implements Predicate, Serializable {
   private final Collection target;
   private static final long serialVersionUID = 0L;

   private Predicates$InPredicate(Collection var1) {
      this.target = (Collection)Preconditions.checkNotNull(var1);
   }

   public boolean apply(@Nullable Object var1) {
      try {
         return this.target.contains(var1);
      } catch (NullPointerException var3) {
         return false;
      } catch (ClassCastException var4) {
         return false;
      }
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Predicates$InPredicate) {
         Predicates$InPredicate var2 = (Predicates$InPredicate)var1;
         return this.target.equals(var2.target);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.target.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.target);
      return (new StringBuilder(15 + String.valueOf(var1).length())).append("Predicates.in(").append(var1).append(")").toString();
   }

   // $FF: synthetic method
   Predicates$InPredicate(Collection var1, Predicates$1 var2) {
      this(var1);
   }
}
