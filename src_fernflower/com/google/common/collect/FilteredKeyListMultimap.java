package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.ListMultimap;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
final class FilteredKeyListMultimap extends FilteredKeyMultimap implements ListMultimap {
   FilteredKeyListMultimap(ListMultimap var1, Predicate var2) {
      super(var1, var2);
   }

   public ListMultimap unfiltered() {
      return (ListMultimap)super.unfiltered();
   }

   public List get(Object var1) {
      return (List)super.get(var1);
   }

   public List removeAll(@Nullable Object var1) {
      return (List)super.removeAll(var1);
   }

   public List replaceValues(Object var1, Iterable var2) {
      return (List)super.replaceValues(var1, var2);
   }
}
