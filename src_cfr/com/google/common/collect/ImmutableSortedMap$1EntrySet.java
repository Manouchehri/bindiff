/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap$1EntrySet$1;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

class ImmutableSortedMap$1EntrySet
extends ImmutableMapEntrySet {
    final /* synthetic */ ImmutableSortedMap this$0;

    ImmutableSortedMap$1EntrySet(ImmutableSortedMap immutableSortedMap) {
        this.this$0 = immutableSortedMap;
    }

    @Override
    public UnmodifiableIterator iterator() {
        return this.asList().iterator();
    }

    @Override
    ImmutableList createAsList() {
        return new ImmutableSortedMap$1EntrySet$1(this);
    }

    @Override
    ImmutableMap map() {
        return this.this$0;
    }
}

