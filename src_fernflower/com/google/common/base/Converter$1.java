package com.google.common.base;

import com.google.common.base.Converter;
import com.google.common.base.Converter$1$1;
import java.util.Iterator;

class Converter$1 implements Iterable {
   // $FF: synthetic field
   final Iterable val$fromIterable;
   // $FF: synthetic field
   final Converter this$0;

   Converter$1(Converter var1, Iterable var2) {
      this.this$0 = var1;
      this.val$fromIterable = var2;
   }

   public Iterator iterator() {
      return new Converter$1$1(this);
   }
}
