package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Multiset$Entry;
import javax.annotation.Nullable;

abstract class Multisets$AbstractEntry implements Multiset$Entry {
   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof Multiset$Entry)) {
         return false;
      } else {
         Multiset$Entry var2 = (Multiset$Entry)var1;
         return this.getCount() == var2.getCount() && Objects.equal(this.getElement(), var2.getElement());
      }
   }

   public int hashCode() {
      Object var1 = this.getElement();
      return (var1 == null?0:var1.hashCode()) ^ this.getCount();
   }

   public String toString() {
      String var1 = String.valueOf(this.getElement());
      int var2 = this.getCount();
      return var2 == 1?var1:(new StringBuilder(14 + String.valueOf(var1).length())).append(var1).append(" x ").append(var2).toString();
   }
}
