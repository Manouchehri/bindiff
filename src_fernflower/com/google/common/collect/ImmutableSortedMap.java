package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap$1EntrySet;
import com.google.common.collect.ImmutableSortedMap$Builder;
import com.google.common.collect.ImmutableSortedMap$SerializedForm;
import com.google.common.collect.ImmutableSortedMapFauxverideShim;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSortedSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public final class ImmutableSortedMap extends ImmutableSortedMapFauxverideShim implements NavigableMap {
   private static final Comparator NATURAL_ORDER = Ordering.natural();
   private static final ImmutableSortedMap NATURAL_EMPTY_MAP = new ImmutableSortedMap(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
   private final transient RegularImmutableSortedSet keySet;
   private final transient ImmutableList valueList;
   private transient ImmutableSortedMap descendingMap;
   private static final long serialVersionUID = 0L;

   static ImmutableSortedMap emptyMap(Comparator var0) {
      return Ordering.natural().equals(var0)?of():new ImmutableSortedMap(ImmutableSortedSet.emptySet(var0), ImmutableList.of());
   }

   public static ImmutableSortedMap of() {
      return NATURAL_EMPTY_MAP;
   }

   public static ImmutableSortedMap of(Comparable var0, Object var1) {
      return of(Ordering.natural(), var0, var1);
   }

   private static ImmutableSortedMap of(Comparator var0, Object var1, Object var2) {
      return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.of(var1), (Comparator)Preconditions.checkNotNull(var0)), ImmutableList.of(var2));
   }

   private static ImmutableSortedMap ofEntries(ImmutableMapEntry... var0) {
      return fromEntries(Ordering.natural(), false, var0, var0.length);
   }

   public static ImmutableSortedMap of(Comparable var0, Object var1, Comparable var2, Object var3) {
      return ofEntries(new ImmutableMapEntry[]{entryOf(var0, var1), entryOf(var2, var3)});
   }

   public static ImmutableSortedMap of(Comparable var0, Object var1, Comparable var2, Object var3, Comparable var4, Object var5) {
      return ofEntries(new ImmutableMapEntry[]{entryOf(var0, var1), entryOf(var2, var3), entryOf(var4, var5)});
   }

   public static ImmutableSortedMap of(Comparable var0, Object var1, Comparable var2, Object var3, Comparable var4, Object var5, Comparable var6, Object var7) {
      return ofEntries(new ImmutableMapEntry[]{entryOf(var0, var1), entryOf(var2, var3), entryOf(var4, var5), entryOf(var6, var7)});
   }

   public static ImmutableSortedMap of(Comparable var0, Object var1, Comparable var2, Object var3, Comparable var4, Object var5, Comparable var6, Object var7, Comparable var8, Object var9) {
      return ofEntries(new ImmutableMapEntry[]{entryOf(var0, var1), entryOf(var2, var3), entryOf(var4, var5), entryOf(var6, var7), entryOf(var8, var9)});
   }

   public static ImmutableSortedMap copyOf(Map var0) {
      Ordering var1 = (Ordering)NATURAL_ORDER;
      return copyOfInternal(var0, var1);
   }

   public static ImmutableSortedMap copyOf(Map var0, Comparator var1) {
      return copyOfInternal(var0, (Comparator)Preconditions.checkNotNull(var1));
   }

   @Beta
   public static ImmutableSortedMap copyOf(Iterable var0) {
      Ordering var1 = (Ordering)NATURAL_ORDER;
      return copyOf((Iterable)var0, var1);
   }

   @Beta
   public static ImmutableSortedMap copyOf(Iterable var0, Comparator var1) {
      return fromEntries((Comparator)Preconditions.checkNotNull(var1), false, var0);
   }

   public static ImmutableSortedMap copyOfSorted(SortedMap var0) {
      Comparator var1 = var0.comparator();
      if(var1 == null) {
         var1 = NATURAL_ORDER;
      }

      if(var0 instanceof ImmutableSortedMap) {
         ImmutableSortedMap var2 = (ImmutableSortedMap)var0;
         if(!var2.isPartialView()) {
            return var2;
         }
      }

      return fromEntries(var1, true, var0.entrySet());
   }

   private static ImmutableSortedMap copyOfInternal(Map var0, Comparator var1) {
      boolean var2 = false;
      if(var0 instanceof SortedMap) {
         SortedMap var3 = (SortedMap)var0;
         Comparator var4 = var3.comparator();
         var2 = var4 == null?var1 == NATURAL_ORDER:var1.equals(var4);
      }

      if(var2 && var0 instanceof ImmutableSortedMap) {
         ImmutableSortedMap var5 = (ImmutableSortedMap)var0;
         if(!var5.isPartialView()) {
            return var5;
         }
      }

      return fromEntries(var1, var2, var0.entrySet());
   }

   private static ImmutableSortedMap fromEntries(Comparator var0, boolean var1, Iterable var2) {
      Entry[] var3 = (Entry[])((Entry[])Iterables.toArray(var2, (Object[])EMPTY_ENTRY_ARRAY));
      return fromEntries(var0, var1, var3, var3.length);
   }

   private static ImmutableSortedMap fromEntries(Comparator var0, boolean var1, Entry[] var2, int var3) {
      switch(var3) {
      case 0:
         return emptyMap(var0);
      case 1:
         return of(var0, var2[0].getKey(), var2[0].getValue());
      default:
         Object[] var4 = new Object[var3];
         Object[] var5 = new Object[var3];
         Object var8;
         if(var1) {
            for(int var6 = 0; var6 < var3; ++var6) {
               Object var7 = var2[var6].getKey();
               var8 = var2[var6].getValue();
               CollectPreconditions.checkEntryNotNull(var7, var8);
               var4[var6] = var7;
               var5[var6] = var8;
            }
         } else {
            Arrays.sort(var2, 0, var3, Ordering.from(var0).onKeys());
            Object var10 = var2[0].getKey();
            var4[0] = var10;
            var5[0] = var2[0].getValue();

            for(int var11 = 1; var11 < var3; ++var11) {
               var8 = var2[var11].getKey();
               Object var9 = var2[var11].getValue();
               CollectPreconditions.checkEntryNotNull(var8, var9);
               var4[var11] = var8;
               var5[var11] = var9;
               checkNoConflict(var0.compare(var10, var8) != 0, "key", var2[var11 - 1], var2[var11]);
               var10 = var8;
            }
         }

         return new ImmutableSortedMap(new RegularImmutableSortedSet(new RegularImmutableList(var4), var0), new RegularImmutableList(var5));
      }
   }

   public static ImmutableSortedMap$Builder naturalOrder() {
      return new ImmutableSortedMap$Builder(Ordering.natural());
   }

   public static ImmutableSortedMap$Builder orderedBy(Comparator var0) {
      return new ImmutableSortedMap$Builder(var0);
   }

   public static ImmutableSortedMap$Builder reverseOrder() {
      return new ImmutableSortedMap$Builder(Ordering.natural().reverse());
   }

   ImmutableSortedMap(RegularImmutableSortedSet var1, ImmutableList var2) {
      this(var1, var2, (ImmutableSortedMap)null);
   }

   ImmutableSortedMap(RegularImmutableSortedSet var1, ImmutableList var2, ImmutableSortedMap var3) {
      this.keySet = var1;
      this.valueList = var2;
      this.descendingMap = var3;
   }

   public int size() {
      return this.valueList.size();
   }

   public Object get(@Nullable Object var1) {
      int var2 = this.keySet.indexOf(var1);
      return var2 == -1?null:this.valueList.get(var2);
   }

   boolean isPartialView() {
      return this.keySet.isPartialView() || this.valueList.isPartialView();
   }

   public ImmutableSet entrySet() {
      return super.entrySet();
   }

   ImmutableSet createEntrySet() {
      return (ImmutableSet)(this.isEmpty()?ImmutableSet.of():new ImmutableSortedMap$1EntrySet(this));
   }

   public ImmutableSortedSet keySet() {
      return this.keySet;
   }

   public ImmutableCollection values() {
      return this.valueList;
   }

   public Comparator comparator() {
      return this.keySet().comparator();
   }

   public Object firstKey() {
      return this.keySet().first();
   }

   public Object lastKey() {
      return this.keySet().last();
   }

   private ImmutableSortedMap getSubMap(int var1, int var2) {
      return var1 == 0 && var2 == this.size()?this:(var1 == var2?emptyMap(this.comparator()):new ImmutableSortedMap(this.keySet.getSubSet(var1, var2), this.valueList.subList(var1, var2)));
   }

   public ImmutableSortedMap headMap(Object var1) {
      return this.headMap(var1, false);
   }

   public ImmutableSortedMap headMap(Object var1, boolean var2) {
      return this.getSubMap(0, this.keySet.headIndex(Preconditions.checkNotNull(var1), var2));
   }

   public ImmutableSortedMap subMap(Object var1, Object var2) {
      return this.subMap(var1, true, var2, false);
   }

   public ImmutableSortedMap subMap(Object var1, boolean var2, Object var3, boolean var4) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var3);
      Preconditions.checkArgument(this.comparator().compare(var1, var3) <= 0, "expected fromKey <= toKey but %s > %s", new Object[]{var1, var3});
      return this.headMap(var3, var4).tailMap(var1, var2);
   }

   public ImmutableSortedMap tailMap(Object var1) {
      return this.tailMap(var1, true);
   }

   public ImmutableSortedMap tailMap(Object var1, boolean var2) {
      return this.getSubMap(this.keySet.tailIndex(Preconditions.checkNotNull(var1), var2), this.size());
   }

   public Entry lowerEntry(Object var1) {
      return this.headMap(var1, false).lastEntry();
   }

   public Object lowerKey(Object var1) {
      return Maps.keyOrNull(this.lowerEntry(var1));
   }

   public Entry floorEntry(Object var1) {
      return this.headMap(var1, true).lastEntry();
   }

   public Object floorKey(Object var1) {
      return Maps.keyOrNull(this.floorEntry(var1));
   }

   public Entry ceilingEntry(Object var1) {
      return this.tailMap(var1, true).firstEntry();
   }

   public Object ceilingKey(Object var1) {
      return Maps.keyOrNull(this.ceilingEntry(var1));
   }

   public Entry higherEntry(Object var1) {
      return this.tailMap(var1, false).firstEntry();
   }

   public Object higherKey(Object var1) {
      return Maps.keyOrNull(this.higherEntry(var1));
   }

   public Entry firstEntry() {
      return this.isEmpty()?null:(Entry)this.entrySet().asList().get(0);
   }

   public Entry lastEntry() {
      return this.isEmpty()?null:(Entry)this.entrySet().asList().get(this.size() - 1);
   }

   @Deprecated
   public final Entry pollFirstEntry() {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final Entry pollLastEntry() {
      throw new UnsupportedOperationException();
   }

   public ImmutableSortedMap descendingMap() {
      ImmutableSortedMap var1 = this.descendingMap;
      return var1 == null?(this.isEmpty()?emptyMap(Ordering.from(this.comparator()).reverse()):new ImmutableSortedMap((RegularImmutableSortedSet)this.keySet.descendingSet(), this.valueList.reverse(), this)):var1;
   }

   public ImmutableSortedSet navigableKeySet() {
      return this.keySet;
   }

   public ImmutableSortedSet descendingKeySet() {
      return this.keySet.descendingSet();
   }

   Object writeReplace() {
      return new ImmutableSortedMap$SerializedForm(this);
   }

   // $FF: synthetic method
   static ImmutableSortedMap access$000(Comparator var0, Object var1, Object var2) {
      return of(var0, var1, var2);
   }

   // $FF: synthetic method
   static ImmutableSortedMap access$100(Comparator var0, boolean var1, Entry[] var2, int var3) {
      return fromEntries(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   static RegularImmutableSortedSet access$200(ImmutableSortedMap var0) {
      return var0.keySet;
   }

   // $FF: synthetic method
   static ImmutableList access$300(ImmutableSortedMap var0) {
      return var0.valueList;
   }
}
