package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$Row$1;
import java.util.Iterator;
import java.util.Map;

class StandardTable$Row extends Maps$IteratorBasedAbstractMap {
   final Object rowKey;
   Map backingRowMap;
   // $FF: synthetic field
   final StandardTable this$0;

   StandardTable$Row(StandardTable var1, Object var2) {
      this.this$0 = var1;
      this.rowKey = Preconditions.checkNotNull(var2);
   }

   Map backingRowMap() {
      return this.backingRowMap != null && (!this.backingRowMap.isEmpty() || !this.this$0.backingMap.containsKey(this.rowKey))?this.backingRowMap:(this.backingRowMap = this.computeBackingRowMap());
   }

   Map computeBackingRowMap() {
      return (Map)this.this$0.backingMap.get(this.rowKey);
   }

   void maintainEmptyInvariant() {
      if(this.backingRowMap() != null && this.backingRowMap.isEmpty()) {
         this.this$0.backingMap.remove(this.rowKey);
         this.backingRowMap = null;
      }

   }

   public boolean containsKey(Object var1) {
      Map var2 = this.backingRowMap();
      return var1 != null && var2 != null && Maps.safeContainsKey(var2, var1);
   }

   public Object get(Object var1) {
      Map var2 = this.backingRowMap();
      return var1 != null && var2 != null?Maps.safeGet(var2, var1):null;
   }

   public Object put(Object var1, Object var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      return this.backingRowMap != null && !this.backingRowMap.isEmpty()?this.backingRowMap.put(var1, var2):this.this$0.put(this.rowKey, var1, var2);
   }

   public Object remove(Object var1) {
      Map var2 = this.backingRowMap();
      if(var2 == null) {
         return null;
      } else {
         Object var3 = Maps.safeRemove(var2, var1);
         this.maintainEmptyInvariant();
         return var3;
      }
   }

   public void clear() {
      Map var1 = this.backingRowMap();
      if(var1 != null) {
         var1.clear();
      }

      this.maintainEmptyInvariant();
   }

   public int size() {
      Map var1 = this.backingRowMap();
      return var1 == null?0:var1.size();
   }

   Iterator entryIterator() {
      Map var1 = this.backingRowMap();
      if(var1 == null) {
         return Iterators.emptyModifiableIterator();
      } else {
         Iterator var2 = var1.entrySet().iterator();
         return new StandardTable$Row$1(this, var2);
      }
   }
}
