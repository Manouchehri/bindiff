/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
final class NullsLastOrdering
extends Ordering
implements Serializable {
    final Ordering ordering;
    private static final long serialVersionUID = 0;

    NullsLastOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    @Override
    public int compare(@Nullable Object object, @Nullable Object object2) {
        if (object == object2) {
            return 0;
        }
        if (object == null) {
            return 1;
        }
        if (object2 != null) return this.ordering.compare(object, object2);
        return -1;
    }

    @Override
    public Ordering reverse() {
        return this.ordering.reverse().nullsFirst();
    }

    @Override
    public Ordering nullsFirst() {
        return this.ordering.nullsFirst();
    }

    @Override
    public Ordering nullsLast() {
        return this;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof NullsLastOrdering)) return false;
        NullsLastOrdering nullsLastOrdering = (NullsLastOrdering)object;
        return this.ordering.equals(nullsLastOrdering.ordering);
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ -921210296;
    }

    public String toString() {
        String string = String.valueOf(this.ordering);
        return new StringBuilder(12 + String.valueOf(string).length()).append(string).append(".nullsLast()").toString();
    }
}

