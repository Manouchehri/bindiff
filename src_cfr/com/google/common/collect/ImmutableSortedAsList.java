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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedIterable;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
final class ImmutableSortedAsList
extends RegularImmutableAsList
implements SortedIterable {
    ImmutableSortedAsList(ImmutableSortedSet immutableSortedSet, ImmutableList immutableList) {
        super((ImmutableCollection)immutableSortedSet, immutableList);
    }

    @Override
    ImmutableSortedSet delegateCollection() {
        return (ImmutableSortedSet)super.delegateCollection();
    }

    @Override
    public Comparator comparator() {
        return this.delegateCollection().comparator();
    }

    @GwtIncompatible(value="ImmutableSortedSet.indexOf")
    @Override
    public int indexOf(@Nullable Object object) {
        int n2 = this.delegateCollection().indexOf(object);
        if (n2 < 0) return -1;
        if (!this.get(n2).equals(object)) return -1;
        int n3 = n2;
        return n3;
    }

    @GwtIncompatible(value="ImmutableSortedSet.indexOf")
    @Override
    public int lastIndexOf(@Nullable Object object) {
        return this.indexOf(object);
    }

    @Override
    public boolean contains(Object object) {
        if (this.indexOf(object) < 0) return false;
        return true;
    }

    @GwtIncompatible(value="super.subListUnchecked does not exist; inherited subList is valid if slow")
    @Override
    ImmutableList subListUnchecked(int n2, int n3) {
        ImmutableList immutableList = super.subListUnchecked(n2, n3);
        return new RegularImmutableSortedSet(immutableList, this.comparator()).asList();
    }
}

