package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

@CheckReturnValue
@GwtCompatible
public final class Collections2
{
    static final Joiner STANDARD_JOINER;
    
    @CheckReturnValue
    public static Collection filter(final Collection collection, final Predicate predicate) {
        if (collection instanceof Collections2$FilteredCollection) {
            return ((Collections2$FilteredCollection)collection).createCombined(predicate);
        }
        return new Collections2$FilteredCollection((Collection)Preconditions.checkNotNull(collection), (Predicate)Preconditions.checkNotNull(predicate));
    }
    
    static boolean safeContains(final Collection collection, @Nullable final Object o) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(o);
        }
        catch (ClassCastException ex) {
            return false;
        }
        catch (NullPointerException ex2) {
            return false;
        }
    }
    
    static boolean safeRemove(final Collection collection, @Nullable final Object o) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.remove(o);
        }
        catch (ClassCastException ex) {
            return false;
        }
        catch (NullPointerException ex2) {
            return false;
        }
    }
    
    public static Collection transform(final Collection collection, final Function function) {
        return new Collections2$TransformedCollection(collection, function);
    }
    
    static boolean containsAllImpl(final Collection collection, final Collection collection2) {
        return Iterables.all(collection2, Predicates.in(collection));
    }
    
    static String toStringImpl(final Collection collection) {
        final StringBuilder append = newStringBuilderForCollection(collection.size()).append('[');
        Collections2.STANDARD_JOINER.appendTo(append, Iterables.transform(collection, new Collections2$1(collection)));
        return append.append(']').toString();
    }
    
    static StringBuilder newStringBuilderForCollection(final int n) {
        CollectPreconditions.checkNonnegative(n, "size");
        return new StringBuilder((int)Math.min(n * 8L, 1073741824L));
    }
    
    static Collection cast(final Iterable iterable) {
        return (Collection)iterable;
    }
    
    @Beta
    public static Collection orderedPermutations(final Iterable iterable) {
        return orderedPermutations(iterable, Ordering.natural());
    }
    
    @Beta
    public static Collection orderedPermutations(final Iterable iterable, final Comparator comparator) {
        return new Collections2$OrderedPermutationCollection(iterable, comparator);
    }
    
    @Beta
    public static Collection permutations(final Collection collection) {
        return new Collections2$PermutationCollection(ImmutableList.copyOf(collection));
    }
    
    private static boolean isPermutation(final List list, final List list2) {
        return list.size() == list2.size() && HashMultiset.create(list).equals(HashMultiset.create(list2));
    }
    
    private static boolean isPositiveInt(final long n) {
        return n >= 0L && n <= 2147483647L;
    }
    
    static {
        STANDARD_JOINER = Joiner.on(", ").useForNull("null");
    }
}
