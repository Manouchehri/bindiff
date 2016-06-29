package com.google.common.base;

import com.google.common.base.Converter;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Converter$ConverterComposition extends Converter implements Serializable {
   final Converter first;
   final Converter second;
   private static final long serialVersionUID = 0L;

   Converter$ConverterComposition(Converter var1, Converter var2) {
      this.first = var1;
      this.second = var2;
   }

   protected Object doForward(Object var1) {
      throw new AssertionError();
   }

   protected Object doBackward(Object var1) {
      throw new AssertionError();
   }

   @Nullable
   Object correctedDoForward(@Nullable Object var1) {
      return this.second.correctedDoForward(this.first.correctedDoForward(var1));
   }

   @Nullable
   Object correctedDoBackward(@Nullable Object var1) {
      return this.first.correctedDoBackward(this.second.correctedDoBackward(var1));
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof Converter$ConverterComposition)) {
         return false;
      } else {
         Converter$ConverterComposition var2 = (Converter$ConverterComposition)var1;
         return this.first.equals(var2.first) && this.second.equals(var2.second);
      }
   }

   public int hashCode() {
      return 31 * this.first.hashCode() + this.second.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.first);
      String var2 = String.valueOf(this.second);
      return (new StringBuilder(10 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(".andThen(").append(var2).append(")").toString();
   }
}
