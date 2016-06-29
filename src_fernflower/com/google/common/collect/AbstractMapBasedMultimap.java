package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultimap$1;
import com.google.common.collect.AbstractMapBasedMultimap$2;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap;
import com.google.common.collect.AbstractMapBasedMultimap$KeySet;
import com.google.common.collect.AbstractMapBasedMultimap$RandomAccessWrappedList;
import com.google.common.collect.AbstractMapBasedMultimap$SortedAsMap;
import com.google.common.collect.AbstractMapBasedMultimap$SortedKeySet;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedList;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedSet;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedSortedSet;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
abstract class AbstractMapBasedMultimap extends AbstractMultimap implements Serializable {
   private transient Map map;
   private transient int totalSize;
   private static final long serialVersionUID = 2447537837011683357L;

   protected AbstractMapBasedMultimap(Map var1) {
      Preconditions.checkArgument(var1.isEmpty());
      this.map = var1;
   }

   final void setMap(Map var1) {
      this.map = var1;
      this.totalSize = 0;

      Collection var3;
      for(Iterator var2 = var1.values().iterator(); var2.hasNext(); this.totalSize += var3.size()) {
         var3 = (Collection)var2.next();
         Preconditions.checkArgument(!var3.isEmpty());
      }

   }

   Collection createUnmodifiableEmptyCollection() {
      return this.unmodifiableCollectionSubclass(this.createCollection());
   }

   abstract Collection createCollection();

   Collection createCollection(@Nullable Object var1) {
      return this.createCollection();
   }

   Map backingMap() {
      return this.map;
   }

   public int size() {
      return this.totalSize;
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.map.containsKey(var1);
   }

   public boolean put(@Nullable Object var1, @Nullable Object var2) {
      Collection var3 = (Collection)this.map.get(var1);
      if(var3 == null) {
         var3 = this.createCollection(var1);
         if(var3.add(var2)) {
            ++this.totalSize;
            this.map.put(var1, var3);
            return true;
         } else {
            throw new AssertionError("New Collection violated the Collection spec");
         }
      } else if(var3.add(var2)) {
         ++this.totalSize;
         return true;
      } else {
         return false;
      }
   }

   private Collection getOrCreateCollection(@Nullable Object var1) {
      Collection var2 = (Collection)this.map.get(var1);
      if(var2 == null) {
         var2 = this.createCollection(var1);
         this.map.put(var1, var2);
      }

      return var2;
   }

   public Collection replaceValues(@Nullable Object var1, Iterable var2) {
      Iterator var3 = var2.iterator();
      if(!var3.hasNext()) {
         return this.removeAll(var1);
      } else {
         Collection var4 = this.getOrCreateCollection(var1);
         Collection var5 = this.createCollection();
         var5.addAll(var4);
         this.totalSize -= var4.size();
         var4.clear();

         while(var3.hasNext()) {
            if(var4.add(var3.next())) {
               ++this.totalSize;
            }
         }

         return this.unmodifiableCollectionSubclass(var5);
      }
   }

   public Collection removeAll(@Nullable Object var1) {
      Collection var2 = (Collection)this.map.remove(var1);
      if(var2 == null) {
         return this.createUnmodifiableEmptyCollection();
      } else {
         Collection var3 = this.createCollection();
         var3.addAll(var2);
         this.totalSize -= var2.size();
         var2.clear();
         return this.unmodifiableCollectionSubclass(var3);
      }
   }

   Collection unmodifiableCollectionSubclass(Collection var1) {
      return (Collection)(var1 instanceof SortedSet?Collections.unmodifiableSortedSet((SortedSet)var1):(var1 instanceof Set?Collections.unmodifiableSet((Set)var1):(var1 instanceof List?Collections.unmodifiableList((List)var1):Collections.unmodifiableCollection(var1))));
   }

   public void clear() {
      Iterator var1 = this.map.values().iterator();

      while(var1.hasNext()) {
         Collection var2 = (Collection)var1.next();
         var2.clear();
      }

      this.map.clear();
      this.totalSize = 0;
   }

   public Collection get(@Nullable Object var1) {
      Collection var2 = (Collection)this.map.get(var1);
      if(var2 == null) {
         var2 = this.createCollection(var1);
      }

      return this.wrapCollection(var1, var2);
   }

   Collection wrapCollection(@Nullable Object var1, Collection var2) {
      return (Collection)(var2 instanceof SortedSet?new AbstractMapBasedMultimap$WrappedSortedSet(this, var1, (SortedSet)var2, (AbstractMapBasedMultimap$WrappedCollection)null):(var2 instanceof Set?new AbstractMapBasedMultimap$WrappedSet(this, var1, (Set)var2):(var2 instanceof List?this.wrapList(var1, (List)var2, (AbstractMapBasedMultimap$WrappedCollection)null):new AbstractMapBasedMultimap$WrappedCollection(this, var1, var2, (AbstractMapBasedMultimap$WrappedCollection)null))));
   }

   private List wrapList(@Nullable Object var1, List var2, @Nullable AbstractMapBasedMultimap$WrappedCollection var3) {
      return (List)(var2 instanceof RandomAccess?new AbstractMapBasedMultimap$RandomAccessWrappedList(this, var1, var2, var3):new AbstractMapBasedMultimap$WrappedList(this, var1, var2, var3));
   }

   private Iterator iteratorOrListIterator(Collection var1) {
      return (Iterator)(var1 instanceof List?((List)var1).listIterator():var1.iterator());
   }

   Set createKeySet() {
      return (Set)(this.map instanceof SortedMap?new AbstractMapBasedMultimap$SortedKeySet(this, (SortedMap)this.map):new AbstractMapBasedMultimap$KeySet(this, this.map));
   }

   private int removeValuesForKey(Object var1) {
      Collection var2 = (Collection)Maps.safeRemove(this.map, var1);
      int var3 = 0;
      if(var2 != null) {
         var3 = var2.size();
         var2.clear();
         this.totalSize -= var3;
      }

      return var3;
   }

   public Collection values() {
      return super.values();
   }

   Iterator valueIterator() {
      return new AbstractMapBasedMultimap$1(this);
   }

   public Collection entries() {
      return super.entries();
   }

   Iterator entryIterator() {
      return new AbstractMapBasedMultimap$2(this);
   }

   Map createAsMap() {
      return (Map)(this.map instanceof SortedMap?new AbstractMapBasedMultimap$SortedAsMap(this, (SortedMap)this.map):new AbstractMapBasedMultimap$AsMap(this, this.map));
   }

   // $FF: synthetic method
   static Map access$000(AbstractMapBasedMultimap var0) {
      return var0.map;
   }

   // $FF: synthetic method
   static Iterator access$100(AbstractMapBasedMultimap var0, Collection var1) {
      return var0.iteratorOrListIterator(var1);
   }

   // $FF: synthetic method
   static int access$210(AbstractMapBasedMultimap var0) {
      return var0.totalSize--;
   }

   // $FF: synthetic method
   static int access$208(AbstractMapBasedMultimap var0) {
      return var0.totalSize++;
   }

   // $FF: synthetic method
   static int access$200(AbstractMapBasedMultimap var0) {
      return var0.totalSize;
   }

   // $FF: synthetic method
   static int access$202(AbstractMapBasedMultimap var0, int var1) {
      return var0.totalSize = var1;
   }

   // $FF: synthetic method
   static List access$300(AbstractMapBasedMultimap var0, Object var1, List var2, AbstractMapBasedMultimap$WrappedCollection var3) {
      return var0.wrapList(var1, var2, var3);
   }

   // $FF: synthetic method
   static int access$400(AbstractMapBasedMultimap var0, Object var1) {
      return var0.removeValuesForKey(var1);
   }
}
