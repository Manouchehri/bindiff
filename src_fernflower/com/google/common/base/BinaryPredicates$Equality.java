package com.google.common.base;

import com.google.common.base.BinaryPredicate;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

enum BinaryPredicates$Equality implements BinaryPredicate {
   Equality;

   public boolean apply(@Nullable Object var1, @Nullable Object var2) {
      return Objects.equal(var1, var2);
   }
}
