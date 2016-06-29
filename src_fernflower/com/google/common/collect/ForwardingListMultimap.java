package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.ListMultimap;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingListMultimap extends ForwardingMultimap implements ListMultimap {
   protected abstract ListMultimap delegate();

   public List get(@Nullable Object var1) {
      return this.delegate().get(var1);
   }

   public List removeAll(@Nullable Object var1) {
      return this.delegate().removeAll(var1);
   }

   public List replaceValues(Object var1, Iterable var2) {
      return this.delegate().replaceValues(var1, var2);
   }
}
