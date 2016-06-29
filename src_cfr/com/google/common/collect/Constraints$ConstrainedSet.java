/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.Set;

class Constraints$ConstrainedSet
extends ForwardingSet {
    private final Set delegate;
    private final Constraint constraint;

    public Constraints$ConstrainedSet(Set set, Constraint constraint) {
        this.delegate = (Set)Preconditions.checkNotNull(set);
        this.constraint = (Constraint)Preconditions.checkNotNull(constraint);
    }

    @Override
    protected Set delegate() {
        return this.delegate;
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

