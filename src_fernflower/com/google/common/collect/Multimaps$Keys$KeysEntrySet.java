package com.google.common.collect;

import com.google.common.collect.Multimaps$Keys;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets$EntrySet;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

class Multimaps$Keys$KeysEntrySet extends Multisets$EntrySet {
   // $FF: synthetic field
   final Multimaps$Keys this$0;

   Multimaps$Keys$KeysEntrySet(Multimaps$Keys var1) {
      this.this$0 = var1;
   }

   Multiset multiset() {
      return this.this$0;
   }

   public Iterator iterator() {
      return this.this$0.entryIterator();
   }

   public int size() {
      return this.this$0.distinctElements();
   }

   public boolean isEmpty() {
      return this.this$0.multimap.isEmpty();
   }

   public boolean contains(@Nullable Object var1) {
      if(!(var1 instanceof Multiset$Entry)) {
         return false;
      } else {
         Multiset$Entry var2 = (Multiset$Entry)var1;
         Collection var3 = (Collection)this.this$0.multimap.asMap().get(var2.getElement());
         return var3 != null && var3.size() == var2.getCount();
      }
   }

   public boolean remove(@Nullable Object var1) {
      if(var1 instanceof Multiset$Entry) {
         Multiset$Entry var2 = (Multiset$Entry)var1;
         Collection var3 = (Collection)this.this$0.multimap.asMap().get(var2.getElement());
         if(var3 != null && var3.size() == var2.getCount()) {
            var3.clear();
            return true;
         }
      }

      return false;
   }
}
