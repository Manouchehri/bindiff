package com.google.common.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ManualSerializationProxy;
import com.google.common.collect.ImmutableMap;
import java.io.ObjectInputStream;
import java.io.Serializable;

final class LocalCache$LoadingSerializationProxy extends LocalCache$ManualSerializationProxy implements LoadingCache, Serializable {
   private static final long serialVersionUID = 1L;
   transient LoadingCache autoDelegate;

   LocalCache$LoadingSerializationProxy(LocalCache var1) {
      super(var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      CacheBuilder var2 = this.recreateCacheBuilder();
      this.autoDelegate = var2.build(this.loader);
   }

   public Object get(Object var1) {
      return this.autoDelegate.get(var1);
   }

   public Object getUnchecked(Object var1) {
      return this.autoDelegate.getUnchecked(var1);
   }

   public ImmutableMap getAll(Iterable var1) {
      return this.autoDelegate.getAll(var1);
   }

   public final Object apply(Object var1) {
      return this.autoDelegate.apply(var1);
   }

   public void refresh(Object var1) {
      this.autoDelegate.refresh(var1);
   }

   private Object readResolve() {
      return this.autoDelegate;
   }
}
