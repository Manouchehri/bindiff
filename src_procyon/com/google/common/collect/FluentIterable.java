package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;
import com.google.common.base.*;

@GwtCompatible(emulated = true)
public abstract class FluentIterable implements Iterable
{
    private final Iterable iterable;
    
    protected FluentIterable() {
        this.iterable = this;
    }
    
    FluentIterable(final Iterable iterable) {
        this.iterable = (Iterable)Preconditions.checkNotNull(iterable);
    }
    
    @CheckReturnValue
    public static FluentIterable from(final Iterable iterable) {
        return (iterable instanceof FluentIterable) ? ((FluentIterable)iterable) : new FluentIterable$1(iterable, iterable);
    }
    
    @Deprecated
    @CheckReturnValue
    public static FluentIterable from(final FluentIterable fluentIterable) {
        return (FluentIterable)Preconditions.checkNotNull(fluentIterable);
    }
    
    @CheckReturnValue
    @GoogleInternal
    public static FluentIterable of() {
        return from(ImmutableList.of());
    }
    
    @CheckReturnValue
    @Beta
    public static FluentIterable of(final Object[] array) {
        return from(Lists.newArrayList(array));
    }
    
    @CheckReturnValue
    @GoogleInternal
    public static FluentIterable of(@Nullable final Object o, final Object... array) {
        return from(Lists.asList(o, array));
    }
    
    @CheckReturnValue
    @Override
    public String toString() {
        return Iterables.toString(this.iterable);
    }
    
    @CheckReturnValue
    public final int size() {
        return Iterables.size(this.iterable);
    }
    
    @CheckReturnValue
    public final boolean contains(@Nullable final Object o) {
        return Iterables.contains(this.iterable, o);
    }
    
    @CheckReturnValue
    @GoogleInternal
    public final Object getOnlyElement() {
        return Iterables.getOnlyElement(this.iterable);
    }
    
    @Nullable
    @CheckReturnValue
    @GoogleInternal
    public final Object getOnlyElement(@Nullable final Object o) {
        return Iterables.getOnlyElement(this.iterable, o);
    }
    
    @CheckReturnValue
    public final FluentIterable cycle() {
        return from(Iterables.cycle(this.iterable));
    }
    
    @CheckReturnValue
    @Beta
    public final FluentIterable append(final Iterable iterable) {
        return from(Iterables.concat(this.iterable, iterable));
    }
    
    @CheckReturnValue
    @Beta
    public final FluentIterable append(final Object... array) {
        return from(Iterables.concat(this.iterable, Arrays.asList(array)));
    }
    
    @CheckReturnValue
    @GoogleInternal
    public final FluentIterable partition(final int n) {
        return from(Iterables.partition(this.iterable, n)).transform(new FluentIterable$FromIterableFunction(null));
    }
    
    @CheckReturnValue
    @GoogleInternal
    public final FluentIterable partitionWithPadding(final int n) {
        return from(Iterables.paddedPartition(this.iterable, n)).transform(new FluentIterable$FromIterableFunction(null));
    }
    
    @CheckReturnValue
    public final FluentIterable filter(final Predicate predicate) {
        return from(Iterables.filter(this.iterable, predicate));
    }
    
    @CheckReturnValue
    @GwtIncompatible("Class.isInstance")
    public final FluentIterable filter(final Class clazz) {
        return from(Iterables.filter(this.iterable, clazz));
    }
    
    @CheckReturnValue
    public final boolean anyMatch(final Predicate predicate) {
        return Iterables.any(this.iterable, predicate);
    }
    
    @CheckReturnValue
    public final boolean allMatch(final Predicate predicate) {
        return Iterables.all(this.iterable, predicate);
    }
    
    @CheckReturnValue
    public final Optional firstMatch(final Predicate predicate) {
        return Iterables.tryFind(this.iterable, predicate);
    }
    
    @CheckReturnValue
    public final FluentIterable transform(final Function function) {
        return from(Iterables.transform(this.iterable, function));
    }
    
    @CheckReturnValue
    public FluentIterable transformAndConcat(final Function function) {
        return from(Iterables.concat(this.transform(function)));
    }
    
    @CheckReturnValue
    public final Optional first() {
        final Iterator<Object> iterator = (Iterator<Object>)this.iterable.iterator();
        return iterator.hasNext() ? Optional.of(iterator.next()) : Optional.absent();
    }
    
    @CheckReturnValue
    public final Optional last() {
        if (this.iterable instanceof List) {
            final List list = (List)this.iterable;
            if (list.isEmpty()) {
                return Optional.absent();
            }
            return Optional.of(list.get(list.size() - 1));
        }
        else {
            final Iterator<Object> iterator = (Iterator<Object>)this.iterable.iterator();
            if (!iterator.hasNext()) {
                return Optional.absent();
            }
            if (this.iterable instanceof SortedSet) {
                return Optional.of(((SortedSet)this.iterable).last());
            }
            Object next;
            do {
                next = iterator.next();
            } while (iterator.hasNext());
            return Optional.of(next);
        }
    }
    
    @CheckReturnValue
    public final FluentIterable skip(final int n) {
        return from(Iterables.skip(this.iterable, n));
    }
    
    @CheckReturnValue
    public final FluentIterable limit(final int n) {
        return from(Iterables.limit(this.iterable, n));
    }
    
    @CheckReturnValue
    public final boolean isEmpty() {
        return !this.iterable.iterator().hasNext();
    }
    
    @CheckReturnValue
    public final ImmutableList toList() {
        return ImmutableList.copyOf(this.iterable);
    }
    
    @CheckReturnValue
    public final ImmutableList toSortedList(final Comparator comparator) {
        return Ordering.from(comparator).immutableSortedCopy(this.iterable);
    }
    
    @CheckReturnValue
    public final ImmutableSet toSet() {
        return ImmutableSet.copyOf(this.iterable);
    }
    
    @CheckReturnValue
    public final ImmutableSortedSet toSortedSet(final Comparator comparator) {
        return ImmutableSortedSet.copyOf(comparator, this.iterable);
    }
    
    @CheckReturnValue
    public final ImmutableMultiset toMultiset() {
        return ImmutableMultiset.copyOf(this.iterable);
    }
    
    @CheckReturnValue
    public final ImmutableMap toMap(final Function function) {
        return Maps.toMap(this.iterable, function);
    }
    
    @CheckReturnValue
    public final ImmutableListMultimap index(final Function function) {
        return Multimaps.index(this.iterable, function);
    }
    
    @CheckReturnValue
    public final ImmutableMap uniqueIndex(final Function function) {
        return Maps.uniqueIndex(this.iterable, function);
    }
    
    @CheckReturnValue
    @GwtIncompatible("Array.newArray(Class, int)")
    public final Object[] toArray(final Class clazz) {
        return Iterables.toArray(this.iterable, clazz);
    }
    
    public final Collection copyInto(final Collection collection) {
        Preconditions.checkNotNull(collection);
        if (this.iterable instanceof Collection) {
            collection.addAll(Collections2.cast(this.iterable));
        }
        else {
            final Iterator<Object> iterator = (Iterator<Object>)this.iterable.iterator();
            while (iterator.hasNext()) {
                collection.add(iterator.next());
            }
        }
        return collection;
    }
    
    @CheckReturnValue
    @Beta
    public final String join(final Joiner joiner) {
        return joiner.join(this);
    }
    
    @CheckReturnValue
    public final Object get(final int n) {
        return Iterables.get(this.iterable, n);
    }
}
