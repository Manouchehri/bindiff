/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingSetMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedSetMultimap
extends ForwardingSetMultimap
implements SortedSetMultimap {
    protected ForwardingSortedSetMultimap() {
    }

    @Override
    protected abstract SortedSetMultimap delegate();

    @Override
    public SortedSet get(@Nullable Object object) {
        return this.delegate().get(object);
    }

    @Override
    public SortedSet removeAll(@Nullable Object object) {
        return this.delegate().removeAll(object);
    }

    @Override
    public SortedSet replaceValues(Object object, Iterable iterable) {
        return this.delegate().replaceValues(object, iterable);
    }

    @Override
    public Comparator valueComparator() {
        return this.delegate().valueComparator();
    }
}

