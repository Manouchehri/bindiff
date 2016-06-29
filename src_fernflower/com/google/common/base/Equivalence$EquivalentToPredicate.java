package com.google.common.base;

import com.google.common.base.Equivalence;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Equivalence$EquivalentToPredicate implements Predicate, Serializable {
   private final Equivalence equivalence;
   @Nullable
   private final Object target;
   private static final long serialVersionUID = 0L;

   Equivalence$EquivalentToPredicate(Equivalence var1, @Nullable Object var2) {
      this.equivalence = (Equivalence)Preconditions.checkNotNull(var1);
      this.target = var2;
   }

   public boolean apply(@Nullable Object var1) {
      return this.equivalence.equivalent(var1, this.target);
   }

   public boolean equals(@Nullable Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof Equivalence$EquivalentToPredicate)) {
         return false;
      } else {
         Equivalence$EquivalentToPredicate var2 = (Equivalence$EquivalentToPredicate)var1;
         return this.equivalence.equals(var2.equivalence) && Objects.equal(this.target, var2.target);
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.equivalence, this.target});
   }

   public String toString() {
      String var1 = String.valueOf(this.equivalence);
      String var2 = String.valueOf(this.target);
      return (new StringBuilder(15 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(".equivalentTo(").append(var2).append(")").toString();
   }
}
