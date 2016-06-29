package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multimaps$UnmodifiableMultimap;
import java.util.Collection;

class Multimaps$UnmodifiableMultimap$1 implements Function {
   // $FF: synthetic field
   final Multimaps$UnmodifiableMultimap this$0;

   Multimaps$UnmodifiableMultimap$1(Multimaps$UnmodifiableMultimap var1) {
      this.this$0 = var1;
   }

   public Collection apply(Collection var1) {
      return Multimaps.access$000(var1);
   }
}
