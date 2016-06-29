package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.cache.LocalCache$LoadingValueReference;

class LocalCache$LoadingValueReference$1 implements Function {
   // $FF: synthetic field
   final LocalCache$LoadingValueReference this$0;

   LocalCache$LoadingValueReference$1(LocalCache$LoadingValueReference var1) {
      this.this$0 = var1;
   }

   public Object apply(Object var1) {
      this.this$0.set(var1);
      return var1;
   }
}
