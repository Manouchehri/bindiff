package com.google.common.collect;

import com.google.common.collect.FilteredKeyMultimap$Entries;
import com.google.common.collect.FilteredKeySetMultimap;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;

class FilteredKeySetMultimap$EntrySet extends FilteredKeyMultimap$Entries implements Set {
   // $FF: synthetic field
   final FilteredKeySetMultimap this$0;

   FilteredKeySetMultimap$EntrySet(FilteredKeySetMultimap var1) {
      super(var1);
      this.this$0 = var1;
   }

   public int hashCode() {
      return Sets.hashCodeImpl(this);
   }

   public boolean equals(@Nullable Object var1) {
      return Sets.equalsImpl(this, var1);
   }
}
