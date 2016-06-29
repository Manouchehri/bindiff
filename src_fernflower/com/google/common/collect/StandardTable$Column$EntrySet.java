package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$Column;
import com.google.common.collect.StandardTable$Column$EntrySetIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$Column$EntrySet extends Sets$ImprovedAbstractSet {
   // $FF: synthetic field
   final StandardTable$Column this$1;

   private StandardTable$Column$EntrySet(StandardTable$Column var1) {
      this.this$1 = var1;
   }

   public Iterator iterator() {
      return new StandardTable$Column$EntrySetIterator(this.this$1, (StandardTable$1)null);
   }

   public int size() {
      int var1 = 0;
      Iterator var2 = this.this$1.this$0.backingMap.values().iterator();

      while(var2.hasNext()) {
         Map var3 = (Map)var2.next();
         if(var3.containsKey(this.this$1.columnKey)) {
            ++var1;
         }
      }

      return var1;
   }

   public boolean isEmpty() {
      return !this.this$1.this$0.containsColumn(this.this$1.columnKey);
   }

   public void clear() {
      this.this$1.removeFromColumnIf(Predicates.alwaysTrue());
   }

   public boolean contains(Object var1) {
      if(var1 instanceof Entry) {
         Entry var2 = (Entry)var1;
         return StandardTable.access$300(this.this$1.this$0, var2.getKey(), this.this$1.columnKey, var2.getValue());
      } else {
         return false;
      }
   }

   public boolean remove(Object var1) {
      if(var1 instanceof Entry) {
         Entry var2 = (Entry)var1;
         return StandardTable.access$400(this.this$1.this$0, var2.getKey(), this.this$1.columnKey, var2.getValue());
      } else {
         return false;
      }
   }

   public boolean retainAll(Collection var1) {
      return this.this$1.removeFromColumnIf(Predicates.not(Predicates.in(var1)));
   }

   // $FF: synthetic method
   StandardTable$Column$EntrySet(StandardTable$Column var1, StandardTable$1 var2) {
      this(var1);
   }
}
