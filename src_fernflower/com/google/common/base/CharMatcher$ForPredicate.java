package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

final class CharMatcher$ForPredicate extends CharMatcher {
   private final Predicate predicate;

   CharMatcher$ForPredicate(Predicate var1) {
      this.predicate = (Predicate)Preconditions.checkNotNull(var1);
   }

   public boolean matches(char var1) {
      return this.predicate.apply(Character.valueOf(var1));
   }

   public boolean apply(Character var1) {
      return this.predicate.apply(Preconditions.checkNotNull(var1));
   }

   public String toString() {
      String var1 = String.valueOf(this.predicate);
      return (new StringBuilder(26 + String.valueOf(var1).length())).append("CharMatcher.forPredicate(").append(var1).append(")").toString();
   }
}
