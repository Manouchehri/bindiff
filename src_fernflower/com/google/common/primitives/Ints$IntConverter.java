package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

final class Ints$IntConverter extends Converter implements Serializable {
   static final Ints$IntConverter INSTANCE = new Ints$IntConverter();
   private static final long serialVersionUID = 1L;

   protected Integer doForward(String var1) {
      return Integer.decode(var1);
   }

   protected String doBackward(Integer var1) {
      return var1.toString();
   }

   public String toString() {
      return "Ints.stringConverter()";
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
