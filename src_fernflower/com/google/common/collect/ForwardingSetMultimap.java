package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.SetMultimap;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSetMultimap extends ForwardingMultimap implements SetMultimap {
   protected abstract SetMultimap delegate();

   public Set entries() {
      return this.delegate().entries();
   }

   public Set get(@Nullable Object var1) {
      return this.delegate().get(var1);
   }

   public Set removeAll(@Nullable Object var1) {
      return this.delegate().removeAll(var1);
   }

   public Set replaceValues(Object var1, Iterable var2) {
      return this.delegate().replaceValues(var1, var2);
   }
}
