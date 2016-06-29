package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.LinkedListMultimap$1;
import com.google.common.collect.LinkedListMultimap$1EntriesImpl;
import com.google.common.collect.LinkedListMultimap$1KeySetImpl;
import com.google.common.collect.LinkedListMultimap$1ValuesImpl;
import com.google.common.collect.LinkedListMultimap$KeyList;
import com.google.common.collect.LinkedListMultimap$Node;
import com.google.common.collect.LinkedListMultimap$ValueForKeyIterator;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$AsMap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public class LinkedListMultimap extends AbstractMultimap implements ListMultimap, Serializable {
   private transient LinkedListMultimap$Node head;
   private transient LinkedListMultimap$Node tail;
   private transient Map keyToKeyList;
   private transient int size;
   private transient int modCount;
   @GwtIncompatible("java serialization not supported")
   private static final long serialVersionUID = 0L;

   public static LinkedListMultimap create() {
      return new LinkedListMultimap();
   }

   public static LinkedListMultimap create(int var0) {
      return new LinkedListMultimap(var0);
   }

   public static LinkedListMultimap create(Multimap var0) {
      return new LinkedListMultimap(var0);
   }

   LinkedListMultimap() {
      this.keyToKeyList = Maps.newHashMap();
   }

   private LinkedListMultimap(int var1) {
      this.keyToKeyList = new HashMap(var1);
   }

   private LinkedListMultimap(Multimap var1) {
      this(var1.keySet().size());
      this.putAll(var1);
   }

   private LinkedListMultimap$Node addNode(@Nullable Object var1, @Nullable Object var2, @Nullable LinkedListMultimap$Node var3) {
      LinkedListMultimap$Node var4 = new LinkedListMultimap$Node(var1, var2);
      if(this.head == null) {
         this.head = this.tail = var4;
         this.keyToKeyList.put(var1, new LinkedListMultimap$KeyList(var4));
         ++this.modCount;
      } else {
         LinkedListMultimap$KeyList var5;
         if(var3 == null) {
            this.tail.next = var4;
            var4.previous = this.tail;
            this.tail = var4;
            var5 = (LinkedListMultimap$KeyList)this.keyToKeyList.get(var1);
            if(var5 == null) {
               this.keyToKeyList.put(var1, new LinkedListMultimap$KeyList(var4));
               ++this.modCount;
            } else {
               ++var5.count;
               LinkedListMultimap$Node var6 = var5.tail;
               var6.nextSibling = var4;
               var4.previousSibling = var6;
               var5.tail = var4;
            }
         } else {
            var5 = (LinkedListMultimap$KeyList)this.keyToKeyList.get(var1);
            ++var5.count;
            var4.previous = var3.previous;
            var4.previousSibling = var3.previousSibling;
            var4.next = var3;
            var4.nextSibling = var3;
            if(var3.previousSibling == null) {
               ((LinkedListMultimap$KeyList)this.keyToKeyList.get(var1)).head = var4;
            } else {
               var3.previousSibling.nextSibling = var4;
            }

            if(var3.previous == null) {
               this.head = var4;
            } else {
               var3.previous.next = var4;
            }

            var3.previous = var4;
            var3.previousSibling = var4;
         }
      }

      ++this.size;
      return var4;
   }

   private void removeNode(LinkedListMultimap$Node var1) {
      if(var1.previous != null) {
         var1.previous.next = var1.next;
      } else {
         this.head = var1.next;
      }

      if(var1.next != null) {
         var1.next.previous = var1.previous;
      } else {
         this.tail = var1.previous;
      }

      LinkedListMultimap$KeyList var2;
      if(var1.previousSibling == null && var1.nextSibling == null) {
         var2 = (LinkedListMultimap$KeyList)this.keyToKeyList.remove(var1.key);
         var2.count = 0;
         ++this.modCount;
      } else {
         var2 = (LinkedListMultimap$KeyList)this.keyToKeyList.get(var1.key);
         --var2.count;
         if(var1.previousSibling == null) {
            var2.head = var1.nextSibling;
         } else {
            var1.previousSibling.nextSibling = var1.nextSibling;
         }

         if(var1.nextSibling == null) {
            var2.tail = var1.previousSibling;
         } else {
            var1.nextSibling.previousSibling = var1.previousSibling;
         }
      }

      --this.size;
   }

   private void removeAllNodes(@Nullable Object var1) {
      Iterators.clear(new LinkedListMultimap$ValueForKeyIterator(this, var1));
   }

   private static void checkElement(@Nullable Object var0) {
      if(var0 == null) {
         throw new NoSuchElementException();
      }
   }

   public int size() {
      return this.size;
   }

   public boolean isEmpty() {
      return this.head == null;
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.keyToKeyList.containsKey(var1);
   }

   public boolean containsValue(@Nullable Object var1) {
      return this.values().contains(var1);
   }

   public boolean put(@Nullable Object var1, @Nullable Object var2) {
      this.addNode(var1, var2, (LinkedListMultimap$Node)null);
      return true;
   }

   public List replaceValues(@Nullable Object var1, Iterable var2) {
      List var3 = this.getCopy(var1);
      LinkedListMultimap$ValueForKeyIterator var4 = new LinkedListMultimap$ValueForKeyIterator(this, var1);
      Iterator var5 = var2.iterator();

      while(var4.hasNext() && var5.hasNext()) {
         var4.next();
         var4.set(var5.next());
      }

      while(var4.hasNext()) {
         var4.next();
         var4.remove();
      }

      while(var5.hasNext()) {
         var4.add(var5.next());
      }

      return var3;
   }

   private List getCopy(@Nullable Object var1) {
      return Collections.unmodifiableList(Lists.newArrayList((Iterator)(new LinkedListMultimap$ValueForKeyIterator(this, var1))));
   }

   public List removeAll(@Nullable Object var1) {
      List var2 = this.getCopy(var1);
      this.removeAllNodes(var1);
      return var2;
   }

   public void clear() {
      this.head = null;
      this.tail = null;
      this.keyToKeyList.clear();
      this.size = 0;
      ++this.modCount;
   }

   public List get(@Nullable Object var1) {
      return new LinkedListMultimap$1(this, var1);
   }

   Set createKeySet() {
      return new LinkedListMultimap$1KeySetImpl(this);
   }

   public List values() {
      return (List)super.values();
   }

   List createValues() {
      return new LinkedListMultimap$1ValuesImpl(this);
   }

   public List entries() {
      return (List)super.entries();
   }

   List createEntries() {
      return new LinkedListMultimap$1EntriesImpl(this);
   }

   Iterator entryIterator() {
      throw new AssertionError("should never be called");
   }

   Map createAsMap() {
      return new Multimaps$AsMap(this);
   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeInt(this.size());
      Iterator var2 = this.entries().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeObject(var3.getKey());
         var1.writeObject(var3.getValue());
      }

   }

   @GwtIncompatible("java.io.ObjectInputStream")
   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.keyToKeyList = Maps.newLinkedHashMap();
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         Object var4 = var1.readObject();
         Object var5 = var1.readObject();
         this.put(var4, var5);
      }

   }

   // $FF: synthetic method
   static int access$000(LinkedListMultimap var0) {
      return var0.modCount;
   }

   // $FF: synthetic method
   static LinkedListMultimap$Node access$100(LinkedListMultimap var0) {
      return var0.tail;
   }

   // $FF: synthetic method
   static LinkedListMultimap$Node access$200(LinkedListMultimap var0) {
      return var0.head;
   }

   // $FF: synthetic method
   static void access$300(Object var0) {
      checkElement(var0);
   }

   // $FF: synthetic method
   static void access$400(LinkedListMultimap var0, LinkedListMultimap$Node var1) {
      var0.removeNode(var1);
   }

   // $FF: synthetic method
   static void access$500(LinkedListMultimap var0, Object var1) {
      var0.removeAllNodes(var1);
   }

   // $FF: synthetic method
   static Map access$600(LinkedListMultimap var0) {
      return var0.keyToKeyList;
   }

   // $FF: synthetic method
   static LinkedListMultimap$Node access$700(LinkedListMultimap var0, Object var1, Object var2, LinkedListMultimap$Node var3) {
      return var0.addNode(var1, var2, var3);
   }

   // $FF: synthetic method
   static int access$900(LinkedListMultimap var0) {
      return var0.size;
   }
}
