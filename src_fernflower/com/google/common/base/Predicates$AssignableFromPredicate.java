package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtIncompatible("Class.isAssignableFrom")
class Predicates$AssignableFromPredicate implements Predicate, Serializable {
   private final Class clazz;
   private static final long serialVersionUID = 0L;

   private Predicates$AssignableFromPredicate(Class var1) {
      this.clazz = (Class)Preconditions.checkNotNull(var1);
   }

   public boolean apply(Class var1) {
      return this.clazz.isAssignableFrom(var1);
   }

   public int hashCode() {
      return this.clazz.hashCode();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Predicates$AssignableFromPredicate) {
         Predicates$AssignableFromPredicate var2 = (Predicates$AssignableFromPredicate)var1;
         return this.clazz == var2.clazz;
      } else {
         return false;
      }
   }

   public String toString() {
      String var1 = String.valueOf(this.clazz.getName());
      return (new StringBuilder(27 + String.valueOf(var1).length())).append("Predicates.assignableFrom(").append(var1).append(")").toString();
   }

   // $FF: synthetic method
   Predicates$AssignableFromPredicate(Class var1, Predicates$1 var2) {
      this(var1);
   }
}
