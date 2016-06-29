package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Multimaps$TransformedEntriesMultimap;
import java.util.Collection;
import java.util.List;

final class Multimaps$TransformedEntriesListMultimap extends Multimaps$TransformedEntriesMultimap implements ListMultimap {
   Multimaps$TransformedEntriesListMultimap(ListMultimap var1, Maps$EntryTransformer var2) {
      super(var1, var2);
   }

   List transform(Object var1, Collection var2) {
      return Lists.transform((List)var2, Maps.asValueToValueFunction(this.transformer, var1));
   }

   public List get(Object var1) {
      return this.transform(var1, this.fromMultimap.get(var1));
   }

   public List removeAll(Object var1) {
      return this.transform(var1, this.fromMultimap.removeAll(var1));
   }

   public List replaceValues(Object var1, Iterable var2) {
      throw new UnsupportedOperationException();
   }
}
