/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets$SetView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class Sets$1
extends Sets$SetView {
    final /* synthetic */ Set val$set1;
    final /* synthetic */ Set val$set2minus1;
    final /* synthetic */ Set val$set2;

    Sets$1(Set set, Set set2, Set set3) {
        this.val$set1 = set;
        this.val$set2minus1 = set2;
        this.val$set2 = set3;
        super(null);
    }

    @Override
    public int size() {
        return this.val$set1.size() + this.val$set2minus1.size();
    }

    @Override
    public boolean isEmpty() {
        if (!this.val$set1.isEmpty()) return false;
        if (!this.val$set2.isEmpty()) return false;
        return true;
    }

    @Override
    public Iterator iterator() {
        return Iterators.unmodifiableIterator(Iterators.concat(this.val$set1.iterator(), this.val$set2minus1.iterator()));
    }

    @Override
    public boolean contains(Object object) {
        if (this.val$set1.contains(object)) return true;
        if (this.val$set2.contains(object)) return true;
        return false;
    }

    @Override
    public Set copyInto(Set set) {
        set.addAll(this.val$set1);
        set.addAll(this.val$set2);
        return set;
    }

    @Override
    public ImmutableSet immutableCopy() {
        return new ImmutableSet$Builder().addAll(this.val$set1).addAll(this.val$set2).build();
    }
}

