package com.google.common.base;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;

final class Converter$IdentityConverter extends Converter implements Serializable {
   static final Converter$IdentityConverter INSTANCE = new Converter$IdentityConverter();
   private static final long serialVersionUID = 0L;

   protected Object doForward(Object var1) {
      return var1;
   }

   protected Object doBackward(Object var1) {
      return var1;
   }

   public Converter$IdentityConverter reverse() {
      return this;
   }

   Converter doAndThen(Converter var1) {
      return (Converter)Preconditions.checkNotNull(var1, "otherConverter");
   }

   public String toString() {
      return "Converter.identity()";
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
