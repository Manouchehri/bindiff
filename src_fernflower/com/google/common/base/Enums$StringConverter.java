package com.google.common.base;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Enums$StringConverter extends Converter implements Serializable {
   private final Class enumClass;
   private static final long serialVersionUID = 0L;

   Enums$StringConverter(Class var1) {
      this.enumClass = (Class)Preconditions.checkNotNull(var1);
   }

   protected Enum doForward(String var1) {
      return Enum.valueOf(this.enumClass, var1);
   }

   protected String doBackward(Enum var1) {
      return var1.name();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Enums$StringConverter) {
         Enums$StringConverter var2 = (Enums$StringConverter)var1;
         return this.enumClass.equals(var2.enumClass);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.enumClass.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.enumClass.getName());
      return (new StringBuilder(29 + String.valueOf(var1).length())).append("Enums.stringConverter(").append(var1).append(".class)").toString();
   }
}
