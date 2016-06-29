package com.google.common.collect;

import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1EntrySetImpl;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1KeySetImpl;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1ValuesImpl;
import com.google.common.collect.FilteredEntryMultimap$ValuePredicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

class FilteredEntryMultimap$AsMap extends Maps$ViewCachingAbstractMap {
   // $FF: synthetic field
   final FilteredEntryMultimap this$0;

   FilteredEntryMultimap$AsMap(FilteredEntryMultimap var1) {
      this.this$0 = var1;
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.get(var1) != null;
   }

   public void clear() {
      this.this$0.clear();
   }

   public Collection get(@Nullable Object var1) {
      Collection var2 = (Collection)this.this$0.unfiltered.asMap().get(var1);
      if(var2 == null) {
         return null;
      } else {
         var2 = FilteredEntryMultimap.filterCollection(var2, new FilteredEntryMultimap$ValuePredicate(this.this$0, var1));
         return var2.isEmpty()?null:var2;
      }
   }

   public Collection remove(@Nullable Object var1) {
      Collection var2 = (Collection)this.this$0.unfiltered.asMap().get(var1);
      if(var2 == null) {
         return null;
      } else {
         Object var3 = var1;
         ArrayList var4 = Lists.newArrayList();
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            Object var6 = var5.next();
            if(FilteredEntryMultimap.access$000(this.this$0, var3, var6)) {
               var5.remove();
               var4.add(var6);
            }
         }

         if(var4.isEmpty()) {
            return null;
         } else if(this.this$0.unfiltered instanceof SetMultimap) {
            return Collections.unmodifiableSet(Sets.newLinkedHashSet((Iterable)var4));
         } else {
            return Collections.unmodifiableList(var4);
         }
      }
   }

   Set createKeySet() {
      return new FilteredEntryMultimap$AsMap$1KeySetImpl(this);
   }

   Set createEntrySet() {
      return new FilteredEntryMultimap$AsMap$1EntrySetImpl(this);
   }

   Collection createValues() {
      return new FilteredEntryMultimap$AsMap$1ValuesImpl(this);
   }
}
