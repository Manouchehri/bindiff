package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;

final class Iterables$9 extends FluentIterable {
   // $FF: synthetic field
   final Iterable val$fromIterable;
   // $FF: synthetic field
   final Function val$function;

   Iterables$9(Iterable var1, Function var2) {
      this.val$fromIterable = var1;
      this.val$function = var2;
   }

   public Iterator iterator() {
      return Iterators.transform(this.val$fromIterable.iterator(), this.val$function);
   }
}
