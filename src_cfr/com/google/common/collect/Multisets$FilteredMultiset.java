/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$FilteredMultiset$1;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Multisets$FilteredMultiset
extends AbstractMultiset {
    final Multiset unfiltered;
    final Predicate predicate;

    Multisets$FilteredMultiset(Multiset multiset, Predicate predicate) {
        this.unfiltered = (Multiset)Preconditions.checkNotNull(multiset);
        this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }

    @Override
    public UnmodifiableIterator iterator() {
        return Iterators.filter(this.unfiltered.iterator(), this.predicate);
    }

    @Override
    Set createElementSet() {
        return Sets.filter(this.unfiltered.elementSet(), this.predicate);
    }

    @Override
    Set createEntrySet() {
        return Sets.filter(this.unfiltered.entrySet(), (Predicate)new Multisets$FilteredMultiset$1(this));
    }

    @Override
    Iterator entryIterator() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    int distinctElements() {
        return this.elementSet().size();
    }

    @Override
    public int count(@Nullable Object object) {
        int n2 = this.unfiltered.count(object);
        if (n2 <= 0) return 0;
        Object object2 = object;
        if (!this.predicate.apply(object2)) return 0;
        int n3 = n2;
        return n3;
    }

    @Override
    public int add(@Nullable Object object, int n2) {
        Preconditions.checkArgument(this.predicate.apply(object), "Element %s does not match predicate %s", object, this.predicate);
        return this.unfiltered.add(object, n2);
    }

    @Override
    public int remove(@Nullable Object object, int n2) {
        CollectPreconditions.checkNonnegative(n2, "occurrences");
        if (n2 == 0) {
            return this.count(object);
        }
        if (!this.contains(object)) return 0;
        int n3 = this.unfiltered.remove(object, n2);
        return n3;
    }

    @Override
    public void clear() {
        this.elementSet().clear();
    }
}

