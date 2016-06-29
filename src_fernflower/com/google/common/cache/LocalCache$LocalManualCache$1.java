package com.google.common.cache;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LocalCache$LocalManualCache;
import java.util.concurrent.Callable;

class LocalCache$LocalManualCache$1 extends CacheLoader {
   // $FF: synthetic field
   final Callable val$valueLoader;
   // $FF: synthetic field
   final LocalCache$LocalManualCache this$0;

   LocalCache$LocalManualCache$1(LocalCache$LocalManualCache var1, Callable var2) {
      this.this$0 = var1;
      this.val$valueLoader = var2;
   }

   public Object load(Object var1) {
      return this.val$valueLoader.call();
   }
}
