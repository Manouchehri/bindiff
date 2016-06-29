package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ListMultimap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractListMultimap extends AbstractMapBasedMultimap implements ListMultimap {
   private static final long serialVersionUID = 6588350623831699109L;

   protected AbstractListMultimap(Map var1) {
      super(var1);
   }

   abstract List createCollection();

   List createUnmodifiableEmptyCollection() {
      return ImmutableList.of();
   }

   public List get(@Nullable Object var1) {
      return (List)super.get(var1);
   }

   public List removeAll(@Nullable Object var1) {
      return (List)super.removeAll(var1);
   }

   public List replaceValues(@Nullable Object var1, Iterable var2) {
      return (List)super.replaceValues(var1, var2);
   }

   public boolean put(@Nullable Object var1, @Nullable Object var2) {
      return super.put(var1, var2);
   }

   public Map asMap() {
      return super.asMap();
   }

   public boolean equals(@Nullable Object var1) {
      return super.equals(var1);
   }
}
