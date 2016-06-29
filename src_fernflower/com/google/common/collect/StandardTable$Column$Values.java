package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.StandardTable$Column;
import java.util.Collection;

class StandardTable$Column$Values extends Maps$Values {
   // $FF: synthetic field
   final StandardTable$Column this$1;

   StandardTable$Column$Values(StandardTable$Column var1) {
      super(var1);
      this.this$1 = var1;
   }

   public boolean remove(Object var1) {
      return var1 != null && this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.equalTo(var1)));
   }

   public boolean removeAll(Collection var1) {
      return this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.in(var1)));
   }

   public boolean retainAll(Collection var1) {
      return this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(var1))));
   }
}
