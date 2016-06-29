/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible(serializable=1)
final class ReverseNaturalOrdering
extends Ordering
implements Serializable {
    static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        if (comparable != comparable2) return comparable2.compareTo(comparable);
        return 0;
    }

    @Override
    public Ordering reverse() {
        return Ordering.natural();
    }

    public Comparable min(Comparable comparable, Comparable comparable2) {
        return (Comparable)NaturalOrdering.INSTANCE.max(comparable, comparable2);
    }

    public /* varargs */ Comparable min(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable ... arrcomparable) {
        return (Comparable)NaturalOrdering.INSTANCE.max(comparable, comparable2, comparable3, arrcomparable);
    }

    @Override
    public Comparable min(Iterator iterator) {
        return (Comparable)NaturalOrdering.INSTANCE.max(iterator);
    }

    @Override
    public Comparable min(Iterable iterable) {
        return (Comparable)NaturalOrdering.INSTANCE.max(iterable);
    }

    public Comparable max(Comparable comparable, Comparable comparable2) {
        return (Comparable)NaturalOrdering.INSTANCE.min(comparable, comparable2);
    }

    public /* varargs */ Comparable max(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable ... arrcomparable) {
        return (Comparable)NaturalOrdering.INSTANCE.min(comparable, comparable2, comparable3, arrcomparable);
    }

    @Override
    public Comparable max(Iterator iterator) {
        return (Comparable)NaturalOrdering.INSTANCE.min(iterator);
    }

    @Override
    public Comparable max(Iterable iterable) {
        return (Comparable)NaturalOrdering.INSTANCE.min(iterable);
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    private ReverseNaturalOrdering() {
    }
}

