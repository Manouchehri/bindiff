package com.google.common.cache;

import com.google.common.cache.LongAddable;
import com.google.common.cache.LongAddables$1;
import java.util.concurrent.atomic.AtomicLong;

final class LongAddables$PureJavaLongAddable extends AtomicLong implements LongAddable {
   private LongAddables$PureJavaLongAddable() {
   }

   public void increment() {
      this.getAndIncrement();
   }

   public void add(long var1) {
      this.getAndAdd(var1);
   }

   public long sum() {
      return this.get();
   }

   // $FF: synthetic method
   LongAddables$PureJavaLongAddable(LongAddables$1 var1) {
      this();
   }
}
