package com.google.common.util.concurrent;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.CollectionFuture$CollectionFutureRunningState;
import com.google.common.util.concurrent.Futures$ListFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class Futures$ListFuture$ListFutureRunningState extends CollectionFuture$CollectionFutureRunningState {
   // $FF: synthetic field
   final Futures$ListFuture this$0;

   Futures$ListFuture$ListFutureRunningState(Futures$ListFuture var1, ImmutableCollection var2, boolean var3) {
      super(var1, var2, var3);
      this.this$0 = var1;
   }

   public List combine(List var1) {
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Optional var4 = (Optional)var3.next();
         var2.add(var4 != null?var4.orNull():null);
      }

      return Collections.unmodifiableList(var2);
   }
}
