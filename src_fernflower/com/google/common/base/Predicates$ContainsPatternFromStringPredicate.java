package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicates$ContainsPatternPredicate;
import java.util.regex.Pattern;

@GwtIncompatible("Only used by other GWT-incompatible code.")
class Predicates$ContainsPatternFromStringPredicate extends Predicates$ContainsPatternPredicate {
   private static final long serialVersionUID = 0L;

   Predicates$ContainsPatternFromStringPredicate(String var1) {
      super(Pattern.compile(var1));
   }

   public String toString() {
      String var1 = String.valueOf(this.pattern.pattern());
      return (new StringBuilder(28 + String.valueOf(var1).length())).append("Predicates.containsPattern(").append(var1).append(")").toString();
   }
}
