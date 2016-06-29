/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultiset$1;
import com.google.common.collect.ImmutableMultiset$Builder;
import com.google.common.collect.ImmutableMultiset$EntrySet;
import com.google.common.collect.ImmutableMultiset$SerializedForm;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.RegularImmutableMultiset;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public abstract class ImmutableMultiset
extends ImmutableCollection
implements Multiset {
    @LazyInit
    private transient ImmutableSet entrySet;

    public static ImmutableMultiset of() {
        return RegularImmutableMultiset.EMPTY;
    }

    public static ImmutableMultiset of(Object object) {
        return ImmutableMultiset.copyFromElements(object);
    }

    public static ImmutableMultiset of(Object object, Object object2) {
        return ImmutableMultiset.copyFromElements(object, object2);
    }

    public static ImmutableMultiset of(Object object, Object object2, Object object3) {
        return ImmutableMultiset.copyFromElements(object, object2, object3);
    }

    public static ImmutableMultiset of(Object object, Object object2, Object object3, Object object4) {
        return ImmutableMultiset.copyFromElements(object, object2, object3, object4);
    }

    public static ImmutableMultiset of(Object object, Object object2, Object object3, Object object4, Object object5) {
        return ImmutableMultiset.copyFromElements(object, object2, object3, object4, object5);
    }

    public static /* varargs */ ImmutableMultiset of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object ... arrobject) {
        return new ImmutableMultiset$Builder().add(object).add(object2).add(object3).add(object4).add(object5).add(object6).add(arrobject).build();
    }

    public static ImmutableMultiset copyOf(Object[] arrobject) {
        return ImmutableMultiset.copyFromElements(arrobject);
    }

    public static ImmutableMultiset copyOf(Iterable iterable) {
        Multiset multiset;
        if (iterable instanceof ImmutableMultiset && !(multiset = (ImmutableMultiset)iterable).isPartialView()) {
            return multiset;
        }
        multiset = iterable instanceof Multiset ? Multisets.cast(iterable) : LinkedHashMultiset.create(iterable);
        return ImmutableMultiset.copyFromEntries(multiset.entrySet());
    }

    private static /* varargs */ ImmutableMultiset copyFromElements(Object ... arrobject) {
        LinkedHashMultiset linkedHashMultiset = LinkedHashMultiset.create();
        Collections.addAll(linkedHashMultiset, arrobject);
        return ImmutableMultiset.copyFromEntries(linkedHashMultiset.entrySet());
    }

    static ImmutableMultiset copyFromEntries(Collection collection) {
        if (!collection.isEmpty()) return new RegularImmutableMultiset(collection);
        return ImmutableMultiset.of();
    }

    public static ImmutableMultiset copyOf(Iterator iterator) {
        LinkedHashMultiset linkedHashMultiset = LinkedHashMultiset.create();
        Iterators.addAll(linkedHashMultiset, iterator);
        return ImmutableMultiset.copyFromEntries(linkedHashMultiset.entrySet());
    }

    ImmutableMultiset() {
    }

    @Override
    public UnmodifiableIterator iterator() {
        UnmodifiableIterator unmodifiableIterator = this.entrySet().iterator();
        return new ImmutableMultiset$1(this, unmodifiableIterator);
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (this.count(object) <= 0) return false;
        return true;
    }

    @Deprecated
    @Override
    public final int add(Object object, int n2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public final int remove(Object object, int n2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public final int setCount(Object object, int n2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public final boolean setCount(Object object, int n2, int n3) {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible(value="not present in emulated superclass")
    @Override
    int copyIntoArray(Object[] arrobject, int n2) {
        UnmodifiableIterator unmodifiableIterator = this.entrySet().iterator();
        while (unmodifiableIterator.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)unmodifiableIterator.next();
            Arrays.fill(arrobject, n2, n2 + multiset$Entry.getCount(), multiset$Entry.getElement());
            n2 += multiset$Entry.getCount();
        }
        return n2;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return Multisets.equalsImpl(this, object);
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
        ImmutableSet immutableSet;
        ImmutableSet immutableSet2 = this.entrySet;
        if (immutableSet2 == null) {
            immutableSet = this.entrySet = this.createEntrySet();
            return immutableSet;
        }
        immutableSet = immutableSet2;
        return immutableSet;
    }

    private final ImmutableSet createEntrySet() {
        ImmutableSet immutableSet;
        if (this.isEmpty()) {
            immutableSet = ImmutableSet.of();
            return immutableSet;
        }
        immutableSet = new ImmutableMultiset$EntrySet(this, null);
        return immutableSet;
    }

    abstract Multiset$Entry getEntry(int var1);

    @Override
    Object writeReplace() {
        return new ImmutableMultiset$SerializedForm(this);
    }

    public static ImmutableMultiset$Builder builder() {
        return new ImmutableMultiset$Builder();
    }
}

