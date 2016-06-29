package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;

final class Iterators$9 extends TransformedIterator {
   // $FF: synthetic field
   final Function val$function;

   Iterators$9(Iterator var1, Function var2) {
      super(var1);
      this.val$function = var2;
   }

   Object transform(Object var1) {
      return this.val$function.apply(var1);
   }
}
