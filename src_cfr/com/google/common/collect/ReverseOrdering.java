/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
final class ReverseOrdering
extends Ordering
implements Serializable {
    final Ordering forwardOrder;
    private static final long serialVersionUID = 0;

    ReverseOrdering(Ordering ordering) {
        this.forwardOrder = (Ordering)Preconditions.checkNotNull(ordering);
    }

    @Override
    public int compare(Object object, Object object2) {
        return this.forwardOrder.compare(object2, object);
    }

    @Override
    public Ordering reverse() {
        return this.forwardOrder;
    }

    @Override
    public Object min(Object object, Object object2) {
        return this.forwardOrder.max(object, object2);
    }

    @Override
    public /* varargs */ Object min(Object object, Object object2, Object object3, Object ... arrobject) {
        return this.forwardOrder.max(object, object2, object3, arrobject);
    }

    @Override
    public Object min(Iterator iterator) {
        return this.forwardOrder.max(iterator);
    }

    @Override
    public Object min(Iterable iterable) {
        return this.forwardOrder.max(iterable);
    }

    @Override
    public Object max(Object object, Object object2) {
        return this.forwardOrder.min(object, object2);
    }

    @Override
    public /* varargs */ Object max(Object object, Object object2, Object object3, Object ... arrobject) {
        return this.forwardOrder.min(object, object2, object3, arrobject);
    }

    @Override
    public Object max(Iterator iterator) {
        return this.forwardOrder.min(iterator);
    }

    @Override
    public Object max(Iterable iterable) {
        return this.forwardOrder.min(iterable);
    }

    public int hashCode() {
        return - this.forwardOrder.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ReverseOrdering)) return false;
        ReverseOrdering reverseOrdering = (ReverseOrdering)object;
        return this.forwardOrder.equals(reverseOrdering.forwardOrder);
    }

    public String toString() {
        String string = String.valueOf(this.forwardOrder);
        return new StringBuilder(10 + String.valueOf(string).length()).append(string).append(".reverse()").toString();
    }
}

