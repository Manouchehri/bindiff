package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map.Entry;

final class Maps$1 extends TransformedIterator {
   // $FF: synthetic field
   final Function val$function;

   Maps$1(Iterator var1, Function var2) {
      super(var1);
      this.val$function = var2;
   }

   Entry transform(Object var1) {
      return Maps.immutableEntry(var1, this.val$function.apply(var1));
   }
}
