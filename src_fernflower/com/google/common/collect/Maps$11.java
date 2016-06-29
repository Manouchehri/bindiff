package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import java.util.Map.Entry;

final class Maps$11 implements Function {
   // $FF: synthetic field
   final Maps$EntryTransformer val$transformer;

   Maps$11(Maps$EntryTransformer var1) {
      this.val$transformer = var1;
   }

   public Entry apply(Entry var1) {
      return Maps.transformEntry(this.val$transformer, var1);
   }
}
