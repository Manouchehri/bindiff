package com.google.common.base;

import com.google.common.base.Equivalence;
import com.google.common.base.Equivalence$1;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

public final class Equivalence$Wrapper implements Serializable {
   private final Equivalence equivalence;
   @Nullable
   private final Object reference;
   private static final long serialVersionUID = 0L;

   private Equivalence$Wrapper(Equivalence var1, @Nullable Object var2) {
      this.equivalence = (Equivalence)Preconditions.checkNotNull(var1);
      this.reference = var2;
   }

   @Nullable
   public Object get() {
      return this.reference;
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 == this) {
         return true;
      } else {
         if(var1 instanceof Equivalence$Wrapper) {
            Equivalence$Wrapper var2 = (Equivalence$Wrapper)var1;
            if(this.equivalence.equals(var2.equivalence)) {
               Equivalence var3 = this.equivalence;
               return var3.equivalent(this.reference, var2.reference);
            }
         }

         return false;
      }
   }

   public int hashCode() {
      return this.equivalence.hash(this.reference);
   }

   public String toString() {
      String var1 = String.valueOf(this.equivalence);
      String var2 = String.valueOf(this.reference);
      return (new StringBuilder(7 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(".wrap(").append(var2).append(")").toString();
   }

   // $FF: synthetic method
   Equivalence$Wrapper(Equivalence var1, Object var2, Equivalence$1 var3) {
      this(var1, var2);
   }
}
