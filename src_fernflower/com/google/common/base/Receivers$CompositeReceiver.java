package com.google.common.base;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Receiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

final class Receivers$CompositeReceiver implements Receiver {
   private final List receivers;

   Receivers$CompositeReceiver(Iterable var1) {
      this.receivers = copy(var1);
   }

   public void accept(@Nullable Object var1) {
      Iterator var2 = this.receivers.iterator();

      while(var2.hasNext()) {
         Receiver var3 = (Receiver)var2.next();
         var3.accept(var1);
      }

   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Receivers$CompositeReceiver) {
         Receivers$CompositeReceiver var2 = (Receivers$CompositeReceiver)var1;
         return this.receivers.equals(var2.receivers);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.receivers.hashCode();
   }

   public String toString() {
      String var1 = Joiner.on(", ").join((Iterable)this.receivers);
      return (new StringBuilder(19 + String.valueOf(var1).length())).append("Receivers.compose(").append(var1).append(")").toString();
   }

   private static List copy(Iterable var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         var1.add(Preconditions.checkNotNull(var3));
      }

      return var1;
   }
}
