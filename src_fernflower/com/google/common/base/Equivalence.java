package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Equivalence$1;
import com.google.common.base.Equivalence$Equals;
import com.google.common.base.Equivalence$EquivalentToPredicate;
import com.google.common.base.Equivalence$Identity;
import com.google.common.base.Equivalence$Wrapper;
import com.google.common.base.Function;
import com.google.common.base.FunctionalEquivalence;
import com.google.common.base.PairwiseEquivalence;
import com.google.common.base.Predicate;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public abstract class Equivalence {
   public final boolean equivalent(@Nullable Object var1, @Nullable Object var2) {
      return var1 == var2?true:(var1 != null && var2 != null?this.doEquivalent(var1, var2):false);
   }

   protected abstract boolean doEquivalent(Object var1, Object var2);

   public final int hash(@Nullable Object var1) {
      return var1 == null?0:this.doHash(var1);
   }

   protected abstract int doHash(Object var1);

   public final Equivalence onResultOf(Function var1) {
      return new FunctionalEquivalence(var1, this);
   }

   public final Equivalence$Wrapper wrap(@Nullable Object var1) {
      return new Equivalence$Wrapper(this, var1, (Equivalence$1)null);
   }

   @GwtCompatible(
      serializable = true
   )
   public final Equivalence pairwise() {
      return new PairwiseEquivalence(this);
   }

   @Beta
   public final Predicate equivalentTo(@Nullable Object var1) {
      return new Equivalence$EquivalentToPredicate(this, var1);
   }

   public static Equivalence equals() {
      return Equivalence$Equals.INSTANCE;
   }

   public static Equivalence identity() {
      return Equivalence$Identity.INSTANCE;
   }
}
