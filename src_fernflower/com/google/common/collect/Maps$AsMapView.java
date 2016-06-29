package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$AsMapView$1EntrySetImpl;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class Maps$AsMapView extends Maps$ViewCachingAbstractMap {
   private final Set set;
   final Function function;

   Set backingSet() {
      return this.set;
   }

   Maps$AsMapView(Set var1, Function var2) {
      this.set = (Set)Preconditions.checkNotNull(var1);
      this.function = (Function)Preconditions.checkNotNull(var2);
   }

   public Set createKeySet() {
      return Maps.access$200(this.backingSet());
   }

   Collection createValues() {
      return Collections2.transform(this.set, this.function);
   }

   public int size() {
      return this.backingSet().size();
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.backingSet().contains(var1);
   }

   public Object get(@Nullable Object var1) {
      return Collections2.safeContains(this.backingSet(), var1)?this.function.apply(var1):null;
   }

   public Object remove(@Nullable Object var1) {
      return this.backingSet().remove(var1)?this.function.apply(var1):null;
   }

   public void clear() {
      this.backingSet().clear();
   }

   protected Set createEntrySet() {
      return new Maps$AsMapView$1EntrySetImpl(this);
   }
}
