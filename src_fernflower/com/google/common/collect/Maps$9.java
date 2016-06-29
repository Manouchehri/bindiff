package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps$EntryTransformer;
import java.util.Map.Entry;

final class Maps$9 implements Function {
   // $FF: synthetic field
   final Maps$EntryTransformer val$transformer;

   Maps$9(Maps$EntryTransformer var1) {
      this.val$transformer = var1;
   }

   public Object apply(Entry var1) {
      return this.val$transformer.transformEntry(var1.getKey(), var1.getValue());
   }
}
