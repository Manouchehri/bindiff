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
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
final class LexicographicalOrdering
extends Ordering
implements Serializable {
    final Ordering elementOrder;
    private static final long serialVersionUID = 0;

    LexicographicalOrdering(Ordering ordering) {
        this.elementOrder = ordering;
    }

    public int compare(Iterable iterable, Iterable iterable2) {
        int n2;
        Iterator iterator = iterable.iterator();
        Iterator iterator2 = iterable2.iterator();
        do {
            if (!iterator.hasNext()) {
                if (!iterator2.hasNext()) return 0;
                return -1;
            }
            if (iterator2.hasNext()) continue;
            return 1;
        } while ((n2 = this.elementOrder.compare(iterator.next(), iterator2.next())) == 0);
        return n2;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LexicographicalOrdering)) return false;
        LexicographicalOrdering lexicographicalOrdering = (LexicographicalOrdering)object;
        return this.elementOrder.equals(lexicographicalOrdering.elementOrder);
    }

    public int hashCode() {
        return this.elementOrder.hashCode() ^ 2075626741;
    }

    public String toString() {
        String string = String.valueOf(this.elementOrder);
        return new StringBuilder(18 + String.valueOf(string).length()).append(string).append(".lexicographical()").toString();
    }
}

