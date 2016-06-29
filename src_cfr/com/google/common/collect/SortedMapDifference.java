/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.MapDifference;
import java.util.Map;
import java.util.SortedMap;

@GwtCompatible
public interface SortedMapDifference
extends MapDifference {
    @Override
    public SortedMap entriesOnlyOnLeft();

    @Override
    public SortedMap entriesOnlyOnRight();

    @Override
    public SortedMap entriesInCommon();

    @Override
    public SortedMap entriesDiffering();
}

