package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.collect.ComputationException;
import com.google.common.collect.ComputingConcurrentHashMap;
import com.google.common.collect.MapMaker;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;

final class MapMaker$ComputingMapAdapter extends ComputingConcurrentHashMap implements Serializable {
   private static final long serialVersionUID = 0L;

   MapMaker$ComputingMapAdapter(MapMaker var1, Function var2) {
      super(var1, var2);
   }

   public Object get(Object var1) {
      Object var2;
      try {
         var2 = this.getOrCompute(var1);
      } catch (ExecutionException var5) {
         Throwable var4 = var5.getCause();
         Throwables.propagateIfInstanceOf(var4, ComputationException.class);
         throw new ComputationException(var4);
      }

      if(var2 == null) {
         String var3 = String.valueOf(this.computingFunction);
         String var6 = String.valueOf(var1);
         throw new NullPointerException((new StringBuilder(24 + String.valueOf(var3).length() + String.valueOf(var6).length())).append(var3).append(" returned null for key ").append(var6).append(".").toString());
      } else {
         return var2;
      }
   }
}
