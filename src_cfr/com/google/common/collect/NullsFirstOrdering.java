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
final class NullsFirstOrdering
extends Ordering
implements Serializable {
    final Ordering ordering;
    private static final long serialVersionUID = 0;

    NullsFirstOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    @Override
    public int compare(@Nullable Object object, @Nullable Object object2) {
        if (object == object2) {
            return 0;
        }
        if (object == null) {
            return -1;
        }
        if (object2 != null) return this.ordering.compare(object, object2);
        return 1;
    }

    @Override
    public Ordering reverse() {
        return this.ordering.reverse().nullsLast();
    }

    @Override
    public Ordering nullsFirst() {
        return this;
    }

    @Override
    public Ordering nullsLast() {
        return this.ordering.nullsLast();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof NullsFirstOrdering)) return false;
        NullsFirstOrdering nullsFirstOrdering = (NullsFirstOrdering)object;
        return this.ordering.equals(nullsFirstOrdering.ordering);
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ 957692532;
    }

    public String toString() {
        String string = String.valueOf(this.ordering);
        return new StringBuilder(13 + String.valueOf(string).length()).append(string).append(".nullsFirst()").toString();
    }
}

