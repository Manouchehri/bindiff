package com.google.common.base;

import com.google.common.base.Optional$1$1;
import java.util.Iterator;

final class Optional$1 implements Iterable {
   // $FF: synthetic field
   final Iterable val$optionals;

   Optional$1(Iterable var1) {
      this.val$optionals = var1;
   }

   public Iterator iterator() {
      return new Optional$1$1(this);
   }
}
