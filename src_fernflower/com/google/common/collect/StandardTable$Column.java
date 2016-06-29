package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$Column$EntrySet;
import com.google.common.collect.StandardTable$Column$KeySet;
import com.google.common.collect.StandardTable$Column$Values;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class StandardTable$Column extends Maps$ViewCachingAbstractMap {
   final Object columnKey;
   // $FF: synthetic field
   final StandardTable this$0;

   StandardTable$Column(StandardTable var1, Object var2) {
      this.this$0 = var1;
      this.columnKey = Preconditions.checkNotNull(var2);
   }

   public Object put(Object var1, Object var2) {
      return this.this$0.put(var1, this.columnKey, var2);
   }

   public Object get(Object var1) {
      return this.this$0.get(var1, this.columnKey);
   }

   public boolean containsKey(Object var1) {
      return this.this$0.contains(var1, this.columnKey);
   }

   public Object remove(Object var1) {
      return this.this$0.remove(var1, this.columnKey);
   }

   boolean removeFromColumnIf(Predicate var1) {
      boolean var2 = false;
      Iterator var3 = this.this$0.backingMap.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         Map var5 = (Map)var4.getValue();
         Object var6 = var5.get(this.columnKey);
         if(var6 != null && var1.apply(Maps.immutableEntry(var4.getKey(), var6))) {
            var5.remove(this.columnKey);
            var2 = true;
            if(var5.isEmpty()) {
               var3.remove();
            }
         }
      }

      return var2;
   }

   Set createEntrySet() {
      return new StandardTable$Column$EntrySet(this, (StandardTable$1)null);
   }

   Set createKeySet() {
      return new StandardTable$Column$KeySet(this);
   }

   Collection createValues() {
      return new StandardTable$Column$Values(this);
   }
}
