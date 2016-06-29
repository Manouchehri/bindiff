package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true
)
final class ByFunctionOrdering extends Ordering implements Serializable {
   final Function function;
   final Ordering ordering;
   private static final long serialVersionUID = 0L;

   ByFunctionOrdering(Function var1, Ordering var2) {
      this.function = (Function)Preconditions.checkNotNull(var1);
      this.ordering = (Ordering)Preconditions.checkNotNull(var2);
   }

   public int compare(Object var1, Object var2) {
      return this.ordering.compare(this.function.apply(var1), this.function.apply(var2));
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ByFunctionOrdering)) {
         return false;
      } else {
         ByFunctionOrdering var2 = (ByFunctionOrdering)var1;
         return this.function.equals(var2.function) && this.ordering.equals(var2.ordering);
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.function, this.ordering});
   }

   public String toString() {
      String var1 = String.valueOf(this.ordering);
      String var2 = String.valueOf(this.function);
      return (new StringBuilder(13 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(".onResultOf(").append(var2).append(")").toString();
   }
}
