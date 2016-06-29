package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

final class Floats$FloatConverter extends Converter implements Serializable {
   static final Floats$FloatConverter INSTANCE = new Floats$FloatConverter();
   private static final long serialVersionUID = 1L;

   protected Float doForward(String var1) {
      return Float.valueOf(var1);
   }

   protected String doBackward(Float var1) {
      return var1.toString();
   }

   public String toString() {
      return "Floats.stringConverter()";
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
