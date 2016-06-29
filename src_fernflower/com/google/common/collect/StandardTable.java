package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.GwtTransient;
import com.google.common.collect.Maps;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$CellIterator;
import com.google.common.collect.StandardTable$Column;
import com.google.common.collect.StandardTable$ColumnKeyIterator;
import com.google.common.collect.StandardTable$ColumnKeySet;
import com.google.common.collect.StandardTable$ColumnMap;
import com.google.common.collect.StandardTable$Row;
import com.google.common.collect.StandardTable$RowMap;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
class StandardTable extends AbstractTable implements Serializable {
   @GwtTransient
   final Map backingMap;
   @GwtTransient
   final Supplier factory;
   private transient Set columnKeySet;
   private transient Map rowMap;
   private transient StandardTable$ColumnMap columnMap;
   private static final long serialVersionUID = 0L;

   StandardTable(Map var1, Supplier var2) {
      this.backingMap = var1;
      this.factory = var2;
   }

   public boolean contains(@Nullable Object var1, @Nullable Object var2) {
      return var1 != null && var2 != null && super.contains(var1, var2);
   }

   public boolean containsColumn(@Nullable Object var1) {
      if(var1 == null) {
         return false;
      } else {
         Iterator var2 = this.backingMap.values().iterator();

         Map var3;
         do {
            if(!var2.hasNext()) {
               return false;
            }

            var3 = (Map)var2.next();
         } while(!Maps.safeContainsKey(var3, var1));

         return true;
      }
   }

   public boolean containsRow(@Nullable Object var1) {
      return var1 != null && Maps.safeContainsKey(this.backingMap, var1);
   }

   public boolean containsValue(@Nullable Object var1) {
      return var1 != null && super.containsValue(var1);
   }

   public Object get(@Nullable Object var1, @Nullable Object var2) {
      return var1 != null && var2 != null?super.get(var1, var2):null;
   }

   public boolean isEmpty() {
      return this.backingMap.isEmpty();
   }

   public int size() {
      int var1 = 0;

      Map var3;
      for(Iterator var2 = this.backingMap.values().iterator(); var2.hasNext(); var1 += var3.size()) {
         var3 = (Map)var2.next();
      }

      return var1;
   }

   public void clear() {
      this.backingMap.clear();
   }

   private Map getOrCreate(Object var1) {
      Map var2 = (Map)this.backingMap.get(var1);
      if(var2 == null) {
         var2 = (Map)this.factory.get();
         this.backingMap.put(var1, var2);
      }

      return var2;
   }

   public Object put(Object var1, Object var2, Object var3) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var3);
      return this.getOrCreate(var1).put(var2, var3);
   }

   public Object remove(@Nullable Object var1, @Nullable Object var2) {
      if(var1 != null && var2 != null) {
         Map var3 = (Map)Maps.safeGet(this.backingMap, var1);
         if(var3 == null) {
            return null;
         } else {
            Object var4 = var3.remove(var2);
            if(var3.isEmpty()) {
               this.backingMap.remove(var1);
            }

            return var4;
         }
      } else {
         return null;
      }
   }

   private Map removeColumn(Object var1) {
      LinkedHashMap var2 = new LinkedHashMap();
      Iterator var3 = this.backingMap.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         Object var5 = ((Map)var4.getValue()).remove(var1);
         if(var5 != null) {
            var2.put(var4.getKey(), var5);
            if(((Map)var4.getValue()).isEmpty()) {
               var3.remove();
            }
         }
      }

      return var2;
   }

   private boolean containsMapping(Object var1, Object var2, Object var3) {
      return var3 != null && var3.equals(this.get(var1, var2));
   }

   private boolean removeMapping(Object var1, Object var2, Object var3) {
      if(this.containsMapping(var1, var2, var3)) {
         this.remove(var1, var2);
         return true;
      } else {
         return false;
      }
   }

   public Set cellSet() {
      return super.cellSet();
   }

   Iterator cellIterator() {
      return new StandardTable$CellIterator(this, (StandardTable$1)null);
   }

   public Map row(Object var1) {
      return new StandardTable$Row(this, var1);
   }

   public Map column(Object var1) {
      return new StandardTable$Column(this, var1);
   }

   public Set rowKeySet() {
      return this.rowMap().keySet();
   }

   public Set columnKeySet() {
      Set var1 = this.columnKeySet;
      return var1 == null?(this.columnKeySet = new StandardTable$ColumnKeySet(this, (StandardTable$1)null)):var1;
   }

   Iterator createColumnKeyIterator() {
      return new StandardTable$ColumnKeyIterator(this, (StandardTable$1)null);
   }

   public Collection values() {
      return super.values();
   }

   public Map rowMap() {
      Map var1 = this.rowMap;
      return var1 == null?(this.rowMap = this.createRowMap()):var1;
   }

   Map createRowMap() {
      return new StandardTable$RowMap(this);
   }

   public Map columnMap() {
      StandardTable$ColumnMap var1 = this.columnMap;
      return var1 == null?(this.columnMap = new StandardTable$ColumnMap(this, (StandardTable$1)null)):var1;
   }

   // $FF: synthetic method
   static boolean access$300(StandardTable var0, Object var1, Object var2, Object var3) {
      return var0.containsMapping(var1, var2, var3);
   }

   // $FF: synthetic method
   static boolean access$400(StandardTable var0, Object var1, Object var2, Object var3) {
      return var0.removeMapping(var1, var2, var3);
   }

   // $FF: synthetic method
   static Map access$900(StandardTable var0, Object var1) {
      return var0.removeColumn(var1);
   }
}
