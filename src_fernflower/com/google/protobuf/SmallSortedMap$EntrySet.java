package com.google.protobuf;

import com.google.protobuf.SmallSortedMap;
import com.google.protobuf.SmallSortedMap$1;
import com.google.protobuf.SmallSortedMap$EntryIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class SmallSortedMap$EntrySet extends AbstractSet {
   // $FF: synthetic field
   final SmallSortedMap this$0;

   private SmallSortedMap$EntrySet(SmallSortedMap var1) {
      this.this$0 = var1;
   }

   public Iterator iterator() {
      return new SmallSortedMap$EntryIterator(this.this$0, (SmallSortedMap$1)null);
   }

   public int size() {
      return this.this$0.size();
   }

   public boolean contains(Object var1) {
      Entry var2 = (Entry)var1;
      Object var3 = this.this$0.get(var2.getKey());
      Object var4 = var2.getValue();
      return var3 == var4 || var3 != null && var3.equals(var4);
   }

   public boolean add(Entry var1) {
      if(!this.contains(var1)) {
         this.this$0.put((Comparable)var1.getKey(), var1.getValue());
         return true;
      } else {
         return false;
      }
   }

   public boolean remove(Object var1) {
      Entry var2 = (Entry)var1;
      if(this.contains(var2)) {
         this.this$0.remove(var2.getKey());
         return true;
      } else {
         return false;
      }
   }

   public void clear() {
      this.this$0.clear();
   }

   // $FF: synthetic method
   SmallSortedMap$EntrySet(SmallSortedMap var1, SmallSortedMap$1 var2) {
      this(var1);
   }
}
