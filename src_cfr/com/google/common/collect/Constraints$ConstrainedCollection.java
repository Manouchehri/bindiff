/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.ForwardingCollection;
import java.util.Collection;

class Constraints$ConstrainedCollection
extends ForwardingCollection {
    private final Collection delegate;
    private final Constraint constraint;

    public Constraints$ConstrainedCollection(Collection collection, Constraint constraint) {
        this.delegate = (Collection)Preconditions.checkNotNull(collection);
        this.constraint = (Constraint)Preconditions.checkNotNull(constraint);
    }

    @Override
    protected Collection delegate() {
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

