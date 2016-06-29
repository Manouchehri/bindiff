package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$ColumnMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$ColumnMap$ColumnMapValues extends Maps$Values {
   // $FF: synthetic field
   final StandardTable$ColumnMap this$1;

   StandardTable$ColumnMap$ColumnMapValues(StandardTable$ColumnMap var1) {
      super(var1);
      this.this$1 = var1;
   }

   public boolean remove(Object var1) {
      Iterator var2 = this.this$1.entrySet().iterator();

      Entry var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (Entry)var2.next();
      } while(!((Map)var3.getValue()).equals(var1));

      StandardTable.access$900(this.this$1.this$0, var3.getKey());
      return true;
   }

   public boolean removeAll(Collection var1) {
      Preconditions.checkNotNull(var1);
      boolean var2 = false;
      Iterator var3 = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         if(var1.contains(this.this$1.this$0.column(var4))) {
            StandardTable.access$900(this.this$1.this$0, var4);
            var2 = true;
         }
      }

      return var2;
   }

   public boolean retainAll(Collection var1) {
      Preconditions.checkNotNull(var1);
      boolean var2 = false;
      Iterator var3 = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         if(!var1.contains(this.this$1.this$0.column(var4))) {
            StandardTable.access$900(this.this$1.this$0, var4);
            var2 = true;
         }
      }

      return var2;
   }
}
