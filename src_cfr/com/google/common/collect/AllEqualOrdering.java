/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
final class AllEqualOrdering
extends Ordering
implements Serializable {
    static final AllEqualOrdering INSTANCE = new AllEqualOrdering();
    private static final long serialVersionUID = 0;

    AllEqualOrdering() {
    }

    @Override
    public int compare(@Nullable Object object, @Nullable Object object2) {
        return 0;
    }

    @Override
    public List sortedCopy(Iterable iterable) {
        return Lists.newArrayList(iterable);
    }

    @Override
    public ImmutableList immutableSortedCopy(Iterable iterable) {
        return ImmutableList.copyOf(iterable);
    }

    @Override
    public Ordering reverse() {
        return this;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "Ordering.allEqual()";
    }
}

