package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableEnumSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Platform;
import com.google.common.collect.Range;
import com.google.common.collect.Sets$1;
import com.google.common.collect.Sets$2;
import com.google.common.collect.Sets$3;
import com.google.common.collect.Sets$4;
import com.google.common.collect.Sets$CartesianSet;
import com.google.common.collect.Sets$FilteredNavigableSet;
import com.google.common.collect.Sets$FilteredSet;
import com.google.common.collect.Sets$FilteredSortedSet;
import com.google.common.collect.Sets$PowerSet;
import com.google.common.collect.Sets$SetView;
import com.google.common.collect.Sets$UnmodifiableNavigableSet;
import com.google.common.collect.Synchronized;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public final class Sets {
   @GwtCompatible(
      serializable = true
   )
   public static ImmutableSet immutableEnumSet(Enum var0, Enum... var1) {
      return ImmutableEnumSet.asImmutable(EnumSet.of(var0, var1));
   }

   @GwtCompatible(
      serializable = true
   )
   public static ImmutableSet immutableEnumSet(Iterable var0) {
      if(var0 instanceof ImmutableEnumSet) {
         return (ImmutableEnumSet)var0;
      } else if(var0 instanceof Collection) {
         Collection var3 = (Collection)var0;
         return var3.isEmpty()?ImmutableSet.of():ImmutableEnumSet.asImmutable(EnumSet.copyOf(var3));
      } else {
         Iterator var1 = var0.iterator();
         if(var1.hasNext()) {
            EnumSet var2 = EnumSet.of((Enum)var1.next());
            Iterators.addAll(var2, var1);
            return ImmutableEnumSet.asImmutable(var2);
         } else {
            return ImmutableSet.of();
         }
      }
   }

   public static EnumSet newEnumSet(Iterable var0, Class var1) {
      EnumSet var2 = EnumSet.noneOf(var1);
      Iterables.addAll(var2, var0);
      return var2;
   }

   public static HashSet newHashSet() {
      return new HashSet();
   }

   public static HashSet newHashSet(Object... var0) {
      HashSet var1 = newHashSetWithExpectedSize(var0.length);
      Collections.addAll(var1, var0);
      return var1;
   }

   public static HashSet newHashSetWithExpectedSize(int var0) {
      return new HashSet(Maps.capacity(var0));
   }

   public static HashSet newHashSet(Iterable var0) {
      return var0 instanceof Collection?new HashSet(Collections2.cast(var0)):newHashSet(var0.iterator());
   }

   public static HashSet newHashSet(Iterator var0) {
      HashSet var1 = newHashSet();
      Iterators.addAll(var1, var0);
      return var1;
   }

   public static Set newConcurrentHashSet() {
      return newSetFromMap(new ConcurrentHashMap());
   }

   @GoogleInternal
   public static Set newConcurrentHashSet(Object... var0) {
      int var1 = Maps.capacity(var0.length);
      Set var2 = newSetFromMap(new ConcurrentHashMap(var1));
      Collections.addAll(var2, var0);
      return var2;
   }

   public static Set newConcurrentHashSet(Iterable var0) {
      Set var1 = newConcurrentHashSet();
      Iterables.addAll(var1, var0);
      return var1;
   }

   public static LinkedHashSet newLinkedHashSet() {
      return new LinkedHashSet();
   }

   @GoogleInternal
   public static LinkedHashSet newLinkedHashSet(Object... var0) {
      LinkedHashSet var1 = new LinkedHashSet(Maps.capacity(var0.length));
      Collections.addAll(var1, var0);
      return var1;
   }

   public static LinkedHashSet newLinkedHashSetWithExpectedSize(int var0) {
      return new LinkedHashSet(Maps.capacity(var0));
   }

   public static LinkedHashSet newLinkedHashSet(Iterable var0) {
      if(var0 instanceof Collection) {
         return new LinkedHashSet(Collections2.cast(var0));
      } else {
         LinkedHashSet var1 = newLinkedHashSet();
         Iterables.addAll(var1, var0);
         return var1;
      }
   }

   @GoogleInternal
   public static LinkedHashSet newLinkedHashSet(Iterator var0) {
      LinkedHashSet var1 = newLinkedHashSet();
      Iterators.addAll(var1, var0);
      return var1;
   }

   public static TreeSet newTreeSet() {
      return new TreeSet();
   }

   @GoogleInternal
   public static TreeSet newTreeSet(Comparable... var0) {
      TreeSet var1 = newTreeSet();
      Collections.addAll(var1, var0);
      return var1;
   }

   public static TreeSet newTreeSet(Iterable var0) {
      TreeSet var1 = newTreeSet();
      Iterables.addAll(var1, var0);
      return var1;
   }

   @GoogleInternal
   public static TreeSet newTreeSet(Iterator var0) {
      TreeSet var1 = newTreeSet();
      Iterators.addAll(var1, var0);
      return var1;
   }

   public static TreeSet newTreeSet(Comparator var0) {
      return new TreeSet((Comparator)Preconditions.checkNotNull(var0));
   }

   @GoogleInternal
   public static TreeSet newTreeSet(Comparator var0, Object... var1) {
      TreeSet var2 = newTreeSet(var0);
      Collections.addAll(var2, var1);
      return var2;
   }

   @GoogleInternal
   public static TreeSet newTreeSet(Comparator var0, Iterable var1) {
      return newTreeSet(var0, var1.iterator());
   }

   @GoogleInternal
   public static TreeSet newTreeSet(Comparator var0, Iterator var1) {
      TreeSet var2 = newTreeSet(var0);
      Iterators.addAll(var2, var1);
      return var2;
   }

   public static Set newIdentityHashSet() {
      return newSetFromMap(Maps.newIdentityHashMap());
   }

   @GwtIncompatible("CopyOnWriteArraySet")
   public static CopyOnWriteArraySet newCopyOnWriteArraySet() {
      return new CopyOnWriteArraySet();
   }

   @GwtIncompatible("CopyOnWriteArraySet")
   public static CopyOnWriteArraySet newCopyOnWriteArraySet(Iterable var0) {
      Object var1 = var0 instanceof Collection?Collections2.cast(var0):Lists.newArrayList(var0);
      return new CopyOnWriteArraySet((Collection)var1);
   }

   public static EnumSet complementOf(Collection var0) {
      if(var0 instanceof EnumSet) {
         return EnumSet.complementOf((EnumSet)var0);
      } else {
         Preconditions.checkArgument(!var0.isEmpty(), "collection is empty; use the other version of this method");
         Class var1 = ((Enum)var0.iterator().next()).getDeclaringClass();
         return makeComplementByHand(var0, var1);
      }
   }

   public static EnumSet complementOf(Collection var0, Class var1) {
      Preconditions.checkNotNull(var0);
      return var0 instanceof EnumSet?EnumSet.complementOf((EnumSet)var0):makeComplementByHand(var0, var1);
   }

   private static EnumSet makeComplementByHand(Collection var0, Class var1) {
      EnumSet var2 = EnumSet.allOf(var1);
      var2.removeAll(var0);
      return var2;
   }

   @GoogleInternal
   public static SortedSet asIntegerSet(int var0, int var1) {
      return (SortedSet)(var1 < var0?ImmutableSortedSet.of():ContiguousSet.create(Range.closed(Integer.valueOf(var0), Integer.valueOf(var1)), DiscreteDomain.integers()));
   }

   @Deprecated
   static Set newSetFromMap(Map var0) {
      return Platform.newSetFromMap(var0);
   }

   public static Sets$SetView union(Set var0, Set var1) {
      Preconditions.checkNotNull(var0, "set1");
      Preconditions.checkNotNull(var1, "set2");
      Sets$SetView var2 = difference(var1, var0);
      return new Sets$1(var0, var2, var1);
   }

   public static Sets$SetView intersection(Set var0, Set var1) {
      Preconditions.checkNotNull(var0, "set1");
      Preconditions.checkNotNull(var1, "set2");
      Predicate var2 = Predicates.in(var1);
      return new Sets$2(var0, var2, var1);
   }

   public static Sets$SetView difference(Set var0, Set var1) {
      Preconditions.checkNotNull(var0, "set1");
      Preconditions.checkNotNull(var1, "set2");
      Predicate var2 = Predicates.not(Predicates.in(var1));
      return new Sets$3(var0, var2, var1);
   }

   public static Sets$SetView symmetricDifference(Set var0, Set var1) {
      Preconditions.checkNotNull(var0, "set1");
      Preconditions.checkNotNull(var1, "set2");
      return new Sets$4(var0, var1);
   }

   @CheckReturnValue
   public static Set filter(Set var0, Predicate var1) {
      if(var0 instanceof SortedSet) {
         return filter((SortedSet)var0, var1);
      } else if(var0 instanceof Sets$FilteredSet) {
         Sets$FilteredSet var2 = (Sets$FilteredSet)var0;
         Predicate var3 = Predicates.and(var2.predicate, var1);
         return new Sets$FilteredSet((Set)var2.unfiltered, var3);
      } else {
         return new Sets$FilteredSet((Set)Preconditions.checkNotNull(var0), (Predicate)Preconditions.checkNotNull(var1));
      }
   }

   @CheckReturnValue
   public static SortedSet filter(SortedSet var0, Predicate var1) {
      return Platform.setsFilterSortedSet(var0, var1);
   }

   static SortedSet filterSortedIgnoreNavigable(SortedSet var0, Predicate var1) {
      if(var0 instanceof Sets$FilteredSet) {
         Sets$FilteredSet var2 = (Sets$FilteredSet)var0;
         Predicate var3 = Predicates.and(var2.predicate, var1);
         return new Sets$FilteredSortedSet((SortedSet)var2.unfiltered, var3);
      } else {
         return new Sets$FilteredSortedSet((SortedSet)Preconditions.checkNotNull(var0), (Predicate)Preconditions.checkNotNull(var1));
      }
   }

   @CheckReturnValue
   @GwtIncompatible("NavigableSet")
   public static NavigableSet filter(NavigableSet var0, Predicate var1) {
      if(var0 instanceof Sets$FilteredSet) {
         Sets$FilteredSet var2 = (Sets$FilteredSet)var0;
         Predicate var3 = Predicates.and(var2.predicate, var1);
         return new Sets$FilteredNavigableSet((NavigableSet)var2.unfiltered, var3);
      } else {
         return new Sets$FilteredNavigableSet((NavigableSet)Preconditions.checkNotNull(var0), (Predicate)Preconditions.checkNotNull(var1));
      }
   }

   public static Set cartesianProduct(List var0) {
      return Sets$CartesianSet.create(var0);
   }

   public static Set cartesianProduct(Set... var0) {
      return cartesianProduct(Arrays.asList(var0));
   }

   @GwtCompatible(
      serializable = false
   )
   public static Set powerSet(Set var0) {
      return new Sets$PowerSet(var0);
   }

   static int hashCodeImpl(Set var0) {
      int var1 = 0;

      for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 = ~(~var1)) {
         Object var3 = var2.next();
         var1 += var3 != null?var3.hashCode():0;
      }

      return var1;
   }

   static boolean equalsImpl(Set var0, @Nullable Object var1) {
      if(var0 == var1) {
         return true;
      } else if(var1 instanceof Set) {
         Set var2 = (Set)var1;

         try {
            return var0.size() == var2.size() && var0.containsAll(var2);
         } catch (NullPointerException var4) {
            return false;
         } catch (ClassCastException var5) {
            return false;
         }
      } else {
         return false;
      }
   }

   @GwtIncompatible("NavigableSet")
   public static NavigableSet unmodifiableNavigableSet(NavigableSet var0) {
      return (NavigableSet)(!(var0 instanceof ImmutableSortedSet) && !(var0 instanceof Sets$UnmodifiableNavigableSet)?new Sets$UnmodifiableNavigableSet(var0):var0);
   }

   @GwtIncompatible("NavigableSet")
   public static NavigableSet synchronizedNavigableSet(NavigableSet var0) {
      return Synchronized.navigableSet(var0);
   }

   static boolean removeAllImpl(Set var0, Iterator var1) {
      boolean var2;
      for(var2 = false; var1.hasNext(); var2 |= var0.remove(var1.next())) {
         ;
      }

      return var2;
   }

   static boolean removeAllImpl(Set var0, Collection var1) {
      Preconditions.checkNotNull(var1);
      if(var1 instanceof Multiset) {
         var1 = ((Multiset)var1).elementSet();
      }

      return var1 instanceof Set && ((Collection)var1).size() > var0.size()?Iterators.removeAll(var0.iterator(), (Collection)var1):removeAllImpl(var0, ((Collection)var1).iterator());
   }
}
