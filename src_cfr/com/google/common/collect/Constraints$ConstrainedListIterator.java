/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Constraint;
import com.google.common.collect.ForwardingListIterator;
import java.util.Iterator;
import java.util.ListIterator;

class Constraints$ConstrainedListIterator
extends ForwardingListIterator {
    private final ListIterator delegate;
    private final Constraint constraint;

    public Constraints$ConstrainedListIterator(ListIterator listIterator, Constraint constraint) {
        this.delegate = listIterator;
        this.constraint = constraint;
    }

    @Override
    protected ListIterator delegate() {
        return this.delegate;
    }

    @Override
    public void add(Object object) {
        this.constraint.checkElement(object);
        this.delegate.add(object);
    }

    @Override
    public void set(Object object) {
        this.constraint.checkElement(object);
        this.delegate.set(object);
    }
}

