package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntrySetMultimap;
import com.google.common.collect.FilteredKeyListMultimap;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.FilteredKeySetMultimap;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.FilteredSetMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableListMultimap$Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Maps$UnmodifiableEntries;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$CustomListMultimap;
import com.google.common.collect.Multimaps$CustomMultimap;
import com.google.common.collect.Multimaps$CustomSetMultimap;
import com.google.common.collect.Multimaps$CustomSortedSetMultimap;
import com.google.common.collect.Multimaps$MapMultimap;
import com.google.common.collect.Multimaps$TransformedEntriesListMultimap;
import com.google.common.collect.Multimaps$TransformedEntriesMultimap;
import com.google.common.collect.Multimaps$UnmodifiableListMultimap;
import com.google.common.collect.Multimaps$UnmodifiableMultimap;
import com.google.common.collect.Multimaps$UnmodifiableSetMultimap;
import com.google.common.collect.Multimaps$UnmodifiableSortedSetMultimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.Synchronized;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.Map.Entry;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public final class Multimaps {
   public static Multimap newMultimap(Map var0, Supplier var1) {
      return new Multimaps$CustomMultimap(var0, var1);
   }

   public static ListMultimap newListMultimap(Map var0, Supplier var1) {
      return new Multimaps$CustomListMultimap(var0, var1);
   }

   public static SetMultimap newSetMultimap(Map var0, Supplier var1) {
      return new Multimaps$CustomSetMultimap(var0, var1);
   }

   public static SortedSetMultimap newSortedSetMultimap(Map var0, Supplier var1) {
      return new Multimaps$CustomSortedSetMultimap(var0, var1);
   }

   public static Multimap invertFrom(Multimap var0, Multimap var1) {
      Preconditions.checkNotNull(var1);
      Iterator var2 = var0.entries().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put(var3.getValue(), var3.getKey());
      }

      return var1;
   }

   public static Multimap synchronizedMultimap(Multimap var0) {
      return Synchronized.multimap(var0, (Object)null);
   }

   public static Multimap unmodifiableMultimap(Multimap var0) {
      return (Multimap)(!(var0 instanceof Multimaps$UnmodifiableMultimap) && !(var0 instanceof ImmutableMultimap)?new Multimaps$UnmodifiableMultimap(var0):var0);
   }

   @Deprecated
   public static Multimap unmodifiableMultimap(ImmutableMultimap var0) {
      return (Multimap)Preconditions.checkNotNull(var0);
   }

   public static SetMultimap synchronizedSetMultimap(SetMultimap var0) {
      return Synchronized.setMultimap(var0, (Object)null);
   }

   public static SetMultimap unmodifiableSetMultimap(SetMultimap var0) {
      return (SetMultimap)(!(var0 instanceof Multimaps$UnmodifiableSetMultimap) && !(var0 instanceof ImmutableSetMultimap)?new Multimaps$UnmodifiableSetMultimap(var0):var0);
   }

   @Deprecated
   public static SetMultimap unmodifiableSetMultimap(ImmutableSetMultimap var0) {
      return (SetMultimap)Preconditions.checkNotNull(var0);
   }

   public static SortedSetMultimap synchronizedSortedSetMultimap(SortedSetMultimap var0) {
      return Synchronized.sortedSetMultimap(var0, (Object)null);
   }

   public static SortedSetMultimap unmodifiableSortedSetMultimap(SortedSetMultimap var0) {
      return (SortedSetMultimap)(var0 instanceof Multimaps$UnmodifiableSortedSetMultimap?var0:new Multimaps$UnmodifiableSortedSetMultimap(var0));
   }

   public static ListMultimap synchronizedListMultimap(ListMultimap var0) {
      return Synchronized.listMultimap(var0, (Object)null);
   }

   public static ListMultimap unmodifiableListMultimap(ListMultimap var0) {
      return (ListMultimap)(!(var0 instanceof Multimaps$UnmodifiableListMultimap) && !(var0 instanceof ImmutableListMultimap)?new Multimaps$UnmodifiableListMultimap(var0):var0);
   }

   @Deprecated
   public static ListMultimap unmodifiableListMultimap(ImmutableListMultimap var0) {
      return (ListMultimap)Preconditions.checkNotNull(var0);
   }

   private static Collection unmodifiableValueCollection(Collection var0) {
      return (Collection)(var0 instanceof SortedSet?Collections.unmodifiableSortedSet((SortedSet)var0):(var0 instanceof Set?Collections.unmodifiableSet((Set)var0):(var0 instanceof List?Collections.unmodifiableList((List)var0):Collections.unmodifiableCollection(var0))));
   }

   private static Collection unmodifiableEntries(Collection var0) {
      return (Collection)(var0 instanceof Set?Maps.unmodifiableEntrySet((Set)var0):new Maps$UnmodifiableEntries(Collections.unmodifiableCollection(var0)));
   }

   @Beta
   public static Map asMap(ListMultimap var0) {
      return var0.asMap();
   }

   @Beta
   public static Map asMap(SetMultimap var0) {
      return var0.asMap();
   }

   @Beta
   public static Map asMap(SortedSetMultimap var0) {
      return var0.asMap();
   }

   @Beta
   public static Map asMap(Multimap var0) {
      return var0.asMap();
   }

   public static SetMultimap forMap(Map var0) {
      return new Multimaps$MapMultimap(var0);
   }

   public static Multimap transformValues(Multimap var0, Function var1) {
      Preconditions.checkNotNull(var1);
      Maps$EntryTransformer var2 = Maps.asEntryTransformer(var1);
      return transformEntries(var0, var2);
   }

   public static Multimap transformEntries(Multimap var0, Maps$EntryTransformer var1) {
      return new Multimaps$TransformedEntriesMultimap(var0, var1);
   }

   public static ListMultimap transformValues(ListMultimap var0, Function var1) {
      Preconditions.checkNotNull(var1);
      Maps$EntryTransformer var2 = Maps.asEntryTransformer(var1);
      return transformEntries(var0, var2);
   }

   public static ListMultimap transformEntries(ListMultimap var0, Maps$EntryTransformer var1) {
      return new Multimaps$TransformedEntriesListMultimap(var0, var1);
   }

   public static ImmutableListMultimap index(Iterable var0, Function var1) {
      return index(var0.iterator(), var1);
   }

   public static ImmutableListMultimap index(Iterator var0, Function var1) {
      Preconditions.checkNotNull(var1);
      ImmutableListMultimap$Builder var2 = ImmutableListMultimap.builder();

      while(var0.hasNext()) {
         Object var3 = var0.next();
         Preconditions.checkNotNull(var3, var0);
         var2.put(var1.apply(var3), var3);
      }

      return var2.build();
   }

   @CheckReturnValue
   public static Multimap filterKeys(Multimap var0, Predicate var1) {
      if(var0 instanceof SetMultimap) {
         return filterKeys((SetMultimap)var0, var1);
      } else if(var0 instanceof ListMultimap) {
         return filterKeys((ListMultimap)var0, var1);
      } else if(var0 instanceof FilteredKeyMultimap) {
         FilteredKeyMultimap var3 = (FilteredKeyMultimap)var0;
         return new FilteredKeyMultimap(var3.unfiltered, Predicates.and(var3.keyPredicate, var1));
      } else if(var0 instanceof FilteredMultimap) {
         FilteredMultimap var2 = (FilteredMultimap)var0;
         return filterFiltered(var2, Maps.keyPredicateOnEntries(var1));
      } else {
         return new FilteredKeyMultimap(var0, var1);
      }
   }

   @CheckReturnValue
   public static SetMultimap filterKeys(SetMultimap var0, Predicate var1) {
      if(var0 instanceof FilteredKeySetMultimap) {
         FilteredKeySetMultimap var3 = (FilteredKeySetMultimap)var0;
         return new FilteredKeySetMultimap(var3.unfiltered(), Predicates.and(var3.keyPredicate, var1));
      } else if(var0 instanceof FilteredSetMultimap) {
         FilteredSetMultimap var2 = (FilteredSetMultimap)var0;
         return filterFiltered(var2, Maps.keyPredicateOnEntries(var1));
      } else {
         return new FilteredKeySetMultimap(var0, var1);
      }
   }

   @CheckReturnValue
   public static ListMultimap filterKeys(ListMultimap var0, Predicate var1) {
      if(var0 instanceof FilteredKeyListMultimap) {
         FilteredKeyListMultimap var2 = (FilteredKeyListMultimap)var0;
         return new FilteredKeyListMultimap(var2.unfiltered(), Predicates.and(var2.keyPredicate, var1));
      } else {
         return new FilteredKeyListMultimap(var0, var1);
      }
   }

   @CheckReturnValue
   public static Multimap filterValues(Multimap var0, Predicate var1) {
      return filterEntries(var0, Maps.valuePredicateOnEntries(var1));
   }

   @CheckReturnValue
   public static SetMultimap filterValues(SetMultimap var0, Predicate var1) {
      return filterEntries(var0, Maps.valuePredicateOnEntries(var1));
   }

   @CheckReturnValue
   public static Multimap filterEntries(Multimap var0, Predicate var1) {
      Preconditions.checkNotNull(var1);
      return (Multimap)(var0 instanceof SetMultimap?filterEntries((SetMultimap)var0, var1):(var0 instanceof FilteredMultimap?filterFiltered((FilteredMultimap)var0, var1):new FilteredEntryMultimap((Multimap)Preconditions.checkNotNull(var0), var1)));
   }

   @CheckReturnValue
   public static SetMultimap filterEntries(SetMultimap var0, Predicate var1) {
      Preconditions.checkNotNull(var1);
      return (SetMultimap)(var0 instanceof FilteredSetMultimap?filterFiltered((FilteredSetMultimap)var0, var1):new FilteredEntrySetMultimap((SetMultimap)Preconditions.checkNotNull(var0), var1));
   }

   private static Multimap filterFiltered(FilteredMultimap var0, Predicate var1) {
      Predicate var2 = Predicates.and(var0.entryPredicate(), var1);
      return new FilteredEntryMultimap(var0.unfiltered(), var2);
   }

   private static SetMultimap filterFiltered(FilteredSetMultimap var0, Predicate var1) {
      Predicate var2 = Predicates.and(var0.entryPredicate(), var1);
      return new FilteredEntrySetMultimap(var0.unfiltered(), var2);
   }

   static boolean equalsImpl(Multimap var0, @Nullable Object var1) {
      if(var1 == var0) {
         return true;
      } else if(var1 instanceof Multimap) {
         Multimap var2 = (Multimap)var1;
         return var0.asMap().equals(var2.asMap());
      } else {
         return false;
      }
   }

   // $FF: synthetic method
   static Collection access$000(Collection var0) {
      return unmodifiableValueCollection(var0);
   }

   // $FF: synthetic method
   static Collection access$100(Collection var0) {
      return unmodifiableEntries(var0);
   }
}
