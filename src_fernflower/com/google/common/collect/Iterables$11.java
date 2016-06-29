package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables$11$1;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$11 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$iterable;
   // $FF: synthetic field
   final int val$numberToSkip;

   Iterables$11(Iterable var1, int var2) {
      this.val$iterable = var1;
      this.val$numberToSkip = var2;
   }

   public Iterator iterator() {
      Iterator var1 = this.val$iterable.iterator();
      Iterators.advance(var1, this.val$numberToSkip);
      return new Iterables$11$1(this, var1);
   }
}
