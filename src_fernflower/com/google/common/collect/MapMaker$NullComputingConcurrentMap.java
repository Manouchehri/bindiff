package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComputationException;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMaker$NullConcurrentMap;

final class MapMaker$NullComputingConcurrentMap extends MapMaker$NullConcurrentMap {
   private static final long serialVersionUID = 0L;
   final Function computingFunction;

   MapMaker$NullComputingConcurrentMap(MapMaker var1, Function var2) {
      super(var1);
      this.computingFunction = (Function)Preconditions.checkNotNull(var2);
   }

   public Object get(Object var1) {
      Object var3 = this.compute(var1);
      Preconditions.checkNotNull(var3, "%s returned null for key %s.", new Object[]{this.computingFunction, var1});
      this.notifyRemoval(var1, var3);
      return var3;
   }

   private Object compute(Object var1) {
      Preconditions.checkNotNull(var1);

      try {
         return this.computingFunction.apply(var1);
      } catch (ComputationException var3) {
         throw var3;
      } catch (Throwable var4) {
         throw new ComputationException(var4);
      }
   }
}
