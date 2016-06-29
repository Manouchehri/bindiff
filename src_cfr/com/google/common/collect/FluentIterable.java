/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable$1;
import com.google.common.collect.FluentIterable$FromIterableFunction;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public abstract class FluentIterable
implements Iterable {
    private final Iterable iterable;

    protected FluentIterable() {
        this.iterable = this;
    }

    FluentIterable(Iterable iterable) {
        this.iterable = (Iterable)Preconditions.checkNotNull(iterable);
    }

    @CheckReturnValue
    public static FluentIterable from(Iterable iterable) {
        FluentIterable fluentIterable;
        if (iterable instanceof FluentIterable) {
            fluentIterable = (FluentIterable)iterable;
            return fluentIterable;
        }
        fluentIterable = new FluentIterable$1(iterable, iterable);
        return fluentIterable;
    }

    @Deprecated
    @CheckReturnValue
    public static FluentIterable from(FluentIterable fluentIterable) {
        return (FluentIterable)Preconditions.checkNotNull(fluentIterable);
    }

    @CheckReturnValue
    @GoogleInternal
    public static FluentIterable of() {
        return FluentIterable.from(ImmutableList.of());
    }

    @CheckReturnValue
    @Beta
    public static FluentIterable of(Object[] arrobject) {
        return FluentIterable.from(Lists.newArrayList(arrobject));
    }

    @CheckReturnValue
    @GoogleInternal
    public static /* varargs */ FluentIterable of(@Nullable Object object, Object ... arrobject) {
        return FluentIterable.from(Lists.asList(object, arrobject));
    }

    @CheckReturnValue
    public String toString() {
        return Iterables.toString(this.iterable);
    }

    @CheckReturnValue
    public final int size() {
        return Iterables.size(this.iterable);
    }

    @CheckReturnValue
    public final boolean contains(@Nullable Object object) {
        return Iterables.contains(this.iterable, object);
    }

    @CheckReturnValue
    @GoogleInternal
    public final Object getOnlyElement() {
        return Iterables.getOnlyElement(this.iterable);
    }

    @Nullable
    @CheckReturnValue
    @GoogleInternal
    public final Object getOnlyElement(@Nullable Object object) {
        return Iterables.getOnlyElement(this.iterable, object);
    }

    @CheckReturnValue
    public final FluentIterable cycle() {
        return FluentIterable.from(Iterables.cycle(this.iterable));
    }

    @CheckReturnValue
    @Beta
    public final FluentIterable append(Iterable iterable) {
        return FluentIterable.from(Iterables.concat(this.iterable, iterable));
    }

    @CheckReturnValue
    @Beta
    public final /* varargs */ FluentIterable append(Object ... arrobject) {
        return FluentIterable.from(Iterables.concat(this.iterable, Arrays.asList(arrobject)));
    }

    @CheckReturnValue
    @GoogleInternal
    public final FluentIterable partition(int n2) {
        return FluentIterable.from(Iterables.partition(this.iterable, n2)).transform(new FluentIterable$FromIterableFunction(null));
    }

    @CheckReturnValue
    @GoogleInternal
    public final FluentIterable partitionWithPadding(int n2) {
        return FluentIterable.from(Iterables.paddedPartition(this.iterable, n2)).transform(new FluentIterable$FromIterableFunction(null));
    }

    @CheckReturnValue
    public final FluentIterable filter(Predicate predicate) {
        return FluentIterable.from(Iterables.filter(this.iterable, predicate));
    }

    @CheckReturnValue
    @GwtIncompatible(value="Class.isInstance")
    public final FluentIterable filter(Class class_) {
        return FluentIterable.from(Iterables.filter(this.iterable, class_));
    }

    @CheckReturnValue
    public final boolean anyMatch(Predicate predicate) {
        return Iterables.any(this.iterable, predicate);
    }

    @CheckReturnValue
    public final boolean allMatch(Predicate predicate) {
        return Iterables.all(this.iterable, predicate);
    }

    @CheckReturnValue
    public final Optional firstMatch(Predicate predicate) {
        return Iterables.tryFind(this.iterable, predicate);
    }

    @CheckReturnValue
    public final FluentIterable transform(Function function) {
        return FluentIterable.from(Iterables.transform(this.iterable, function));
    }

    @CheckReturnValue
    public FluentIterable transformAndConcat(Function function) {
        return FluentIterable.from(Iterables.concat((Iterable)this.transform(function)));
    }

    @CheckReturnValue
    public final Optional first() {
        Optional optional;
        Iterator iterator = this.iterable.iterator();
        if (iterator.hasNext()) {
            optional = Optional.of(iterator.next());
            return optional;
        }
        optional = Optional.absent();
        return optional;
    }

    @CheckReturnValue
    public final Optional last() {
        Object t2;
        if (this.iterable instanceof List) {
            List list = (List)this.iterable;
            if (!list.isEmpty()) return Optional.of(list.get(list.size() - 1));
            return Optional.absent();
        }
        Iterator iterator = this.iterable.iterator();
        if (!iterator.hasNext()) {
            return Optional.absent();
        }
        if (this.iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet)this.iterable;
            return Optional.of(sortedSet.last());
        }
        do {
            t2 = iterator.next();
        } while (iterator.hasNext());
        return Optional.of(t2);
    }

    @CheckReturnValue
    public final FluentIterable skip(int n2) {
        return FluentIterable.from(Iterables.skip(this.iterable, n2));
    }

    @CheckReturnValue
    public final FluentIterable limit(int n2) {
        return FluentIterable.from(Iterables.limit(this.iterable, n2));
    }

    @CheckReturnValue
    public final boolean isEmpty() {
        if (this.iterable.iterator().hasNext()) return false;
        return true;
    }

    @CheckReturnValue
    public final ImmutableList toList() {
        return ImmutableList.copyOf(this.iterable);
    }

    @CheckReturnValue
    public final ImmutableList toSortedList(Comparator comparator) {
        return Ordering.from(comparator).immutableSortedCopy(this.iterable);
    }

    @CheckReturnValue
    public final ImmutableSet toSet() {
        return ImmutableSet.copyOf(this.iterable);
    }

    @CheckReturnValue
    public final ImmutableSortedSet toSortedSet(Comparator comparator) {
        return ImmutableSortedSet.copyOf(comparator, this.iterable);
    }

    @CheckReturnValue
    public final ImmutableMultiset toMultiset() {
        return ImmutableMultiset.copyOf(this.iterable);
    }

    @CheckReturnValue
    public final ImmutableMap toMap(Function function) {
        return Maps.toMap(this.iterable, function);
    }

    @CheckReturnValue
    public final ImmutableListMultimap index(Function function) {
        return Multimaps.index(this.iterable, function);
    }

    @CheckReturnValue
    public final ImmutableMap uniqueIndex(Function function) {
        return Maps.uniqueIndex(this.iterable, function);
    }

    @CheckReturnValue
    @GwtIncompatible(value="Array.newArray(Class, int)")
    public final Object[] toArray(Class class_) {
        return Iterables.toArray(this.iterable, class_);
    }

    public final Collection copyInto(Collection collection) {
        Preconditions.checkNotNull(collection);
        if (this.iterable instanceof Collection) {
            collection.addAll(Collections2.cast(this.iterable));
            return collection;
        }
        Iterator iterator = this.iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            collection.add(t2);
        }
        return collection;
    }

    @CheckReturnValue
    @Beta
    public final String join(Joiner joiner) {
        return joiner.join(this);
    }

    @CheckReturnValue
    public final Object get(int n2) {
        return Iterables.get(this.iterable, n2);
    }
}

