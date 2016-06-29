package com.google.protobuf;

import com.google.protobuf.SmallSortedMap$1;
import com.google.protobuf.SmallSortedMap$EmptySet;
import com.google.protobuf.SmallSortedMap$Entry;
import com.google.protobuf.SmallSortedMap$EntrySet;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

class SmallSortedMap extends AbstractMap {
   private final int maxArraySize;
   private List entryList;
   private Map overflowEntries;
   private boolean isImmutable;
   private volatile SmallSortedMap$EntrySet lazyEntrySet;

   static SmallSortedMap newFieldMap(int var0) {
      return new SmallSortedMap$1(var0);
   }

   static SmallSortedMap newInstanceForTest(int var0) {
      return new SmallSortedMap(var0);
   }

   private SmallSortedMap(int var1) {
      this.maxArraySize = var1;
      this.entryList = Collections.emptyList();
      this.overflowEntries = Collections.emptyMap();
   }

   public void makeImmutable() {
      if(!this.isImmutable) {
         this.overflowEntries = this.overflowEntries.isEmpty()?Collections.emptyMap():Collections.unmodifiableMap(this.overflowEntries);
         this.isImmutable = true;
      }

   }

   public boolean isImmutable() {
      return this.isImmutable;
   }

   public int getNumArrayEntries() {
      return this.entryList.size();
   }

   public Entry getArrayEntryAt(int var1) {
      return (Entry)this.entryList.get(var1);
   }

   public int getNumOverflowEntries() {
      return this.overflowEntries.size();
   }

   public Iterable getOverflowEntries() {
      return (Iterable)(this.overflowEntries.isEmpty()?SmallSortedMap$EmptySet.iterable():this.overflowEntries.entrySet());
   }

   public int size() {
      return this.entryList.size() + this.overflowEntries.size();
   }

   public boolean containsKey(Object var1) {
      Comparable var2 = (Comparable)var1;
      return this.binarySearchInArray(var2) >= 0 || this.overflowEntries.containsKey(var2);
   }

   public Object get(Object var1) {
      Comparable var2 = (Comparable)var1;
      int var3 = this.binarySearchInArray(var2);
      return var3 >= 0?((SmallSortedMap$Entry)this.entryList.get(var3)).getValue():this.overflowEntries.get(var2);
   }

   public Object put(Comparable var1, Object var2) {
      this.checkMutable();
      int var3 = this.binarySearchInArray(var1);
      if(var3 >= 0) {
         return ((SmallSortedMap$Entry)this.entryList.get(var3)).setValue(var2);
      } else {
         this.ensureEntryArrayMutable();
         int var4 = -(var3 + 1);
         if(var4 >= this.maxArraySize) {
            return this.getOverflowEntriesMutable().put(var1, var2);
         } else {
            if(this.entryList.size() == this.maxArraySize) {
               SmallSortedMap$Entry var5 = (SmallSortedMap$Entry)this.entryList.remove(this.maxArraySize - 1);
               this.getOverflowEntriesMutable().put(var5.getKey(), var5.getValue());
            }

            this.entryList.add(var4, new SmallSortedMap$Entry(this, var1, var2));
            return null;
         }
      }
   }

   public void clear() {
      this.checkMutable();
      if(!this.entryList.isEmpty()) {
         this.entryList.clear();
      }

      if(!this.overflowEntries.isEmpty()) {
         this.overflowEntries.clear();
      }

   }

   public Object remove(Object var1) {
      this.checkMutable();
      Comparable var2 = (Comparable)var1;
      int var3 = this.binarySearchInArray(var2);
      return var3 >= 0?this.removeArrayEntryAt(var3):(this.overflowEntries.isEmpty()?null:this.overflowEntries.remove(var2));
   }

   private Object removeArrayEntryAt(int var1) {
      this.checkMutable();
      Object var2 = ((SmallSortedMap$Entry)this.entryList.remove(var1)).getValue();
      if(!this.overflowEntries.isEmpty()) {
         Iterator var3 = this.getOverflowEntriesMutable().entrySet().iterator();
         this.entryList.add(new SmallSortedMap$Entry(this, (Entry)var3.next()));
         var3.remove();
      }

      return var2;
   }

   private int binarySearchInArray(Comparable var1) {
      int var2 = 0;
      int var3 = this.entryList.size() - 1;
      int var4;
      if(var3 >= 0) {
         var4 = var1.compareTo(((SmallSortedMap$Entry)this.entryList.get(var3)).getKey());
         if(var4 > 0) {
            return -(var3 + 2);
         }

         if(var4 == 0) {
            return var3;
         }
      }

      while(var2 <= var3) {
         var4 = (var2 + var3) / 2;
         int var5 = var1.compareTo(((SmallSortedMap$Entry)this.entryList.get(var4)).getKey());
         if(var5 < 0) {
            var3 = var4 - 1;
         } else {
            if(var5 <= 0) {
               return var4;
            }

            var2 = var4 + 1;
         }
      }

      return -(var2 + 1);
   }

   public Set entrySet() {
      if(this.lazyEntrySet == null) {
         this.lazyEntrySet = new SmallSortedMap$EntrySet(this, (SmallSortedMap$1)null);
      }

      return this.lazyEntrySet;
   }

   private void checkMutable() {
      if(this.isImmutable) {
         throw new UnsupportedOperationException();
      }
   }

   private SortedMap getOverflowEntriesMutable() {
      this.checkMutable();
      if(this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof TreeMap)) {
         this.overflowEntries = new TreeMap();
      }

      return (SortedMap)this.overflowEntries;
   }

   private void ensureEntryArrayMutable() {
      this.checkMutable();
      if(this.entryList.isEmpty() && !(this.entryList instanceof ArrayList)) {
         this.entryList = new ArrayList(this.maxArraySize);
      }

   }

   // $FF: synthetic method
   SmallSortedMap(int var1, SmallSortedMap$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static void access$200(SmallSortedMap var0) {
      var0.checkMutable();
   }

   // $FF: synthetic method
   static List access$400(SmallSortedMap var0) {
      return var0.entryList;
   }

   // $FF: synthetic method
   static Object access$500(SmallSortedMap var0, int var1) {
      return var0.removeArrayEntryAt(var1);
   }

   // $FF: synthetic method
   static Map access$600(SmallSortedMap var0) {
      return var0.overflowEntries;
   }
}
