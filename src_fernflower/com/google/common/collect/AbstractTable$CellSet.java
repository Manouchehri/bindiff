package com.google.common.collect;

import com.google.common.collect.AbstractTable;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.Table$Cell;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

class AbstractTable$CellSet extends AbstractSet {
   // $FF: synthetic field
   final AbstractTable this$0;

   AbstractTable$CellSet(AbstractTable var1) {
      this.this$0 = var1;
   }

   public boolean contains(Object var1) {
      if(!(var1 instanceof Table$Cell)) {
         return false;
      } else {
         Table$Cell var2 = (Table$Cell)var1;
         Map var3 = (Map)Maps.safeGet(this.this$0.rowMap(), var2.getRowKey());
         return var3 != null && Collections2.safeContains(var3.entrySet(), Maps.immutableEntry(var2.getColumnKey(), var2.getValue()));
      }
   }

   public boolean remove(@Nullable Object var1) {
      if(!(var1 instanceof Table$Cell)) {
         return false;
      } else {
         Table$Cell var2 = (Table$Cell)var1;
         Map var3 = (Map)Maps.safeGet(this.this$0.rowMap(), var2.getRowKey());
         return var3 != null && Collections2.safeRemove(var3.entrySet(), Maps.immutableEntry(var2.getColumnKey(), var2.getValue()));
      }
   }

   public void clear() {
      this.this$0.clear();
   }

   public Iterator iterator() {
      return this.this$0.cellIterator();
   }

   public int size() {
      return this.this$0.size();
   }
}
