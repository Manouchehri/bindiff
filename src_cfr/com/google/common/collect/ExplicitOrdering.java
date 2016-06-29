/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Ordering$IncomparableValueException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
final class ExplicitOrdering
extends Ordering
implements Serializable {
    final ImmutableMap rankMap;
    private static final long serialVersionUID = 0;

    ExplicitOrdering(List list) {
        this(Maps.indexMap(list));
    }

    ExplicitOrdering(ImmutableMap immutableMap) {
        this.rankMap = immutableMap;
    }

    @Override
    public int compare(Object object, Object object2) {
        return this.rank(object) - this.rank(object2);
    }

    private int rank(Object object) {
        Integer n2 = (Integer)this.rankMap.get(object);
        if (n2 != null) return n2;
        throw new Ordering$IncomparableValueException(object);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof ExplicitOrdering)) return false;
        ExplicitOrdering explicitOrdering = (ExplicitOrdering)object;
        return this.rankMap.equals(explicitOrdering.rankMap);
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.rankMap.keySet());
        return new StringBuilder(19 + String.valueOf(string).length()).append("Ordering.explicit(").append(string).append(")").toString();
    }
}

