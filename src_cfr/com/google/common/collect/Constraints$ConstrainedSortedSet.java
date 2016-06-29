/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.ForwardingSortedSet;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;

class Constraints$ConstrainedSortedSet
extends ForwardingSortedSet {
    final SortedSet delegate;
    final Constraint constraint;

    Constraints$ConstrainedSortedSet(SortedSet sortedSet, Constraint constraint) {
        this.delegate = (SortedSet)Preconditions.checkNotNull(sortedSet);
        this.constraint = (Constraint)Preconditions.checkNotNull(constraint);
    }

    @Override
    protected SortedSet delegate() {
        return this.delegate;
    }

    @Override
    public SortedSet headSet(Object object) {
        return Constraints.constrainedSortedSet(this.delegate.headSet(object), this.constraint);
    }

    @Override
    public SortedSet subSet(Object object, Object object2) {
        return Constraints.constrainedSortedSet(this.delegate.subSet(object, object2), this.constraint);
    }

    @Override
    public SortedSet tailSet(Object object) {
        return Constraints.constrainedSortedSet(this.delegate.tailSet(object), this.constraint);
    }

    @Override
    public boolean add(Object object) {
        this.constraint.checkElement(object);
        return this.delegate.add(object);
    }

    @Override
    public boolean addAll(Collection collection) {
        return this.delegate.addAll(Constraints.access$000(collection, this.constraint));
    }
}

