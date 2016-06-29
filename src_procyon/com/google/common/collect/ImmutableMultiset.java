package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.*;
import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
public abstract class ImmutableMultiset extends ImmutableCollection implements Multiset
{
    @LazyInit
    private transient ImmutableSet entrySet;
    
    public static ImmutableMultiset of() {
        return RegularImmutableMultiset.EMPTY;
    }
    
    public static ImmutableMultiset of(final Object o) {
        return copyFromElements(o);
    }
    
    public static ImmutableMultiset of(final Object o, final Object o2) {
        return copyFromElements(o, o2);
    }
    
    public static ImmutableMultiset of(final Object o, final Object o2, final Object o3) {
        return copyFromElements(o, o2, o3);
    }
    
    public static ImmutableMultiset of(final Object o, final Object o2, final Object o3, final Object o4) {
        return copyFromElements(o, o2, o3, o4);
    }
    
    public static ImmutableMultiset of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5) {
        return copyFromElements(o, o2, o3, o4, o5);
    }
    
    public static ImmutableMultiset of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object... array) {
        return new ImmutableMultiset$Builder().add(o).add(o2).add(o3).add(o4).add(o5).add(o6).add(array).build();
    }
    
    public static ImmutableMultiset copyOf(final Object[] array) {
        return copyFromElements(array);
    }
    
    public static ImmutableMultiset copyOf(final Iterable iterable) {
        if (iterable instanceof ImmutableMultiset) {
            final ImmutableMultiset immutableMultiset = (ImmutableMultiset)iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        return copyFromEntries(((iterable instanceof Multiset) ? Multisets.cast(iterable) : LinkedHashMultiset.create(iterable)).entrySet());
    }
    
    private static ImmutableMultiset copyFromElements(final Object... array) {
        final LinkedHashMultiset create = LinkedHashMultiset.create();
        Collections.addAll(create, array);
        return copyFromEntries(create.entrySet());
    }
    
    static ImmutableMultiset copyFromEntries(final Collection collection) {
        if (collection.isEmpty()) {
            return of();
        }
        return new RegularImmutableMultiset(collection);
    }
    
    public static ImmutableMultiset copyOf(final Iterator iterator) {
        final LinkedHashMultiset create = LinkedHashMultiset.create();
        Iterators.addAll(create, iterator);
        return copyFromEntries(create.entrySet());
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return new ImmutableMultiset$1(this, this.entrySet().iterator());
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.count(o) > 0;
    }
    
    @Deprecated
    @Override
    public final int add(final Object o, final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final int remove(final Object o, final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final int setCount(final Object o, final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final boolean setCount(final Object o, final int n, final int n2) {
        throw new UnsupportedOperationException();
    }
    
    @GwtIncompatible("not present in emulated superclass")
    @Override
    int copyIntoArray(final Object[] array, int n) {
        for (final Multiset$Entry multiset$Entry : this.entrySet()) {
            Arrays.fill(array, n, n + multiset$Entry.getCount(), multiset$Entry.getElement());
            n += multiset$Entry.getCount();
        }
        return n;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return Multisets.equalsImpl(this, o);
    }
    
    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this.entrySet());
    }
    
    @Override
    public String toString() {
        return this.entrySet().toString();
    }
    
    @Override
    public ImmutableSet entrySet() {
        final ImmutableSet entrySet = this.entrySet;
        return (entrySet == null) ? (this.entrySet = this.createEntrySet()) : entrySet;
    }
    
    private final ImmutableSet createEntrySet() {
        return this.isEmpty() ? ImmutableSet.of() : new ImmutableMultiset$EntrySet(this, null);
    }
    
    abstract Multiset$Entry getEntry(final int p0);
    
    @Override
    Object writeReplace() {
        return new ImmutableMultiset$SerializedForm(this);
    }
    
    public static ImmutableMultiset$Builder builder() {
        return new ImmutableMultiset$Builder();
    }
}
