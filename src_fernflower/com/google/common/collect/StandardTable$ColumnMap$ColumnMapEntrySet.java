package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$ColumnMap;
import com.google.common.collect.StandardTable$ColumnMap$ColumnMapEntrySet$1;
import com.google.common.collect.StandardTable$TableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class StandardTable$ColumnMap$ColumnMapEntrySet extends StandardTable$TableSet {
   // $FF: synthetic field
   final StandardTable$ColumnMap this$1;

   StandardTable$ColumnMap$ColumnMapEntrySet(StandardTable$ColumnMap var1) {
      super(var1.this$0, (StandardTable$1)null);
      this.this$1 = var1;
   }

   public Iterator iterator() {
      return Maps.asMapEntryIterator(this.this$1.this$0.columnKeySet(), new StandardTable$ColumnMap$ColumnMapEntrySet$1(this));
   }

   public int size() {
      return this.this$1.this$0.columnKeySet().size();
   }

   public boolean contains(Object var1) {
      if(var1 instanceof Entry) {
         Entry var2 = (Entry)var1;
         if(this.this$1.this$0.containsColumn(var2.getKey())) {
            Object var3 = var2.getKey();
            return this.this$1.get(var3).equals(var2.getValue());
         }
      }

      return false;
   }

   public boolean remove(Object var1) {
      if(this.contains(var1)) {
         Entry var2 = (Entry)var1;
         StandardTable.access$900(this.this$1.this$0, var2.getKey());
         return true;
      } else {
         return false;
      }
   }

   public boolean removeAll(Collection var1) {
      Preconditions.checkNotNull(var1);
      return Sets.removeAllImpl(this, (Iterator)var1.iterator());
   }

   public boolean retainAll(Collection var1) {
      Preconditions.checkNotNull(var1);
      boolean var2 = false;
      Iterator var3 = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         if(!var1.contains(Maps.immutableEntry(var4, this.this$1.this$0.column(var4)))) {
            StandardTable.access$900(this.this$1.this$0, var4);
            var2 = true;
         }
      }

      return var2;
   }
}
