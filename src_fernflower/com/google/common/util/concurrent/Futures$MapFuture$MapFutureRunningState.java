package com.google.common.util.concurrent;

import com.google.common.base.Optional;
import com.google.common.base.Pair;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.CollectionFuture$CollectionFutureRunningState;
import com.google.common.util.concurrent.Futures$MapFuture;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

final class Futures$MapFuture$MapFutureRunningState extends CollectionFuture$CollectionFutureRunningState {
   @Nullable
   ImmutableMap futures;
   // $FF: synthetic field
   final Futures$MapFuture this$0;

   Futures$MapFuture$MapFutureRunningState(Futures$MapFuture var1, ImmutableMap var2, boolean var3) {
      super(var1, var2.values(), var3);
      this.this$0 = var1;
      this.futures = var2;
   }

   public Map combine(List var1) {
      LinkedHashMap var2 = Maps.newLinkedHashMap();
      Iterator var3 = Iterables.pairUp(this.futures.keySet(), var1).iterator();

      while(var3.hasNext()) {
         Pair var4 = (Pair)var3.next();
         if(var4.second != null) {
            var2.put(var4.first, ((Optional)var4.second).orNull());
         }
      }

      return Collections.unmodifiableMap(var2);
   }

   void releaseResourcesAfterFailure() {
      super.releaseResourcesAfterFailure();
      this.futures = null;
   }
}
