package com.google.common.base;

import com.google.common.base.Converter;
import com.google.common.base.Converter$1;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Converter$FunctionBasedConverter extends Converter implements Serializable {
   private final Function forwardFunction;
   private final Function backwardFunction;

   private Converter$FunctionBasedConverter(Function var1, Function var2) {
      this.forwardFunction = (Function)Preconditions.checkNotNull(var1);
      this.backwardFunction = (Function)Preconditions.checkNotNull(var2);
   }

   protected Object doForward(Object var1) {
      return this.forwardFunction.apply(var1);
   }

   protected Object doBackward(Object var1) {
      return this.backwardFunction.apply(var1);
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof Converter$FunctionBasedConverter)) {
         return false;
      } else {
         Converter$FunctionBasedConverter var2 = (Converter$FunctionBasedConverter)var1;
         return this.forwardFunction.equals(var2.forwardFunction) && this.backwardFunction.equals(var2.backwardFunction);
      }
   }

   public int hashCode() {
      return this.forwardFunction.hashCode() * 31 + this.backwardFunction.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.forwardFunction);
      String var2 = String.valueOf(this.backwardFunction);
      return (new StringBuilder(18 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("Converter.from(").append(var1).append(", ").append(var2).append(")").toString();
   }

   // $FF: synthetic method
   Converter$FunctionBasedConverter(Function var1, Function var2, Converter$1 var3) {
      this(var1, var2);
   }
}
