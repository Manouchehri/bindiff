package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$Keys$1;
import com.google.common.collect.Multimaps$Keys;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

class FilteredEntryMultimap$Keys extends Multimaps$Keys {
   // $FF: synthetic field
   final FilteredEntryMultimap this$0;

   FilteredEntryMultimap$Keys(FilteredEntryMultimap var1) {
      super(var1);
      this.this$0 = var1;
   }

   public int remove(@Nullable Object var1, int var2) {
      CollectPreconditions.checkNonnegative(var2, "occurrences");
      if(var2 == 0) {
         return this.count(var1);
      } else {
         Collection var3 = (Collection)this.this$0.unfiltered.asMap().get(var1);
         if(var3 == null) {
            return 0;
         } else {
            Object var4 = var1;
            int var5 = 0;
            Iterator var6 = var3.iterator();

            while(var6.hasNext()) {
               Object var7 = var6.next();
               if(FilteredEntryMultimap.access$000(this.this$0, var4, var7)) {
                  ++var5;
                  if(var5 <= var2) {
                     var6.remove();
                  }
               }
            }

            return var5;
         }
      }
   }

   public Set entrySet() {
      return new FilteredEntryMultimap$Keys$1(this);
   }
}
