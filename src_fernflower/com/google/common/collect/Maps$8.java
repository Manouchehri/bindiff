package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps$EntryTransformer;
import javax.annotation.Nullable;

final class Maps$8 implements Function {
   // $FF: synthetic field
   final Maps$EntryTransformer val$transformer;
   // $FF: synthetic field
   final Object val$key;

   Maps$8(Maps$EntryTransformer var1, Object var2) {
      this.val$transformer = var1;
      this.val$key = var2;
   }

   public Object apply(@Nullable Object var1) {
      return this.val$transformer.transformEntry(this.val$key, var1);
   }
}
