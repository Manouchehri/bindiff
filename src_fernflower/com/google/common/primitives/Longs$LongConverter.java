package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

final class Longs$LongConverter extends Converter implements Serializable {
   static final Longs$LongConverter INSTANCE = new Longs$LongConverter();
   private static final long serialVersionUID = 1L;

   protected Long doForward(String var1) {
      return Long.decode(var1);
   }

   protected String doBackward(Long var1) {
      return var1.toString();
   }

   public String toString() {
      return "Longs.stringConverter()";
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
