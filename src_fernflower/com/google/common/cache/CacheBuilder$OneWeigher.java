package com.google.common.cache;

import com.google.common.cache.Weigher;

enum CacheBuilder$OneWeigher implements Weigher {
   INSTANCE;

   public int weigh(Object var1, Object var2) {
      return 1;
   }
}
