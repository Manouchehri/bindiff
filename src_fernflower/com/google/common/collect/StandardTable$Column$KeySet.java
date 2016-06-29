package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$KeySet;
import com.google.common.collect.StandardTable$Column;
import java.util.Collection;

class StandardTable$Column$KeySet extends Maps$KeySet {
   // $FF: synthetic field
   final StandardTable$Column this$1;

   StandardTable$Column$KeySet(StandardTable$Column var1) {
      super(var1);
      this.this$1 = var1;
   }

   public boolean contains(Object var1) {
      return this.this$1.this$0.contains(var1, this.this$1.columnKey);
   }

   public boolean remove(Object var1) {
      return this.this$1.this$0.remove(var1, this.this$1.columnKey) != null;
   }

   public boolean retainAll(Collection var1) {
      return this.this$1.removeFromColumnIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(var1))));
   }
}
