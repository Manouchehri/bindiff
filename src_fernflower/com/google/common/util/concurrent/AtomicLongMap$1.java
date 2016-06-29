package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.AtomicLongMap;
import java.util.concurrent.atomic.AtomicLong;

class AtomicLongMap$1 implements Function {
   // $FF: synthetic field
   final AtomicLongMap this$0;

   AtomicLongMap$1(AtomicLongMap var1) {
      this.this$0 = var1;
   }

   public Long apply(AtomicLong var1) {
      return Long.valueOf(var1.get());
   }
}
