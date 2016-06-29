package com.google.common.cache;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.CheckReturnValue;

class ShimAsyncCache$PersistentQueue {
   final ImmutableList futures;

   ShimAsyncCache$PersistentQueue(ImmutableList var1) {
      this.futures = var1;
   }

   @CheckReturnValue
   ShimAsyncCache$PersistentQueue add(ListenableFuture var1) {
      return new ShimAsyncCache$PersistentQueue(ImmutableList.builder().add((Object)var1).addAll((Iterable)this.futures).build());
   }

   @CheckReturnValue
   ShimAsyncCache$PersistentQueue retainNewer(ListenableFuture var1) {
      ImmutableList$Builder var2 = ImmutableList.builder();
      UnmodifiableIterator var3 = this.futures.iterator();

      while(var3.hasNext()) {
         ListenableFuture var4 = (ListenableFuture)var3.next();
         if(var4 == var1) {
            return new ShimAsyncCache$PersistentQueue(var2.build());
         }

         var2.add((Object)var4);
      }

      return this;
   }

   @CheckReturnValue
   ShimAsyncCache$PersistentQueue remove(ListenableFuture var1) {
      ImmutableList$Builder var2 = ImmutableList.builder();
      UnmodifiableIterator var3 = this.futures.iterator();

      while(var3.hasNext()) {
         ListenableFuture var4 = (ListenableFuture)var3.next();
         if(!var4.equals(var1)) {
            var2.add((Object)var4);
         }
      }

      return new ShimAsyncCache$PersistentQueue(var2.build());
   }

   int size() {
      return this.futures.size();
   }

   static ShimAsyncCache$PersistentQueue empty() {
      return new ShimAsyncCache$PersistentQueue(ImmutableList.of());
   }
}
