package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Interner;

class Interners$InternerFunction implements Function {
   private final Interner interner;

   public Interners$InternerFunction(Interner var1) {
      this.interner = var1;
   }

   public Object apply(Object var1) {
      return this.interner.intern(var1);
   }

   public int hashCode() {
      return this.interner.hashCode();
   }

   public boolean equals(Object var1) {
      if(var1 instanceof Interners$InternerFunction) {
         Interners$InternerFunction var2 = (Interners$InternerFunction)var1;
         return this.interner.equals(var2.interner);
      } else {
         return false;
      }
   }
}
