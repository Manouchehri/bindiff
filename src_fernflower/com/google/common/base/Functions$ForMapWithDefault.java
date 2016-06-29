package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

class Functions$ForMapWithDefault implements Function, Serializable {
   final Map map;
   final Object defaultValue;
   private static final long serialVersionUID = 0L;

   Functions$ForMapWithDefault(Map var1, @Nullable Object var2) {
      this.map = (Map)Preconditions.checkNotNull(var1);
      this.defaultValue = var2;
   }

   public Object apply(@Nullable Object var1) {
      Object var2 = this.map.get(var1);
      return var2 == null && !this.map.containsKey(var1)?this.defaultValue:var2;
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof Functions$ForMapWithDefault)) {
         return false;
      } else {
         Functions$ForMapWithDefault var2 = (Functions$ForMapWithDefault)var1;
         return this.map.equals(var2.map) && Objects.equal(this.defaultValue, var2.defaultValue);
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.map, this.defaultValue});
   }

   public String toString() {
      String var1 = String.valueOf(this.map);
      String var2 = String.valueOf(this.defaultValue);
      return (new StringBuilder(33 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("Functions.forMap(").append(var1).append(", defaultValue=").append(var2).append(")").toString();
   }
}
