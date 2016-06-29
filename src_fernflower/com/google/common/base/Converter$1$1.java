package com.google.common.base;

import com.google.common.base.Converter$1;
import java.util.Iterator;

class Converter$1$1 implements Iterator {
   private final Iterator fromIterator;
   // $FF: synthetic field
   final Converter$1 this$1;

   Converter$1$1(Converter$1 var1) {
      this.this$1 = var1;
      this.fromIterator = this.this$1.val$fromIterable.iterator();
   }

   public boolean hasNext() {
      return this.fromIterator.hasNext();
   }

   public Object next() {
      return this.this$1.this$0.convert(this.fromIterator.next());
   }

   public void remove() {
      this.fromIterator.remove();
   }
}
