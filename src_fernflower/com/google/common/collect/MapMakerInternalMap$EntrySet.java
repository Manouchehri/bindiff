package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$EntryIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class MapMakerInternalMap$EntrySet extends AbstractSet {
   // $FF: synthetic field
   final MapMakerInternalMap this$0;

   MapMakerInternalMap$EntrySet(MapMakerInternalMap var1) {
      this.this$0 = var1;
   }

   public Iterator iterator() {
      return new MapMakerInternalMap$EntryIterator(this.this$0);
   }

   public boolean contains(Object var1) {
      if(!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         Object var3 = var2.getKey();
         if(var3 == null) {
            return false;
         } else {
            Object var4 = this.this$0.get(var3);
            return var4 != null && this.this$0.valueEquivalence.equivalent(var2.getValue(), var4);
         }
      }
   }

   public boolean remove(Object var1) {
      if(!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         Object var3 = var2.getKey();
         return var3 != null && this.this$0.remove(var3, var2.getValue());
      }
   }

   public int size() {
      return this.this$0.size();
   }

   public boolean isEmpty() {
      return this.this$0.isEmpty();
   }

   public void clear() {
      this.this$0.clear();
   }
}
