package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

final class Doubles$DoubleConverter extends Converter implements Serializable {
   static final Doubles$DoubleConverter INSTANCE = new Doubles$DoubleConverter();
   private static final long serialVersionUID = 1L;

   protected Double doForward(String var1) {
      return Double.valueOf(var1);
   }

   protected String doBackward(Double var1) {
      return var1.toString();
   }

   public String toString() {
      return "Doubles.stringConverter()";
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
