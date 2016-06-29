package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
final class FunctionalEquivalence extends Equivalence implements Serializable {
   private static final long serialVersionUID = 0L;
   private final Function function;
   private final Equivalence resultEquivalence;

   FunctionalEquivalence(Function var1, Equivalence var2) {
      this.function = (Function)Preconditions.checkNotNull(var1);
      this.resultEquivalence = (Equivalence)Preconditions.checkNotNull(var2);
   }

   protected boolean doEquivalent(Object var1, Object var2) {
      return this.resultEquivalence.equivalent(this.function.apply(var1), this.function.apply(var2));
   }

   protected int doHash(Object var1) {
      return this.resultEquivalence.hash(this.function.apply(var1));
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof FunctionalEquivalence)) {
         return false;
      } else {
         FunctionalEquivalence var2 = (FunctionalEquivalence)var1;
         return this.function.equals(var2.function) && this.resultEquivalence.equals(var2.resultEquivalence);
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.function, this.resultEquivalence});
   }

   public String toString() {
      String var1 = String.valueOf(this.resultEquivalence);
      String var2 = String.valueOf(this.function);
      return (new StringBuilder(13 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(".onResultOf(").append(var2).append(")").toString();
   }
}
