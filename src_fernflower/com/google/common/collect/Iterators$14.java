package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Enumeration;

final class Iterators$14 extends UnmodifiableIterator {
   // $FF: synthetic field
   final Enumeration val$enumeration;

   Iterators$14(Enumeration var1) {
      this.val$enumeration = var1;
   }

   public boolean hasNext() {
      return this.val$enumeration.hasMoreElements();
   }

   public Object next() {
      return this.val$enumeration.nextElement();
   }
}
