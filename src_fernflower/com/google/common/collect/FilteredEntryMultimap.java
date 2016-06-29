package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.FilteredEntryMultimap$AsMap;
import com.google.common.collect.FilteredEntryMultimap$Keys;
import com.google.common.collect.FilteredEntryMultimap$ValuePredicate;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.FilteredMultimapValues;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
class FilteredEntryMultimap extends AbstractMultimap implements FilteredMultimap {
   final Multimap unfiltered;
   final Predicate predicate;

   FilteredEntryMultimap(Multimap var1, Predicate var2) {
      this.unfiltered = (Multimap)Preconditions.checkNotNull(var1);
      this.predicate = (Predicate)Preconditions.checkNotNull(var2);
   }

   public Multimap unfiltered() {
      return this.unfiltered;
   }

   public Predicate entryPredicate() {
      return this.predicate;
   }

   public int size() {
      return this.entries().size();
   }

   private boolean satisfies(Object var1, Object var2) {
      return this.predicate.apply(Maps.immutableEntry(var1, var2));
   }

   static Collection filterCollection(Collection var0, Predicate var1) {
      return (Collection)(var0 instanceof Set?Sets.filter((Set)var0, var1):Collections2.filter(var0, var1));
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.asMap().get(var1) != null;
   }

   public Collection removeAll(@Nullable Object var1) {
      return (Collection)MoreObjects.firstNonNull(this.asMap().remove(var1), this.unmodifiableEmptyCollection());
   }

   Collection unmodifiableEmptyCollection() {
      return (Collection)(this.unfiltered instanceof SetMultimap?Collections.emptySet():Collections.emptyList());
   }

   public void clear() {
      this.entries().clear();
   }

   public Collection get(Object var1) {
      return filterCollection(this.unfiltered.get(var1), new FilteredEntryMultimap$ValuePredicate(this, var1));
   }

   Collection createEntries() {
      return filterCollection(this.unfiltered.entries(), this.predicate);
   }

   Collection createValues() {
      return new FilteredMultimapValues(this);
   }

   Iterator entryIterator() {
      throw new AssertionError("should never be called");
   }

   Map createAsMap() {
      return new FilteredEntryMultimap$AsMap(this);
   }

   public Set keySet() {
      return this.asMap().keySet();
   }

   boolean removeEntriesIf(Predicate var1) {
      Iterator var2 = this.unfiltered.asMap().entrySet().iterator();
      boolean var3 = false;

      while(var2.hasNext()) {
         Entry var4 = (Entry)var2.next();
         Object var5 = var4.getKey();
         Collection var6 = filterCollection((Collection)var4.getValue(), new FilteredEntryMultimap$ValuePredicate(this, var5));
         if(!var6.isEmpty() && var1.apply(Maps.immutableEntry(var5, var6))) {
            if(var6.size() == ((Collection)var4.getValue()).size()) {
               var2.remove();
            } else {
               var6.clear();
            }

            var3 = true;
         }
      }

      return var3;
   }

   Multiset createKeys() {
      return new FilteredEntryMultimap$Keys(this);
   }

   // $FF: synthetic method
   static boolean access$000(FilteredEntryMultimap var0, Object var1, Object var2) {
      return var0.satisfies(var1, var2);
   }
}
