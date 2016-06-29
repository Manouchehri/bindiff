package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.ForwardingCollection;
import java.util.Collection;
import java.util.Map.Entry;
import javax.annotation.Nullable;

class FilteredKeyMultimap$Entries extends ForwardingCollection {
   // $FF: synthetic field
   final FilteredKeyMultimap this$0;

   FilteredKeyMultimap$Entries(FilteredKeyMultimap var1) {
      this.this$0 = var1;
   }

   protected Collection delegate() {
      return Collections2.filter(this.this$0.unfiltered.entries(), this.this$0.entryPredicate());
   }

   public boolean remove(@Nullable Object var1) {
      if(var1 instanceof Entry) {
         Entry var2 = (Entry)var1;
         if(this.this$0.unfiltered.containsKey(var2.getKey()) && this.this$0.keyPredicate.apply(var2.getKey())) {
            return this.this$0.unfiltered.remove(var2.getKey(), var2.getValue());
         }
      }

      return false;
   }
}
