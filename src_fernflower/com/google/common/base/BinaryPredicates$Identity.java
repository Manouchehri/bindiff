package com.google.common.base;

import com.google.common.base.BinaryPredicate;
import javax.annotation.Nullable;

enum BinaryPredicates$Identity implements BinaryPredicate {
   Identity;

   public boolean apply(@Nullable Object var1, @Nullable Object var2) {
      return var1 == var2;
   }
}
