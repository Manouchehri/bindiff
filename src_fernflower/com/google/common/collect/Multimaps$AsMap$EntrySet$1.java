package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps$AsMap;
import com.google.common.collect.Multimaps$AsMap$EntrySet;
import java.util.Collection;

class Multimaps$AsMap$EntrySet$1 implements Function {
   // $FF: synthetic field
   final Multimaps$AsMap$EntrySet this$1;

   Multimaps$AsMap$EntrySet$1(Multimaps$AsMap$EntrySet var1) {
      this.this$1 = var1;
   }

   public Collection apply(Object var1) {
      return Multimaps$AsMap.access$200(this.this$1.this$0).get(var1);
   }
}
