package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingMap;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
public abstract class ForwardingConcurrentMap extends ForwardingMap implements ConcurrentMap {
   protected abstract ConcurrentMap delegate();

   public Object putIfAbsent(Object var1, Object var2) {
      return this.delegate().putIfAbsent(var1, var2);
   }

   public boolean remove(Object var1, Object var2) {
      return this.delegate().remove(var1, var2);
   }

   public Object replace(Object var1, Object var2) {
      return this.delegate().replace(var1, var2);
   }

   public boolean replace(Object var1, Object var2, Object var3) {
      return this.delegate().replace(var1, var2, var3);
   }
}
