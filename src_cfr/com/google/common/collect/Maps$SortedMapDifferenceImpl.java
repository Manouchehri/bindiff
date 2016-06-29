/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$MapDifferenceImpl;
import com.google.common.collect.SortedMapDifference;
import java.util.Map;
import java.util.SortedMap;

class Maps$SortedMapDifferenceImpl
extends Maps$MapDifferenceImpl
implements SortedMapDifference {
    Maps$SortedMapDifferenceImpl(SortedMap sortedMap, SortedMap sortedMap2, SortedMap sortedMap3, SortedMap sortedMap4) {
        super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
    }

    @Override
    public SortedMap entriesDiffering() {
        return (SortedMap)super.entriesDiffering();
    }

    @Override
    public SortedMap entriesInCommon() {
        return (SortedMap)super.entriesInCommon();
    }

    @Override
    public SortedMap entriesOnlyOnLeft() {
        return (SortedMap)super.entriesOnlyOnLeft();
    }

    @Override
    public SortedMap entriesOnlyOnRight() {
        return (SortedMap)super.entriesOnlyOnRight();
    }
}

