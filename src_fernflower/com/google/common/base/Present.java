package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
final class Present extends Optional {
   private final Object reference;
   private static final long serialVersionUID = 0L;

   Present(Object var1) {
      this.reference = var1;
   }

   public boolean isPresent() {
      return true;
   }

   public Object get() {
      return this.reference;
   }

   public Object or(Object var1) {
      Preconditions.checkNotNull(var1, "use Optional.orNull() instead of Optional.or(null)");
      return this.reference;
   }

   public Optional or(Optional var1) {
      Preconditions.checkNotNull(var1);
      return this;
   }

   public Object or(Supplier var1) {
      Preconditions.checkNotNull(var1);
      return this.reference;
   }

   public Object orNull() {
      return this.reference;
   }

   public Set asSet() {
      return Collections.singleton(this.reference);
   }

   public Optional transform(Function var1) {
      return new Present(Preconditions.checkNotNull(var1.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Present) {
         Present var2 = (Present)var1;
         return this.reference.equals(var2.reference);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return 1502476572 + this.reference.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.reference);
      return (new StringBuilder(13 + String.valueOf(var1).length())).append("Optional.of(").append(var1).append(")").toString();
   }
}
