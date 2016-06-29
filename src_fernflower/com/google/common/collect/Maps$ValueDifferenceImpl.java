package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.MapDifference$ValueDifference;
import javax.annotation.Nullable;

class Maps$ValueDifferenceImpl implements MapDifference$ValueDifference {
   private final Object left;
   private final Object right;

   static MapDifference$ValueDifference create(@Nullable Object var0, @Nullable Object var1) {
      return new Maps$ValueDifferenceImpl(var0, var1);
   }

   private Maps$ValueDifferenceImpl(@Nullable Object var1, @Nullable Object var2) {
      this.left = var1;
      this.right = var2;
   }

   public Object leftValue() {
      return this.left;
   }

   public Object rightValue() {
      return this.right;
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof MapDifference$ValueDifference)) {
         return false;
      } else {
         MapDifference$ValueDifference var2 = (MapDifference$ValueDifference)var1;
         return Objects.equal(this.left, var2.leftValue()) && Objects.equal(this.right, var2.rightValue());
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.left, this.right});
   }

   public String toString() {
      String var1 = String.valueOf(this.left);
      String var2 = String.valueOf(this.right);
      return (new StringBuilder(4 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("(").append(var1).append(", ").append(var2).append(")").toString();
   }
}
