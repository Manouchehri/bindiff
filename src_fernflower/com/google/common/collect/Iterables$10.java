package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import java.util.Iterator;
import java.util.List;

final class Iterables$10 extends FluentIterable {
   // $FF: synthetic field
   final List val$list;
   // $FF: synthetic field
   final int val$numberToSkip;

   Iterables$10(List var1, int var2) {
      this.val$list = var1;
      this.val$numberToSkip = var2;
   }

   public Iterator iterator() {
      int var1 = Math.min(this.val$list.size(), this.val$numberToSkip);
      return this.val$list.subList(var1, this.val$list.size()).iterator();
   }
}
