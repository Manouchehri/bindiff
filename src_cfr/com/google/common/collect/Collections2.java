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
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2$1;
import com.google.common.collect.Collections2$FilteredCollection;
import com.google.common.collect.Collections2$OrderedPermutationCollection;
import com.google.common.collect.Collections2$PermutationCollection;
import com.google.common.collect.Collections2$TransformedCollection;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public final class Collections2 {
    static final Joiner STANDARD_JOINER = Joiner.on(", ").useForNull("null");

    private Collections2() {
    }

    @CheckReturnValue
    public static Collection filter(Collection collection, Predicate predicate) {
        if (!(collection instanceof Collections2$FilteredCollection)) return new Collections2$FilteredCollection((Collection)Preconditions.checkNotNull(collection), (Predicate)Preconditions.checkNotNull(predicate));
        return ((Collections2$FilteredCollection)collection).createCombined(predicate);
    }

    static boolean safeContains(Collection collection, @Nullable Object object) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(object);
        }
        catch (ClassCastException var2_2) {
            return false;
        }
        catch (NullPointerException var2_3) {
            return false;
        }
    }

    static boolean safeRemove(Collection collection, @Nullable Object object) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.remove(object);
        }
        catch (ClassCastException var2_2) {
            return false;
        }
        catch (NullPointerException var2_3) {
            return false;
        }
    }

    public static Collection transform(Collection collection, Function function) {
        return new Collections2$TransformedCollection(collection, function);
    }

    static boolean containsAllImpl(Collection collection, Collection collection2) {
        return Iterables.all(collection2, Predicates.in(collection));
    }

    static String toStringImpl(Collection collection) {
        StringBuilder stringBuilder = Collections2.newStringBuilderForCollection(collection.size()).append('[');
        STANDARD_JOINER.appendTo(stringBuilder, Iterables.transform(collection, new Collections2$1(collection)));
        return stringBuilder.append(']').toString();
    }

    static StringBuilder newStringBuilderForCollection(int n2) {
        CollectPreconditions.checkNonnegative(n2, "size");
        return new StringBuilder((int)Math.min((long)n2 * 8, 0x40000000));
    }

    static Collection cast(Iterable iterable) {
        return (Collection)iterable;
    }

    @Beta
    public static Collection orderedPermutations(Iterable iterable) {
        return Collections2.orderedPermutations(iterable, Ordering.natural());
    }

    @Beta
    public static Collection orderedPermutations(Iterable iterable, Comparator comparator) {
        return new Collections2$OrderedPermutationCollection(iterable, comparator);
    }

    @Beta
    public static Collection permutations(Collection collection) {
        return new Collections2$PermutationCollection(ImmutableList.copyOf(collection));
    }

    private static boolean isPermutation(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        HashMultiset hashMultiset = HashMultiset.create(list);
        HashMultiset hashMultiset2 = HashMultiset.create(list2);
        return hashMultiset.equals(hashMultiset2);
    }

    private static boolean isPositiveInt(long l2) {
        if (l2 < 0) return false;
        if (l2 > Integer.MAX_VALUE) return false;
        return true;
    }

    static /* synthetic */ boolean access$000(long l2) {
        return Collections2.isPositiveInt(l2);
    }

    static /* synthetic */ boolean access$100(List list, List list2) {
        return Collections2.isPermutation(list, list2);
    }
}

