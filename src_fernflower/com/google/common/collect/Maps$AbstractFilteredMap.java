package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$FilteredMapValues;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

abstract class Maps$AbstractFilteredMap extends Maps$ViewCachingAbstractMap {
   final Map unfiltered;
   final Predicate predicate;

   Maps$AbstractFilteredMap(Map var1, Predicate var2) {
      this.unfiltered = var1;
      this.predicate = var2;
   }

   boolean apply(@Nullable Object var1, @Nullable Object var2) {
      return this.predicate.apply(Maps.immutableEntry(var1, var2));
   }

   public Object put(Object var1, Object var2) {
      Preconditions.checkArgument(this.apply(var1, var2));
      return this.unfiltered.put(var1, var2);
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         Preconditions.checkArgument(this.apply(var3.getKey(), var3.getValue()));
      }

      this.unfiltered.putAll(var1);
   }

   public boolean containsKey(Object var1) {
      return this.unfiltered.containsKey(var1) && this.apply(var1, this.unfiltered.get(var1));
   }

   public Object get(Object var1) {
      Object var2 = this.unfiltered.get(var1);
      return var2 != null && this.apply(var1, var2)?var2:null;
   }

   public boolean isEmpty() {
      return this.entrySet().isEmpty();
   }

   public Object remove(Object var1) {
      return this.containsKey(var1)?this.unfiltered.remove(var1):null;
   }

   Collection createValues() {
      return new Maps$FilteredMapValues(this, this.unfiltered, this.predicate);
   }
}
