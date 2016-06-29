package com.google.common.base;

import com.google.common.base.Converter;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Converter$ReverseConverter extends Converter implements Serializable {
   final Converter original;
   private static final long serialVersionUID = 0L;

   Converter$ReverseConverter(Converter var1) {
      this.original = var1;
   }

   protected Object doForward(Object var1) {
      throw new AssertionError();
   }

   protected Object doBackward(Object var1) {
      throw new AssertionError();
   }

   @Nullable
   Object correctedDoForward(@Nullable Object var1) {
      return this.original.correctedDoBackward(var1);
   }

   @Nullable
   Object correctedDoBackward(@Nullable Object var1) {
      return this.original.correctedDoForward(var1);
   }

   public Converter reverse() {
      return this.original;
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Converter$ReverseConverter) {
         Converter$ReverseConverter var2 = (Converter$ReverseConverter)var1;
         return this.original.equals(var2.original);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return ~this.original.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.original);
      return (new StringBuilder(10 + String.valueOf(var1).length())).append(var1).append(".reverse()").toString();
   }
}
