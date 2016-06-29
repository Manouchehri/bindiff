/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableEnumSet$1;
import com.google.common.collect.ImmutableEnumSet$EnumSerializedForm;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

@GwtCompatible(serializable=1, emulated=1)
final class ImmutableEnumSet
extends ImmutableSet {
    private final transient EnumSet delegate;
    @LazyInit
    private transient int hashCode;

    static ImmutableSet asImmutable(EnumSet enumSet) {
        switch (enumSet.size()) {
            case 0: {
                return ImmutableSet.of();
            }
            case 1: {
                return ImmutableSet.of(Iterables.getOnlyElement(enumSet));
            }
        }
        return new ImmutableEnumSet(enumSet);
    }

    private ImmutableEnumSet(EnumSet enumSet) {
        this.delegate = enumSet;
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    public UnmodifiableIterator iterator() {
        return Iterators.unmodifiableIterator(this.delegate.iterator());
    }

    @Override
    public int size() {
        return this.delegate.size();
    }

    @Override
    public boolean contains(Object object) {
        return this.delegate.contains(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        if (!(collection instanceof ImmutableEnumSet)) return this.delegate.containsAll(collection);
        collection = ((ImmutableEnumSet)collection).delegate;
        return this.delegate.containsAll(collection);
    }

    @Override
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ImmutableEnumSet)) return this.delegate.equals(object);
        object = ((ImmutableEnumSet)object).delegate;
        return this.delegate.equals(object);
    }

    @Override
    boolean isHashCodeFast() {
        return true;
    }

    @Override
    public int hashCode() {
        int n2;
        int n3 = this.hashCode;
        if (n3 == 0) {
            n2 = this.hashCode = this.delegate.hashCode();
            return n2;
        }
        n2 = n3;
        return n2;
    }

    @Override
    public String toString() {
        return this.delegate.toString();
    }

    @Override
    Object writeReplace() {
        return new ImmutableEnumSet$EnumSerializedForm(this.delegate);
    }

    /* synthetic */ ImmutableEnumSet(EnumSet enumSet, ImmutableEnumSet$1 immutableEnumSet$1) {
        this(enumSet);
    }
}

