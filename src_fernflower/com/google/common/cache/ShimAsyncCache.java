package com.google.common.cache;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.cache.AsyncCacheLoader;
import com.google.common.cache.AsyncLoadingCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.ShimAsyncCache$1;
import com.google.common.cache.ShimAsyncCache$2;
import com.google.common.cache.ShimAsyncCache$3;
import com.google.common.cache.ShimAsyncCache$4;
import com.google.common.cache.ShimAsyncCache$CacheHolder;
import com.google.common.cache.ShimAsyncCache$Entry;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GoogleInternal
@GwtIncompatible("Futures")
final class ShimAsyncCache implements AsyncLoadingCache {
   private final LoadingCache cache;
   private final ThreadLocal batch;
   private final AsyncCacheLoader loader;

   private ShimAsyncCache(LoadingCache var1, ThreadLocal var2, AsyncCacheLoader var3) {
      this.cache = var1;
      this.batch = var2;
      this.loader = var3;
   }

   public ListenableFuture get(Object var1) {
      return ((ShimAsyncCache$Entry)this.cache.getUnchecked(var1)).getOrLoadFuture();
   }

   public ImmutableMap getAll(Iterable var1) {
      Preconditions.checkState(this.batch.get() == null, "Cannot call getAll() recursively.");
      this.batch.set(new LinkedHashMap());
      LinkedHashMap var2 = new LinkedHashMap();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         ShimAsyncCache$Entry var5 = (ShimAsyncCache$Entry)this.cache.getUnchecked(var4);
         var2.put(var4, var5.getOrLoadFuture());
      }

      Map var11 = (Map)this.batch.get();
      this.batch.remove();
      if(!var11.isEmpty()) {
         ImmutableSet var12 = ImmutableSet.copyOf((Collection)var11.keySet());
         Map var13 = loadAllNullHostile(this.loader, var12);
         Iterator var6 = var13.entrySet().iterator();

         Entry var7;
         Object var8;
         while(var6.hasNext()) {
            var7 = (Entry)var6.next();
            var8 = var7.getKey();
            ListenableFuture var9 = (ListenableFuture)var7.getValue();
            SettableFuture var10 = (SettableFuture)var11.remove(var8);
            if(var10 != null) {
               var10.setFuture(var9);
               if(var9.isDone()) {
                  var2.put(var8, var9);
               }
            } else {
               this.makeEntry(var8).addFuture(var9);
            }
         }

         var6 = var11.entrySet().iterator();

         while(var6.hasNext()) {
            var7 = (Entry)var6.next();
            var8 = var7.getKey();
            SettableFuture var14 = (SettableFuture)var7.getValue();
            ListenableFuture var15 = loadNullHostile(this.loader, var8);
            var14.setFuture(var15);
            if(var15.isDone()) {
               var2.put(var8, var15);
            }
         }
      }

      return ImmutableMap.copyOf((Map)var2);
   }

   private static ListenableFuture loadNullHostile(AsyncCacheLoader var0, Object var1) {
      try {
         return nullHostileFuture(var0.load(var1));
      } catch (RuntimeException var3) {
         return Futures.immediateFailedFuture(var3);
      }
   }

   private static Map loadAllNullHostile(AsyncCacheLoader var0, Set var1) {
      try {
         return Maps.transformValues((Map)var0.loadAll(var1), new ShimAsyncCache$1());
      } catch (RuntimeException var3) {
         return Maps.toMap((Iterable)var1, new ShimAsyncCache$2(var3));
      }
   }

   private static ListenableFuture nullHostileFuture(ListenableFuture var0) {
      ListenableFuture var1 = Futures.transform(var0, (Function)(new ShimAsyncCache$3()));
      return var1;
   }

   private ShimAsyncCache$Entry makeEntry(Object var1) {
      ShimAsyncCache$Entry var2 = new ShimAsyncCache$Entry(this.cache, this.loader, this.batch, var1);
      ShimAsyncCache$Entry var3 = (ShimAsyncCache$Entry)this.cache.asMap().putIfAbsent(var1, var2);
      return var3 != null?var3:var2;
   }

   @Nullable
   public Object getIfPresent(Object var1) {
      ShimAsyncCache$Entry var2 = (ShimAsyncCache$Entry)this.cache.getIfPresent(var1);
      return var2 != null?var2.getIfPresent():null;
   }

   public void invalidateAll() {
      this.cache.invalidateAll();
   }

   public void invalidate(Object var1) {
      this.cache.invalidate(var1);
   }

   public void put(Object var1, Object var2) {
      Preconditions.checkNotNull(var2);
      ShimAsyncCache$Entry var3 = (ShimAsyncCache$Entry)this.cache.getIfPresent(var1);
      if(var3 == null) {
         var3 = this.makeEntry(var1);
      }

      var3.addFuture(Futures.immediateFuture(var2));
   }

   static ShimAsyncCache from(CacheBuilder var0, AsyncCacheLoader var1) {
      Preconditions.checkNotNull(var1);
      ThreadLocal var2 = new ThreadLocal();
      ShimAsyncCache$CacheHolder var3 = new ShimAsyncCache$CacheHolder((ShimAsyncCache$1)null);
      var3.cache = var0.build((CacheLoader)(new ShimAsyncCache$4(var3, var1, var2)));
      return new ShimAsyncCache(var3.cache, var2, var1);
   }

   // $FF: synthetic method
   static ListenableFuture access$000(AsyncCacheLoader var0, Object var1) {
      return loadNullHostile(var0, var1);
   }

   // $FF: synthetic method
   static ListenableFuture access$100(ListenableFuture var0) {
      return nullHostileFuture(var0);
   }
}
