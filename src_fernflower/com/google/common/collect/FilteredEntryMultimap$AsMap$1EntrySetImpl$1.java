package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1EntrySetImpl;
import com.google.common.collect.FilteredEntryMultimap$ValuePredicate;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class FilteredEntryMultimap$AsMap$1EntrySetImpl$1 extends AbstractIterator {
   final Iterator backingIterator;
   // $FF: synthetic field
   final FilteredEntryMultimap$AsMap$1EntrySetImpl this$2;

   FilteredEntryMultimap$AsMap$1EntrySetImpl$1(FilteredEntryMultimap$AsMap$1EntrySetImpl var1) {
      this.this$2 = var1;
      this.backingIterator = this.this$2.this$1.this$0.unfiltered.asMap().entrySet().iterator();
   }

   protected Entry computeNext() {
      while(true) {
         if(this.backingIterator.hasNext()) {
            Entry var1 = (Entry)this.backingIterator.next();
            Object var2 = var1.getKey();
            Collection var3 = FilteredEntryMultimap.filterCollection((Collection)var1.getValue(), new FilteredEntryMultimap$ValuePredicate(this.this$2.this$1.this$0, var2));
            if(var3.isEmpty()) {
               continue;
            }

            return Maps.immutableEntry(var2, var3);
         }

         return (Entry)this.endOfData();
      }
   }
}
