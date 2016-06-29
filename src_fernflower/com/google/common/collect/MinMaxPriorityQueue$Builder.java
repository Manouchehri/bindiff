package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.MinMaxPriorityQueue$1;
import com.google.common.collect.Ordering;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

@Beta
public final class MinMaxPriorityQueue$Builder {
   private static final int UNSET_EXPECTED_SIZE = -1;
   private final Comparator comparator;
   private int expectedSize;
   private int maximumSize;

   private MinMaxPriorityQueue$Builder(Comparator var1) {
      this.expectedSize = -1;
      this.maximumSize = Integer.MAX_VALUE;
      this.comparator = (Comparator)Preconditions.checkNotNull(var1);
   }

   public MinMaxPriorityQueue$Builder expectedSize(int var1) {
      Preconditions.checkArgument(var1 >= 0);
      this.expectedSize = var1;
      return this;
   }

   public MinMaxPriorityQueue$Builder maximumSize(int var1) {
      Preconditions.checkArgument(var1 > 0);
      this.maximumSize = var1;
      return this;
   }

   public MinMaxPriorityQueue create() {
      return this.create(Collections.emptySet());
   }

   public MinMaxPriorityQueue create(Iterable var1) {
      MinMaxPriorityQueue var2 = new MinMaxPriorityQueue(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, var1), (MinMaxPriorityQueue$1)null);
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         var2.offer(var4);
      }

      return var2;
   }

   private Ordering ordering() {
      return Ordering.from(this.comparator);
   }

   // $FF: synthetic method
   MinMaxPriorityQueue$Builder(Comparator var1, MinMaxPriorityQueue$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Ordering access$200(MinMaxPriorityQueue$Builder var0) {
      return var0.ordering();
   }

   // $FF: synthetic method
   static int access$300(MinMaxPriorityQueue$Builder var0) {
      return var0.maximumSize;
   }
}
