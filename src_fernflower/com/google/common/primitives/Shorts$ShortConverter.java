package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

final class Shorts$ShortConverter extends Converter implements Serializable {
   static final Shorts$ShortConverter INSTANCE = new Shorts$ShortConverter();
   private static final long serialVersionUID = 1L;

   protected Short doForward(String var1) {
      return Short.decode(var1);
   }

   protected String doBackward(Short var1) {
      return var1.toString();
   }

   public String toString() {
      return "Shorts.stringConverter()";
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
