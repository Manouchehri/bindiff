/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$SerializedForm;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public abstract class ImmutableCollection
extends AbstractCollection
implements Serializable {
    @LazyInit
    private transient ImmutableList asList;

    ImmutableCollection() {
    }

    public abstract UnmodifiableIterator iterator();

    @Override
    public final Object[] toArray() {
        int n2 = this.size();
        if (n2 == 0) {
            return ObjectArrays.EMPTY_ARRAY;
        }
        Object[] arrobject = new Object[n2];
        this.copyIntoArray(arrobject, 0);
        return arrobject;
    }

    @Override
    public final Object[] toArray(Object[] arrobject) {
        Preconditions.checkNotNull(arrobject);
        int n2 = this.size();
        if (arrobject.length < n2) {
            arrobject = ObjectArrays.newArray(arrobject, n2);
        } else if (arrobject.length > n2) {
            arrobject[n2] = null;
        }
        this.copyIntoArray(arrobject, 0);
        return arrobject;
    }

    @Override
    public abstract boolean contains(@Nullable Object var1);

    @Deprecated
    @Override
    public final boolean add(Object object) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public final boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableList asList() {
        ImmutableList immutableList;
        ImmutableList immutableList2 = this.asList;
        if (immutableList2 == null) {
            immutableList = this.asList = this.createAsList();
            return immutableList;
        }
        immutableList = immutableList2;
        return immutableList;
    }

    ImmutableList createAsList() {
        switch (this.size()) {
            case 0: {
                return ImmutableList.of();
            }
            case 1: {
                return ImmutableList.of(this.iterator().next());
            }
        }
        return new RegularImmutableAsList(this, this.toArray());
    }

    abstract boolean isPartialView();

    int copyIntoArray(Object[] arrobject, int n2) {
        UnmodifiableIterator unmodifiableIterator = this.iterator();
        while (unmodifiableIterator.hasNext()) {
            E e2 = unmodifiableIterator.next();
            arrobject[n2++] = e2;
        }
        return n2;
    }

    Object writeReplace() {
        return new ImmutableList$SerializedForm(this.toArray());
    }
}

