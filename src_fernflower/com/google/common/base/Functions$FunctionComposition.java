package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$FunctionComposition implements Function, Serializable {
   private final Function g;
   private final Function f;
   private static final long serialVersionUID = 0L;

   public Functions$FunctionComposition(Function var1, Function var2) {
      this.g = (Function)Preconditions.checkNotNull(var1);
      this.f = (Function)Preconditions.checkNotNull(var2);
   }

   public Object apply(@Nullable Object var1) {
      return this.g.apply(this.f.apply(var1));
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof Functions$FunctionComposition)) {
         return false;
      } else {
         Functions$FunctionComposition var2 = (Functions$FunctionComposition)var1;
         return this.f.equals(var2.f) && this.g.equals(var2.g);
      }
   }

   public int hashCode() {
      return this.f.hashCode() ^ this.g.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.g);
      String var2 = String.valueOf(this.f);
      return (new StringBuilder(2 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append("(").append(var2).append(")").toString();
   }
}
