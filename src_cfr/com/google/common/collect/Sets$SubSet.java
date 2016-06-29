/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets$SubSet$1;
import java.util.AbstractSet;
import java.util.Iterator;
import javax.annotation.Nullable;

final class Sets$SubSet
extends AbstractSet {
    private final ImmutableMap inputSet;
    private final int mask;

    Sets$SubSet(ImmutableMap immutableMap, int n2) {
        this.inputSet = immutableMap;
        this.mask = n2;
    }

    @Override
    public Iterator iterator() {
        return new Sets$SubSet$1(this);
    }

    @Override
    public int size() {
        return Integer.bitCount(this.mask);
    }

    @Override
    public boolean contains(@Nullable Object object) {
        Integer n2 = (Integer)this.inputSet.get(object);
        if (n2 == null) return false;
        if ((this.mask & 1 << n2) == 0) return false;
        return true;
    }

    static /* synthetic */ ImmutableMap access$100(Sets$SubSet sets$SubSet) {
        return sets$SubSet.inputSet;
    }

    static /* synthetic */ int access$200(Sets$SubSet sets$SubSet) {
        return sets$SubSet.mask;
    }
}

