package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Receiver;
import java.util.Collection;
import javax.annotation.Nullable;

final class Receivers$CollectingReceiver implements Receiver {
   private final Collection collection;

   Receivers$CollectingReceiver(Collection var1) {
      this.collection = (Collection)Preconditions.checkNotNull(var1);
   }

   public void accept(@Nullable Object var1) {
      this.collection.add(var1);
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Receivers$CollectingReceiver) {
         Receivers$CollectingReceiver var2 = (Receivers$CollectingReceiver)var1;
         return this.collection == var2.collection;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return System.identityHashCode(this.collection);
   }
}
