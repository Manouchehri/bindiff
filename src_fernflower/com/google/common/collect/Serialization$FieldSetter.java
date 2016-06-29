package com.google.common.collect;

import com.google.common.collect.Serialization$1;
import java.lang.reflect.Field;

final class Serialization$FieldSetter {
   private final Field field;

   private Serialization$FieldSetter(Field var1) {
      this.field = var1;
      var1.setAccessible(true);
   }

   void set(Object var1, Object var2) {
      try {
         this.field.set(var1, var2);
      } catch (IllegalAccessException var4) {
         throw new AssertionError(var4);
      }
   }

   void set(Object var1, int var2) {
      try {
         this.field.set(var1, Integer.valueOf(var2));
      } catch (IllegalAccessException var4) {
         throw new AssertionError(var4);
      }
   }

   // $FF: synthetic method
   Serialization$FieldSetter(Field var1, Serialization$1 var2) {
      this(var1);
   }
}
