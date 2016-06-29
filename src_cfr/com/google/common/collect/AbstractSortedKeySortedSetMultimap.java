/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractSortedSetMultimap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
abstract class AbstractSortedKeySortedSetMultimap
extends AbstractSortedSetMultimap {
    AbstractSortedKeySortedSetMultimap(SortedMap sortedMap) {
        super(sortedMap);
    }

    @Override
    public SortedMap asMap() {
        return (SortedMap)super.asMap();
    }

    @Override
    SortedMap backingMap() {
        return (SortedMap)super.backingMap();
    }

    @Override
    public SortedSet keySet() {
        return (SortedSet)super.keySet();
    }
}

