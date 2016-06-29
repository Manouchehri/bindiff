package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.cache.CacheLoader;
import java.io.Serializable;

final class CacheLoader$FunctionToCacheLoader extends CacheLoader implements Serializable {
   private final Function computingFunction;
   private static final long serialVersionUID = 0L;

   public CacheLoader$FunctionToCacheLoader(Function var1) {
      this.computingFunction = (Function)Preconditions.checkNotNull(var1);
   }

   public Object load(Object var1) {
      return this.computingFunction.apply(Preconditions.checkNotNull(var1));
   }
}
