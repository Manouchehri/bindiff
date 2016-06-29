/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
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
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public final class Multimaps {
    private Multimaps() {
    }

    public static Multimap newMultimap(Map map, Supplier supplier) {
        return new Multimaps$CustomMultimap(map, supplier);
    }

    public static ListMultimap newListMultimap(Map map, Supplier supplier) {
        return new Multimaps$CustomListMultimap(map, supplier);
    }

    public static SetMultimap newSetMultimap(Map map, Supplier supplier) {
        return new Multimaps$CustomSetMultimap(map, supplier);
    }

    public static SortedSetMultimap newSortedSetMultimap(Map map, Supplier supplier) {
        return new Multimaps$CustomSortedSetMultimap(map, supplier);
    }

    public static Multimap invertFrom(Multimap multimap, Multimap multimap2) {
        Preconditions.checkNotNull(multimap2);
        Iterator iterator = multimap.entries().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            multimap2.put(entry.getValue(), entry.getKey());
        }
        return multimap2;
    }

    public static Multimap synchronizedMultimap(Multimap multimap) {
        return Synchronized.multimap(multimap, null);
    }

    public static Multimap unmodifiableMultimap(Multimap multimap) {
        if (multimap instanceof Multimaps$UnmodifiableMultimap) return multimap;
        if (!(multimap instanceof ImmutableMultimap)) return new Multimaps$UnmodifiableMultimap(multimap);
        return multimap;
    }

    @Deprecated
    public static Multimap unmodifiableMultimap(ImmutableMultimap immutableMultimap) {
        return (Multimap)Preconditions.checkNotNull(immutableMultimap);
    }

    public static SetMultimap synchronizedSetMultimap(SetMultimap setMultimap) {
        return Synchronized.setMultimap(setMultimap, null);
    }

    public static SetMultimap unmodifiableSetMultimap(SetMultimap setMultimap) {
        if (setMultimap instanceof Multimaps$UnmodifiableSetMultimap) return setMultimap;
        if (!(setMultimap instanceof ImmutableSetMultimap)) return new Multimaps$UnmodifiableSetMultimap(setMultimap);
        return setMultimap;
    }

    @Deprecated
    public static SetMultimap unmodifiableSetMultimap(ImmutableSetMultimap immutableSetMultimap) {
        return (SetMultimap)Preconditions.checkNotNull(immutableSetMultimap);
    }

    public static SortedSetMultimap synchronizedSortedSetMultimap(SortedSetMultimap sortedSetMultimap) {
        return Synchronized.sortedSetMultimap(sortedSetMultimap, null);
    }

    public static SortedSetMultimap unmodifiableSortedSetMultimap(SortedSetMultimap sortedSetMultimap) {
        if (!(sortedSetMultimap instanceof Multimaps$UnmodifiableSortedSetMultimap)) return new Multimaps$UnmodifiableSortedSetMultimap(sortedSetMultimap);
        return sortedSetMultimap;
    }

    public static ListMultimap synchronizedListMultimap(ListMultimap listMultimap) {
        return Synchronized.listMultimap(listMultimap, null);
    }

    public static ListMultimap unmodifiableListMultimap(ListMultimap listMultimap) {
        if (listMultimap instanceof Multimaps$UnmodifiableListMultimap) return listMultimap;
        if (!(listMultimap instanceof ImmutableListMultimap)) return new Multimaps$UnmodifiableListMultimap(listMultimap);
        return listMultimap;
    }

    @Deprecated
    public static ListMultimap unmodifiableListMultimap(ImmutableListMultimap immutableListMultimap) {
        return (ListMultimap)Preconditions.checkNotNull(immutableListMultimap);
    }

    private static Collection unmodifiableValueCollection(Collection collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet)collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set)collection);
        }
        if (!(collection instanceof List)) return Collections.unmodifiableCollection(collection);
        return Collections.unmodifiableList((List)collection);
    }

    private static Collection unmodifiableEntries(Collection collection) {
        if (!(collection instanceof Set)) return new Maps$UnmodifiableEntries(Collections.unmodifiableCollection(collection));
        return Maps.unmodifiableEntrySet((Set)collection);
    }

    @Beta
    public static Map asMap(ListMultimap listMultimap) {
        return listMultimap.asMap();
    }

    @Beta
    public static Map asMap(SetMultimap setMultimap) {
        return setMultimap.asMap();
    }

    @Beta
    public static Map asMap(SortedSetMultimap sortedSetMultimap) {
        return sortedSetMultimap.asMap();
    }

    @Beta
    public static Map asMap(Multimap multimap) {
        return multimap.asMap();
    }

    public static SetMultimap forMap(Map map) {
        return new Multimaps$MapMultimap(map);
    }

    public static Multimap transformValues(Multimap multimap, Function function) {
        Preconditions.checkNotNull(function);
        Maps$EntryTransformer maps$EntryTransformer = Maps.asEntryTransformer(function);
        return Multimaps.transformEntries(multimap, maps$EntryTransformer);
    }

    public static Multimap transformEntries(Multimap multimap, Maps$EntryTransformer maps$EntryTransformer) {
        return new Multimaps$TransformedEntriesMultimap(multimap, maps$EntryTransformer);
    }

    public static ListMultimap transformValues(ListMultimap listMultimap, Function function) {
        Preconditions.checkNotNull(function);
        Maps$EntryTransformer maps$EntryTransformer = Maps.asEntryTransformer(function);
        return Multimaps.transformEntries(listMultimap, maps$EntryTransformer);
    }

    public static ListMultimap transformEntries(ListMultimap listMultimap, Maps$EntryTransformer maps$EntryTransformer) {
        return new Multimaps$TransformedEntriesListMultimap(listMultimap, maps$EntryTransformer);
    }

    public static ImmutableListMultimap index(Iterable iterable, Function function) {
        return Multimaps.index(iterable.iterator(), function);
    }

    public static ImmutableListMultimap index(Iterator iterator, Function function) {
        Preconditions.checkNotNull(function);
        ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            Preconditions.checkNotNull(e2, iterator);
            immutableListMultimap$Builder.put(function.apply(e2), e2);
        }
        return immutableListMultimap$Builder.build();
    }

    @CheckReturnValue
    public static Multimap filterKeys(Multimap multimap, Predicate predicate) {
        if (multimap instanceof SetMultimap) {
            return Multimaps.filterKeys((SetMultimap)multimap, predicate);
        }
        if (multimap instanceof ListMultimap) {
            return Multimaps.filterKeys((ListMultimap)multimap, predicate);
        }
        if (multimap instanceof FilteredKeyMultimap) {
            FilteredKeyMultimap filteredKeyMultimap = (FilteredKeyMultimap)multimap;
            return new FilteredKeyMultimap(filteredKeyMultimap.unfiltered, Predicates.and(filteredKeyMultimap.keyPredicate, predicate));
        }
        if (!(multimap instanceof FilteredMultimap)) return new FilteredKeyMultimap(multimap, predicate);
        FilteredMultimap filteredMultimap = (FilteredMultimap)multimap;
        return Multimaps.filterFiltered(filteredMultimap, Maps.keyPredicateOnEntries(predicate));
    }

    @CheckReturnValue
    public static SetMultimap filterKeys(SetMultimap setMultimap, Predicate predicate) {
        if (setMultimap instanceof FilteredKeySetMultimap) {
            FilteredKeySetMultimap filteredKeySetMultimap = (FilteredKeySetMultimap)setMultimap;
            return new FilteredKeySetMultimap(filteredKeySetMultimap.unfiltered(), Predicates.and(filteredKeySetMultimap.keyPredicate, predicate));
        }
        if (!(setMultimap instanceof FilteredSetMultimap)) return new FilteredKeySetMultimap(setMultimap, predicate);
        FilteredSetMultimap filteredSetMultimap = (FilteredSetMultimap)setMultimap;
        return Multimaps.filterFiltered(filteredSetMultimap, Maps.keyPredicateOnEntries(predicate));
    }

    @CheckReturnValue
    public static ListMultimap filterKeys(ListMultimap listMultimap, Predicate predicate) {
        if (!(listMultimap instanceof FilteredKeyListMultimap)) return new FilteredKeyListMultimap(listMultimap, predicate);
        FilteredKeyListMultimap filteredKeyListMultimap = (FilteredKeyListMultimap)listMultimap;
        return new FilteredKeyListMultimap(filteredKeyListMultimap.unfiltered(), Predicates.and(filteredKeyListMultimap.keyPredicate, predicate));
    }

    @CheckReturnValue
    public static Multimap filterValues(Multimap multimap, Predicate predicate) {
        return Multimaps.filterEntries(multimap, Maps.valuePredicateOnEntries(predicate));
    }

    @CheckReturnValue
    public static SetMultimap filterValues(SetMultimap setMultimap, Predicate predicate) {
        return Multimaps.filterEntries(setMultimap, Maps.valuePredicateOnEntries(predicate));
    }

    @CheckReturnValue
    public static Multimap filterEntries(Multimap multimap, Predicate predicate) {
        FilteredEntryMultimap filteredEntryMultimap /* !! */ ;
        Preconditions.checkNotNull(predicate);
        if (multimap instanceof SetMultimap) {
            return Multimaps.filterEntries((SetMultimap)multimap, predicate);
        }
        if (multimap instanceof FilteredMultimap) {
            filteredEntryMultimap /* !! */  = Multimaps.filterFiltered((FilteredMultimap)multimap, predicate);
            return filteredEntryMultimap /* !! */ ;
        }
        filteredEntryMultimap /* !! */  = new FilteredEntryMultimap((Multimap)Preconditions.checkNotNull(multimap), predicate);
        return filteredEntryMultimap /* !! */ ;
    }

    @CheckReturnValue
    public static SetMultimap filterEntries(SetMultimap setMultimap, Predicate predicate) {
        FilteredEntrySetMultimap filteredEntrySetMultimap /* !! */ ;
        Preconditions.checkNotNull(predicate);
        if (setMultimap instanceof FilteredSetMultimap) {
            filteredEntrySetMultimap /* !! */  = Multimaps.filterFiltered((FilteredSetMultimap)setMultimap, predicate);
            return filteredEntrySetMultimap /* !! */ ;
        }
        filteredEntrySetMultimap /* !! */  = new FilteredEntrySetMultimap((SetMultimap)Preconditions.checkNotNull(setMultimap), predicate);
        return filteredEntrySetMultimap /* !! */ ;
    }

    private static Multimap filterFiltered(FilteredMultimap filteredMultimap, Predicate predicate) {
        Predicate predicate2 = Predicates.and(filteredMultimap.entryPredicate(), predicate);
        return new FilteredEntryMultimap(filteredMultimap.unfiltered(), predicate2);
    }

    private static SetMultimap filterFiltered(FilteredSetMultimap filteredSetMultimap, Predicate predicate) {
        Predicate predicate2 = Predicates.and(filteredSetMultimap.entryPredicate(), predicate);
        return new FilteredEntrySetMultimap(filteredSetMultimap.unfiltered(), predicate2);
    }

    static boolean equalsImpl(Multimap multimap, @Nullable Object object) {
        if (object == multimap) {
            return true;
        }
        if (!(object instanceof Multimap)) return false;
        Multimap multimap2 = (Multimap)object;
        return multimap.asMap().equals(multimap2.asMap());
    }

    static /* synthetic */ Collection access$000(Collection collection) {
        return Multimaps.unmodifiableValueCollection(collection);
    }

    static /* synthetic */ Collection access$100(Collection collection) {
        return Multimaps.unmodifiableEntries(collection);
    }
}

