/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Comparator;

@GwtCompatible(serializable=1)
final class CompoundOrdering
extends Ordering
implements Serializable {
    final ImmutableList comparators;
    private static final long serialVersionUID = 0;

    CompoundOrdering(Comparator comparator, Comparator comparator2) {
        this.comparators = ImmutableList.of(comparator, comparator2);
    }

    CompoundOrdering(Iterable iterable) {
        this.comparators = ImmutableList.copyOf(iterable);
    }

    @Override
    public int compare(Object object, Object object2) {
        int n2 = this.comparators.size();
        int n3 = 0;
        while (n3 < n2) {
            int n4 = ((Comparator)this.comparators.get(n3)).compare(object, object2);
            if (n4 != 0) {
                return n4;
            }
            ++n3;
        }
        return 0;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CompoundOrdering)) return false;
        CompoundOrdering compoundOrdering = (CompoundOrdering)object;
        return this.comparators.equals(compoundOrdering.comparators);
    }

    public int hashCode() {
        return this.comparators.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.comparators);
        return new StringBuilder(19 + String.valueOf(string).length()).append("Ordering.compound(").append(string).append(")").toString();
    }
}

