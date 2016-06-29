package com.google.common.collect;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Maps$BiMapConverter extends Converter implements Serializable {
   private final BiMap bimap;
   private static final long serialVersionUID = 0L;

   Maps$BiMapConverter(BiMap var1) {
      this.bimap = (BiMap)Preconditions.checkNotNull(var1);
   }

   protected Object doForward(Object var1) {
      return convert(this.bimap, var1);
   }

   protected Object doBackward(Object var1) {
      return convert(this.bimap.inverse(), var1);
   }

   private static Object convert(BiMap var0, Object var1) {
      Object var2 = var0.get(var1);
      Preconditions.checkArgument(var2 != null, "No non-null mapping present for input: %s", new Object[]{var1});
      return var2;
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Maps$BiMapConverter) {
         Maps$BiMapConverter var2 = (Maps$BiMapConverter)var1;
         return this.bimap.equals(var2.bimap);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.bimap.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.bimap);
      return (new StringBuilder(18 + String.valueOf(var1).length())).append("Maps.asConverter(").append(var1).append(")").toString();
   }
}
