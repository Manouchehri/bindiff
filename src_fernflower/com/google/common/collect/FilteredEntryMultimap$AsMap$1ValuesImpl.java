package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$AsMap;
import com.google.common.collect.FilteredEntryMultimap$ValuePredicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$Values;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

class FilteredEntryMultimap$AsMap$1ValuesImpl extends Maps$Values {
   // $FF: synthetic field
   final FilteredEntryMultimap$AsMap this$1;

   FilteredEntryMultimap$AsMap$1ValuesImpl(FilteredEntryMultimap$AsMap var1) {
      super(var1);
      this.this$1 = var1;
   }

   public boolean remove(@Nullable Object var1) {
      if(var1 instanceof Collection) {
         Collection var2 = (Collection)var1;
         Iterator var3 = this.this$1.this$0.unfiltered.asMap().entrySet().iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            Object var5 = var4.getKey();
            Collection var6 = FilteredEntryMultimap.filterCollection((Collection)var4.getValue(), new FilteredEntryMultimap$ValuePredicate(this.this$1.this$0, var5));
            if(!var6.isEmpty() && var2.equals(var6)) {
               if(var6.size() == ((Collection)var4.getValue()).size()) {
                  var3.remove();
               } else {
                  var6.clear();
               }

               return true;
            }
         }
      }

      return false;
   }

   public boolean removeAll(Collection var1) {
      return this.this$1.this$0.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.in(var1)));
   }

   public boolean retainAll(Collection var1) {
      return this.this$1.this$0.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(var1))));
   }
}
