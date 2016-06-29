package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.FilteredEntryMultimap;
import javax.annotation.Nullable;

final class FilteredEntryMultimap$ValuePredicate implements Predicate {
   private final Object key;
   // $FF: synthetic field
   final FilteredEntryMultimap this$0;

   FilteredEntryMultimap$ValuePredicate(FilteredEntryMultimap var1, Object var2) {
      this.this$0 = var1;
      this.key = var2;
   }

   public boolean apply(@Nullable Object var1) {
      return FilteredEntryMultimap.access$000(this.this$0, this.key, var1);
   }
}
