package com.google.common.collect;

import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Multimaps$TransformedEntriesMultimap;
import java.util.Collection;

class Multimaps$TransformedEntriesMultimap$1 implements Maps$EntryTransformer {
   // $FF: synthetic field
   final Multimaps$TransformedEntriesMultimap this$0;

   Multimaps$TransformedEntriesMultimap$1(Multimaps$TransformedEntriesMultimap var1) {
      this.this$0 = var1;
   }

   public Collection transformEntry(Object var1, Collection var2) {
      return this.this$0.transform(var1, var2);
   }
}
