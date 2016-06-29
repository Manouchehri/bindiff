package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$TableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class StandardTable$ColumnKeySet extends StandardTable$TableSet {
   // $FF: synthetic field
   final StandardTable this$0;

   private StandardTable$ColumnKeySet(StandardTable var1) {
      super(var1, (StandardTable$1)null);
      this.this$0 = var1;
   }

   public Iterator iterator() {
      return this.this$0.createColumnKeyIterator();
   }

   public int size() {
      return Iterators.size(this.iterator());
   }

   public boolean remove(Object var1) {
      if(var1 == null) {
         return false;
      } else {
         boolean var2 = false;
         Iterator var3 = this.this$0.backingMap.values().iterator();

         while(var3.hasNext()) {
            Map var4 = (Map)var3.next();
            if(var4.keySet().remove(var1)) {
               var2 = true;
               if(var4.isEmpty()) {
                  var3.remove();
               }
            }
         }

         return var2;
      }
   }

   public boolean removeAll(Collection var1) {
      Preconditions.checkNotNull(var1);
      boolean var2 = false;
      Iterator var3 = this.this$0.backingMap.values().iterator();

      while(var3.hasNext()) {
         Map var4 = (Map)var3.next();
         if(Iterators.removeAll(var4.keySet().iterator(), var1)) {
            var2 = true;
            if(var4.isEmpty()) {
               var3.remove();
            }
         }
      }

      return var2;
   }

   public boolean retainAll(Collection var1) {
      Preconditions.checkNotNull(var1);
      boolean var2 = false;
      Iterator var3 = this.this$0.backingMap.values().iterator();

      while(var3.hasNext()) {
         Map var4 = (Map)var3.next();
         if(var4.keySet().retainAll(var1)) {
            var2 = true;
            if(var4.isEmpty()) {
               var3.remove();
            }
         }
      }

      return var2;
   }

   public boolean contains(Object var1) {
      return this.this$0.containsColumn(var1);
   }

   // $FF: synthetic method
   StandardTable$ColumnKeySet(StandardTable var1, StandardTable$1 var2) {
      this(var1);
   }
}
