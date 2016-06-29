/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.SetMultimap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public interface SortedSetMultimap
extends SetMultimap {
    @Override
    public SortedSet get(@Nullable Object var1);

    @Override
    public SortedSet removeAll(@Nullable Object var1);

    @Override
    public SortedSet replaceValues(Object var1, Iterable var2);

    @Override
    public Map asMap();

    public Comparator valueComparator();
}

