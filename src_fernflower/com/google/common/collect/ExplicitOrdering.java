package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Ordering$IncomparableValueException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true
)
final class ExplicitOrdering extends Ordering implements Serializable {
   final ImmutableMap rankMap;
   private static final long serialVersionUID = 0L;

   ExplicitOrdering(List var1) {
      this(Maps.indexMap(var1));
   }

   ExplicitOrdering(ImmutableMap var1) {
      this.rankMap = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.rank(var1) - this.rank(var2);
   }

   private int rank(Object var1) {
      Integer var2 = (Integer)this.rankMap.get(var1);
      if(var2 == null) {
         throw new Ordering$IncomparableValueException(var1);
      } else {
         return var2.intValue();
      }
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof ExplicitOrdering) {
         ExplicitOrdering var2 = (ExplicitOrdering)var1;
         return this.rankMap.equals(var2.rankMap);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.rankMap.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.rankMap.keySet());
      return (new StringBuilder(19 + String.valueOf(var1).length())).append("Ordering.explicit(").append(var1).append(")").toString();
   }
}
