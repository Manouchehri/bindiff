package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

class Functions$FunctionForMapNoDefault implements Function, Serializable {
   final Map map;
   private static final long serialVersionUID = 0L;

   Functions$FunctionForMapNoDefault(Map var1) {
      this.map = (Map)Preconditions.checkNotNull(var1);
   }

   public Object apply(@Nullable Object var1) {
      Object var2 = this.map.get(var1);
      Preconditions.checkArgument(var2 != null || this.map.containsKey(var1), "Key \'%s\' not present in map", new Object[]{var1});
      return var2;
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Functions$FunctionForMapNoDefault) {
         Functions$FunctionForMapNoDefault var2 = (Functions$FunctionForMapNoDefault)var1;
         return this.map.equals(var2.map);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.map.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.map);
      return (new StringBuilder(18 + String.valueOf(var1).length())).append("Functions.forMap(").append(var1).append(")").toString();
   }
}
