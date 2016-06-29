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
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
final class ComparatorOrdering
extends Ordering
implements Serializable {
    final Comparator comparator;
    private static final long serialVersionUID = 0;

    ComparatorOrdering(Comparator comparator) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }

    @Override
    public int compare(Object object, Object object2) {
        return this.comparator.compare(object, object2);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ComparatorOrdering)) return false;
        ComparatorOrdering comparatorOrdering = (ComparatorOrdering)object;
        return this.comparator.equals(comparatorOrdering.comparator);
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}

