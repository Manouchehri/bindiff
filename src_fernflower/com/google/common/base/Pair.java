package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Pair$FirstComparator;
import com.google.common.base.Pair$PairFirstFunction;
import com.google.common.base.Pair$PairSecondFunction;
import com.google.common.base.Pair$SecondComparator;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GoogleInternal
@GwtCompatible(
   serializable = true
)
public class Pair implements Serializable {
   public final Object first;
   public final Object second;
   private static final long serialVersionUID = 747826592375603043L;

   public static Pair of(@Nullable Object var0, @Nullable Object var1) {
      return new Pair(var0, var1);
   }

   protected Pair(@Nullable Object var1, @Nullable Object var2) {
      this.first = var1;
      this.second = var2;
   }

   public Object getFirst() {
      return this.first;
   }

   public Object getSecond() {
      return this.second;
   }

   public static Function firstFunction() {
      return Pair$PairFirstFunction.INSTANCE;
   }

   public static Function secondFunction() {
      return Pair$PairSecondFunction.INSTANCE;
   }

   public static Comparator compareByFirst() {
      return Pair$FirstComparator.FIRST_COMPARATOR;
   }

   public static Comparator compareBySecond() {
      return Pair$SecondComparator.SECOND_COMPARATOR;
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof Pair)) {
         return false;
      } else {
         Pair var2 = (Pair)var1;
         return Objects.equal(this.getFirst(), var2.getFirst()) && Objects.equal(this.getSecond(), var2.getSecond());
      }
   }

   public int hashCode() {
      int var1 = this.first == null?0:this.first.hashCode();
      int var2 = this.second == null?0:this.second.hashCode();
      return 31 * var1 + var2;
   }

   public String toString() {
      String var1 = String.valueOf(this.getFirst());
      String var2 = String.valueOf(this.getSecond());
      return (new StringBuilder(4 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("(").append(var1).append(", ").append(var2).append(")").toString();
   }
}
