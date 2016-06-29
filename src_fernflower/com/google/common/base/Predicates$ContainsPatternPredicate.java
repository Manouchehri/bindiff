package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@GwtIncompatible("Only used by other GWT-incompatible code.")
class Predicates$ContainsPatternPredicate implements Predicate, Serializable {
   final Pattern pattern;
   private static final long serialVersionUID = 0L;

   Predicates$ContainsPatternPredicate(Pattern var1) {
      this.pattern = (Pattern)Preconditions.checkNotNull(var1);
   }

   public boolean apply(CharSequence var1) {
      return this.pattern.matcher(var1).find();
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.pattern.pattern(), Integer.valueOf(this.pattern.flags())});
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof Predicates$ContainsPatternPredicate)) {
         return false;
      } else {
         Predicates$ContainsPatternPredicate var2 = (Predicates$ContainsPatternPredicate)var1;
         return Objects.equal(this.pattern.pattern(), var2.pattern.pattern()) && Objects.equal(Integer.valueOf(this.pattern.flags()), Integer.valueOf(var2.pattern.flags()));
      }
   }

   public String toString() {
      String var1 = Objects.toStringHelper((Object)this.pattern).add("pattern", this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString();
      return (new StringBuilder(21 + String.valueOf(var1).length())).append("Predicates.contains(").append(var1).append(")").toString();
   }
}
