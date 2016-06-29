package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultimap$NavigableAsMap;
import com.google.common.collect.AbstractMapBasedMultimap$NavigableKeySet;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedNavigableSet;
import com.google.common.collect.AbstractSortedKeySortedSetMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import com.google.common.collect.Serialization;
import com.google.common.collect.Sets;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public class TreeMultimap extends AbstractSortedKeySortedSetMultimap {
   private transient Comparator keyComparator;
   private transient Comparator valueComparator;
   @GwtIncompatible("not needed in emulated source")
   private static final long serialVersionUID = 0L;

   public static TreeMultimap create() {
      return new TreeMultimap(Ordering.natural(), Ordering.natural());
   }

   public static TreeMultimap create(Comparator var0, Comparator var1) {
      return new TreeMultimap((Comparator)Preconditions.checkNotNull(var0), (Comparator)Preconditions.checkNotNull(var1));
   }

   public static TreeMultimap create(Multimap var0) {
      return new TreeMultimap(Ordering.natural(), Ordering.natural(), var0);
   }

   TreeMultimap(Comparator var1, Comparator var2) {
      super(new TreeMap(var1));
      this.keyComparator = var1;
      this.valueComparator = var2;
   }

   private TreeMultimap(Comparator var1, Comparator var2, Multimap var3) {
      this(var1, var2);
      this.putAll(var3);
   }

   SortedSet createCollection() {
      return new TreeSet(this.valueComparator);
   }

   Collection createCollection(@Nullable Object var1) {
      if(var1 == null) {
         this.keyComparator().compare(var1, var1);
      }

      return super.createCollection(var1);
   }

   public Comparator keyComparator() {
      return this.keyComparator;
   }

   public Comparator valueComparator() {
      return this.valueComparator;
   }

   @GwtIncompatible("NavigableMap")
   NavigableMap backingMap() {
      return (NavigableMap)super.backingMap();
   }

   @GwtIncompatible("NavigableSet")
   public NavigableSet get(@Nullable Object var1) {
      return (NavigableSet)super.get(var1);
   }

   @GwtIncompatible("NavigableSet")
   Collection unmodifiableCollectionSubclass(Collection var1) {
      return Sets.unmodifiableNavigableSet((NavigableSet)var1);
   }

   @GwtIncompatible("NavigableSet")
   Collection wrapCollection(Object var1, Collection var2) {
      return new AbstractMapBasedMultimap$WrappedNavigableSet(this, var1, (NavigableSet)var2, (AbstractMapBasedMultimap$WrappedCollection)null);
   }

   @GwtIncompatible("NavigableSet")
   public NavigableSet keySet() {
      return (NavigableSet)super.keySet();
   }

   @GwtIncompatible("NavigableSet")
   NavigableSet createKeySet() {
      return new AbstractMapBasedMultimap$NavigableKeySet(this, this.backingMap());
   }

   @GwtIncompatible("NavigableMap")
   public NavigableMap asMap() {
      return (NavigableMap)super.asMap();
   }

   @GwtIncompatible("NavigableMap")
   NavigableMap createAsMap() {
      return new AbstractMapBasedMultimap$NavigableAsMap(this, this.backingMap());
   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.keyComparator());
      var1.writeObject(this.valueComparator());
      Serialization.writeMultimap(this, var1);
   }

   @GwtIncompatible("java.io.ObjectInputStream")
   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.keyComparator = (Comparator)Preconditions.checkNotNull((Comparator)var1.readObject());
      this.valueComparator = (Comparator)Preconditions.checkNotNull((Comparator)var1.readObject());
      this.setMap(new TreeMap(this.keyComparator));
      Serialization.populateMultimap(this, var1);
   }
}
