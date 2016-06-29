package com.google.common.collect;

import java.util.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;

@GwtCompatible(emulated = true)
public final class Multimaps
{
    public static Multimap newMultimap(final Map map, final Supplier supplier) {
        return new Multimaps$CustomMultimap(map, supplier);
    }
    
    public static ListMultimap newListMultimap(final Map map, final Supplier supplier) {
        return new Multimaps$CustomListMultimap(map, supplier);
    }
    
    public static SetMultimap newSetMultimap(final Map map, final Supplier supplier) {
        return new Multimaps$CustomSetMultimap(map, supplier);
    }
    
    public static SortedSetMultimap newSortedSetMultimap(final Map map, final Supplier supplier) {
        return new Multimaps$CustomSortedSetMultimap(map, supplier);
    }
    
    public static Multimap invertFrom(final Multimap multimap, final Multimap multimap2) {
        Preconditions.checkNotNull(multimap2);
        for (final Map.Entry<K, Object> entry : multimap.entries()) {
            multimap2.put(entry.getValue(), entry.getKey());
        }
        return multimap2;
    }
    
    public static Multimap synchronizedMultimap(final Multimap multimap) {
        return Synchronized.multimap(multimap, null);
    }
    
    public static Multimap unmodifiableMultimap(final Multimap multimap) {
        if (multimap instanceof Multimaps$UnmodifiableMultimap || multimap instanceof ImmutableMultimap) {
            return multimap;
        }
        return new Multimaps$UnmodifiableMultimap(multimap);
    }
    
    @Deprecated
    public static Multimap unmodifiableMultimap(final ImmutableMultimap immutableMultimap) {
        return (Multimap)Preconditions.checkNotNull(immutableMultimap);
    }
    
    public static SetMultimap synchronizedSetMultimap(final SetMultimap setMultimap) {
        return Synchronized.setMultimap(setMultimap, null);
    }
    
    public static SetMultimap unmodifiableSetMultimap(final SetMultimap setMultimap) {
        if (setMultimap instanceof Multimaps$UnmodifiableSetMultimap || setMultimap instanceof ImmutableSetMultimap) {
            return setMultimap;
        }
        return new Multimaps$UnmodifiableSetMultimap(setMultimap);
    }
    
    @Deprecated
    public static SetMultimap unmodifiableSetMultimap(final ImmutableSetMultimap immutableSetMultimap) {
        return (SetMultimap)Preconditions.checkNotNull(immutableSetMultimap);
    }
    
    public static SortedSetMultimap synchronizedSortedSetMultimap(final SortedSetMultimap sortedSetMultimap) {
        return Synchronized.sortedSetMultimap(sortedSetMultimap, null);
    }
    
    public static SortedSetMultimap unmodifiableSortedSetMultimap(final SortedSetMultimap sortedSetMultimap) {
        if (sortedSetMultimap instanceof Multimaps$UnmodifiableSortedSetMultimap) {
            return sortedSetMultimap;
        }
        return new Multimaps$UnmodifiableSortedSetMultimap(sortedSetMultimap);
    }
    
    public static ListMultimap synchronizedListMultimap(final ListMultimap listMultimap) {
        return Synchronized.listMultimap(listMultimap, null);
    }
    
    public static ListMultimap unmodifiableListMultimap(final ListMultimap listMultimap) {
        if (listMultimap instanceof Multimaps$UnmodifiableListMultimap || listMultimap instanceof ImmutableListMultimap) {
            return listMultimap;
        }
        return new Multimaps$UnmodifiableListMultimap(listMultimap);
    }
    
    @Deprecated
    public static ListMultimap unmodifiableListMultimap(final ImmutableListMultimap immutableListMultimap) {
        return (ListMultimap)Preconditions.checkNotNull(immutableListMultimap);
    }
    
    private static Collection unmodifiableValueCollection(final Collection collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet<Object>)collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set<?>)(SortedSet<? extends T>)collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List<?>)(List<? extends T>)collection);
        }
        return Collections.unmodifiableCollection((Collection<?>)collection);
    }
    
    private static Collection unmodifiableEntries(final Collection collection) {
        if (collection instanceof Set) {
            return Maps.unmodifiableEntrySet((Set)collection);
        }
        return new Maps$UnmodifiableEntries(Collections.unmodifiableCollection((Collection<?>)collection));
    }
    
    @Beta
    public static Map asMap(final ListMultimap listMultimap) {
        return listMultimap.asMap();
    }
    
    @Beta
    public static Map asMap(final SetMultimap setMultimap) {
        return setMultimap.asMap();
    }
    
    @Beta
    public static Map asMap(final SortedSetMultimap sortedSetMultimap) {
        return sortedSetMultimap.asMap();
    }
    
    @Beta
    public static Map asMap(final Multimap multimap) {
        return multimap.asMap();
    }
    
    public static SetMultimap forMap(final Map map) {
        return new Multimaps$MapMultimap(map);
    }
    
    public static Multimap transformValues(final Multimap multimap, final Function function) {
        Preconditions.checkNotNull(function);
        return transformEntries(multimap, Maps.asEntryTransformer(function));
    }
    
    public static Multimap transformEntries(final Multimap multimap, final Maps$EntryTransformer maps$EntryTransformer) {
        return new Multimaps$TransformedEntriesMultimap(multimap, maps$EntryTransformer);
    }
    
    public static ListMultimap transformValues(final ListMultimap listMultimap, final Function function) {
        Preconditions.checkNotNull(function);
        return transformEntries(listMultimap, Maps.asEntryTransformer(function));
    }
    
    public static ListMultimap transformEntries(final ListMultimap listMultimap, final Maps$EntryTransformer maps$EntryTransformer) {
        return new Multimaps$TransformedEntriesListMultimap(listMultimap, maps$EntryTransformer);
    }
    
    public static ImmutableListMultimap index(final Iterable iterable, final Function function) {
        return index(iterable.iterator(), function);
    }
    
    public static ImmutableListMultimap index(final Iterator iterator, final Function function) {
        Preconditions.checkNotNull(function);
        final ImmutableListMultimap$Builder builder = ImmutableListMultimap.builder();
        while (iterator.hasNext()) {
            final Object next = iterator.next();
            Preconditions.checkNotNull(next, iterator);
            builder.put(function.apply(next), next);
        }
        return builder.build();
    }
    
    @CheckReturnValue
    public static Multimap filterKeys(final Multimap multimap, final Predicate predicate) {
        if (multimap instanceof SetMultimap) {
            return filterKeys((SetMultimap)multimap, predicate);
        }
        if (multimap instanceof ListMultimap) {
            return filterKeys((ListMultimap)multimap, predicate);
        }
        if (multimap instanceof FilteredKeyMultimap) {
            final FilteredKeyMultimap filteredKeyMultimap = (FilteredKeyMultimap)multimap;
            return new FilteredKeyMultimap(filteredKeyMultimap.unfiltered, Predicates.and(filteredKeyMultimap.keyPredicate, predicate));
        }
        if (multimap instanceof FilteredMultimap) {
            return filterFiltered((FilteredMultimap)multimap, Maps.keyPredicateOnEntries(predicate));
        }
        return new FilteredKeyMultimap(multimap, predicate);
    }
    
    @CheckReturnValue
    public static SetMultimap filterKeys(final SetMultimap setMultimap, final Predicate predicate) {
        if (setMultimap instanceof FilteredKeySetMultimap) {
            final FilteredKeySetMultimap filteredKeySetMultimap = (FilteredKeySetMultimap)setMultimap;
            return new FilteredKeySetMultimap(filteredKeySetMultimap.unfiltered(), Predicates.and(filteredKeySetMultimap.keyPredicate, predicate));
        }
        if (setMultimap instanceof FilteredSetMultimap) {
            return filterFiltered((FilteredSetMultimap)setMultimap, Maps.keyPredicateOnEntries(predicate));
        }
        return new FilteredKeySetMultimap(setMultimap, predicate);
    }
    
    @CheckReturnValue
    public static ListMultimap filterKeys(final ListMultimap listMultimap, final Predicate predicate) {
        if (listMultimap instanceof FilteredKeyListMultimap) {
            final FilteredKeyListMultimap filteredKeyListMultimap = (FilteredKeyListMultimap)listMultimap;
            return new FilteredKeyListMultimap(filteredKeyListMultimap.unfiltered(), Predicates.and(filteredKeyListMultimap.keyPredicate, predicate));
        }
        return new FilteredKeyListMultimap(listMultimap, predicate);
    }
    
    @CheckReturnValue
    public static Multimap filterValues(final Multimap multimap, final Predicate predicate) {
        return filterEntries(multimap, Maps.valuePredicateOnEntries(predicate));
    }
    
    @CheckReturnValue
    public static SetMultimap filterValues(final SetMultimap setMultimap, final Predicate predicate) {
        return filterEntries(setMultimap, Maps.valuePredicateOnEntries(predicate));
    }
    
    @CheckReturnValue
    public static Multimap filterEntries(final Multimap multimap, final Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        if (multimap instanceof SetMultimap) {
            return filterEntries((SetMultimap)multimap, predicate);
        }
        return (multimap instanceof FilteredMultimap) ? filterFiltered((FilteredMultimap)multimap, predicate) : new FilteredEntryMultimap((Multimap)Preconditions.checkNotNull(multimap), predicate);
    }
    
    @CheckReturnValue
    public static SetMultimap filterEntries(final SetMultimap setMultimap, final Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        return (setMultimap instanceof FilteredSetMultimap) ? filterFiltered((FilteredSetMultimap)setMultimap, predicate) : new FilteredEntrySetMultimap((SetMultimap)Preconditions.checkNotNull(setMultimap), predicate);
    }
    
    private static Multimap filterFiltered(final FilteredMultimap filteredMultimap, final Predicate predicate) {
        return new FilteredEntryMultimap(filteredMultimap.unfiltered(), Predicates.and(filteredMultimap.entryPredicate(), predicate));
    }
    
    private static SetMultimap filterFiltered(final FilteredSetMultimap filteredSetMultimap, final Predicate predicate) {
        return new FilteredEntrySetMultimap(filteredSetMultimap.unfiltered(), Predicates.and(filteredSetMultimap.entryPredicate(), predicate));
    }
    
    static boolean equalsImpl(final Multimap multimap, @Nullable final Object o) {
        return o == multimap || (o instanceof Multimap && multimap.asMap().equals(((Multimap)o).asMap()));
    }
}
