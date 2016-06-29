/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.j2objc.annotations.Weak;
import java.util.Iterator;
import java.util.Map;

final class ImmutableMapEntrySet$RegularEntrySet
extends ImmutableMapEntrySet {
    @Weak
    private final transient ImmutableMap map;
    private final transient Map.Entry[] entries;

    ImmutableMapEntrySet$RegularEntrySet(ImmutableMap immutableMap, Map.Entry[] arrentry) {
        this.map = immutableMap;
        this.entries = arrentry;
    }

    @Override
    ImmutableMap map() {
        return this.map;
    }

    @Override
    public UnmodifiableIterator iterator() {
        return this.asList().iterator();
    }

    @Override
    ImmutableList createAsList() {
        return new RegularImmutableAsList((ImmutableCollection)this, this.entries);
    }
}

