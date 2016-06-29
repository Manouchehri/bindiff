package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps$EntryTransformer;

final class Maps$7 implements Maps$EntryTransformer {
   // $FF: synthetic field
   final Function val$function;

   Maps$7(Function var1) {
      this.val$function = var1;
   }

   public Object transformEntry(Object var1, Object var2) {
      return this.val$function.apply(var2);
   }
}
