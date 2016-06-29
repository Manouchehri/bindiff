package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$ConstantFunction implements Function, Serializable {
   private final Object value;
   private static final long serialVersionUID = 0L;

   public Functions$ConstantFunction(@Nullable Object var1) {
      this.value = var1;
   }

   public Object apply(@Nullable Object var1) {
      return this.value;
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Functions$ConstantFunction) {
         Functions$ConstantFunction var2 = (Functions$ConstantFunction)var1;
         return Objects.equal(this.value, var2.value);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.value == null?0:this.value.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.value);
      return (new StringBuilder(20 + String.valueOf(var1).length())).append("Functions.constant(").append(var1).append(")").toString();
   }
}
