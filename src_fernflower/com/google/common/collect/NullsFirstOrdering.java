package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true
)
final class NullsFirstOrdering extends Ordering implements Serializable {
   final Ordering ordering;
   private static final long serialVersionUID = 0L;

   NullsFirstOrdering(Ordering var1) {
      this.ordering = var1;
   }

   public int compare(@Nullable Object var1, @Nullable Object var2) {
      return var1 == var2?0:(var1 == null?-1:(var2 == null?1:this.ordering.compare(var1, var2)));
   }

   public Ordering reverse() {
      return this.ordering.reverse().nullsLast();
   }

   public Ordering nullsFirst() {
      return this;
   }

   public Ordering nullsLast() {
      return this.ordering.nullsLast();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof NullsFirstOrdering) {
         NullsFirstOrdering var2 = (NullsFirstOrdering)var1;
         return this.ordering.equals(var2.ordering);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.ordering.hashCode() ^ 957692532;
   }

   public String toString() {
      String var1 = String.valueOf(this.ordering);
      return (new StringBuilder(13 + String.valueOf(var1).length())).append(var1).append(".nullsFirst()").toString();
   }
}
