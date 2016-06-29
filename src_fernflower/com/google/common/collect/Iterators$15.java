package com.google.common.collect;

import java.util.Enumeration;
import java.util.Iterator;

final class Iterators$15 implements Enumeration {
   // $FF: synthetic field
   final Iterator val$iterator;

   Iterators$15(Iterator var1) {
      this.val$iterator = var1;
   }

   public boolean hasMoreElements() {
      return this.val$iterator.hasNext();
   }

   public Object nextElement() {
      return this.val$iterator.next();
   }
}
