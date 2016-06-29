package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$1;
import com.google.common.collect.MapConstraints$2;
import com.google.common.collect.MapConstraints$ConstrainedAsMapEntries;
import com.google.common.collect.MapConstraints$ConstrainedBiMap;
import com.google.common.collect.MapConstraints$ConstrainedEntries;
import com.google.common.collect.MapConstraints$ConstrainedEntrySet;
import com.google.common.collect.MapConstraints$ConstrainedListMultimap;
import com.google.common.collect.MapConstraints$ConstrainedMap;
import com.google.common.collect.MapConstraints$ConstrainedMultimap;
import com.google.common.collect.MapConstraints$ConstrainedSetMultimap;
import com.google.common.collect.MapConstraints$ConstrainedSortedSetMultimap;
import com.google.common.collect.MapConstraints$NotNullMapConstraint;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

@Deprecated
@Beta
@GwtCompatible
public final class MapConstraints {
   public static MapConstraint notNull() {
      return MapConstraints$NotNullMapConstraint.INSTANCE;
   }

   public static Map constrainedMap(Map var0, MapConstraint var1) {
      return new MapConstraints$ConstrainedMap(var0, var1);
   }

   public static Multimap constrainedMultimap(Multimap var0, MapConstraint var1) {
      return new MapConstraints$ConstrainedMultimap(var0, var1);
   }

   public static ListMultimap constrainedListMultimap(ListMultimap var0, MapConstraint var1) {
      return new MapConstraints$ConstrainedListMultimap(var0, var1);
   }

   public static SetMultimap constrainedSetMultimap(SetMultimap var0, MapConstraint var1) {
      return new MapConstraints$ConstrainedSetMultimap(var0, var1);
   }

   public static SortedSetMultimap constrainedSortedSetMultimap(SortedSetMultimap var0, MapConstraint var1) {
      return new MapConstraints$ConstrainedSortedSetMultimap(var0, var1);
   }

   private static Entry constrainedEntry(Entry var0, MapConstraint var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new MapConstraints$1(var0, var1);
   }

   private static Entry constrainedAsMapEntry(Entry var0, MapConstraint var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new MapConstraints$2(var0, var1);
   }

   private static Set constrainedAsMapEntries(Set var0, MapConstraint var1) {
      return new MapConstraints$ConstrainedAsMapEntries(var0, var1);
   }

   private static Collection constrainedEntries(Collection var0, MapConstraint var1) {
      return (Collection)(var0 instanceof Set?constrainedEntrySet((Set)var0, var1):new MapConstraints$ConstrainedEntries(var0, var1));
   }

   private static Set constrainedEntrySet(Set var0, MapConstraint var1) {
      return new MapConstraints$ConstrainedEntrySet(var0, var1);
   }

   public static BiMap constrainedBiMap(BiMap var0, MapConstraint var1) {
      return new MapConstraints$ConstrainedBiMap(var0, (BiMap)null, var1);
   }

   private static Collection checkValues(Object var0, Iterable var1, MapConstraint var2) {
      ArrayList var3 = Lists.newArrayList(var1);
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         var2.checkKeyValue(var0, var5);
      }

      return var3;
   }

   private static Map checkMap(Map var0, MapConstraint var1) {
      LinkedHashMap var2 = new LinkedHashMap(var0);
      Iterator var3 = var2.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         var1.checkKeyValue(var4.getKey(), var4.getValue());
      }

      return var2;
   }

   // $FF: synthetic method
   static Set access$000(Set var0, MapConstraint var1) {
      return constrainedEntrySet(var0, var1);
   }

   // $FF: synthetic method
   static Map access$100(Map var0, MapConstraint var1) {
      return checkMap(var0, var1);
   }

   // $FF: synthetic method
   static Set access$200(Set var0, MapConstraint var1) {
      return constrainedAsMapEntries(var0, var1);
   }

   // $FF: synthetic method
   static Collection access$300(Collection var0, MapConstraint var1) {
      return constrainedEntries(var0, var1);
   }

   // $FF: synthetic method
   static Collection access$400(Object var0, Iterable var1, MapConstraint var2) {
      return checkValues(var0, var1, var2);
   }

   // $FF: synthetic method
   static Entry access$500(Entry var0, MapConstraint var1) {
      return constrainedEntry(var0, var1);
   }

   // $FF: synthetic method
   static Entry access$700(Entry var0, MapConstraint var1) {
      return constrainedAsMapEntry(var0, var1);
   }
}
