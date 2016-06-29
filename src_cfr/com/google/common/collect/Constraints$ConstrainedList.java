/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.ForwardingList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

@GwtCompatible
class Constraints$ConstrainedList
extends ForwardingList {
    final List delegate;
    final Constraint constraint;

    Constraints$ConstrainedList(List list, Constraint constraint) {
        this.delegate = (List)Preconditions.checkNotNull(list);
        this.constraint = (Constraint)Preconditions.checkNotNull(constraint);
    }

    @Override
    protected List delegate() {
        return this.delegate;
    }

    @Override
    public boolean add(Object object) {
        this.constraint.checkElement(object);
        return this.delegate.add(object);
    }

    @Override
    public void add(int n2, Object object) {
        this.constraint.checkElement(object);
        this.delegate.add(n2, object);
    }

    @Override
    public boolean addAll(Collection collection) {
        return this.delegate.addAll(Constraints.access$000(collection, this.constraint));
    }

    @Override
    public boolean addAll(int n2, Collection collection) {
        return this.delegate.addAll(n2, Constraints.access$000(collection, this.constraint));
    }

    @Override
    public ListIterator listIterator() {
        return Constraints.access$100(this.delegate.listIterator(), this.constraint);
    }

    @Override
    public ListIterator listIterator(int n2) {
        return Constraints.access$100(this.delegate.listIterator(n2), this.constraint);
    }

    @Override
    public Object set(int n2, Object object) {
        this.constraint.checkElement(object);
        return this.delegate.set(n2, object);
    }

    @Override
    public List subList(int n2, int n3) {
        return Constraints.constrainedList(this.delegate.subList(n2, n3), this.constraint);
    }
}

