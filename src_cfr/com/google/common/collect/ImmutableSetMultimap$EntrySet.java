/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.j2objc.annotations.Weak;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

final class ImmutableSetMultimap$EntrySet
extends ImmutableSet {
    @Weak
    private final transient ImmutableSetMultimap multimap;

    ImmutableSetMultimap$EntrySet(ImmutableSetMultimap immutableSetMultimap) {
        this.multimap = immutableSetMultimap;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        return this.multimap.containsEntry(entry.getKey(), entry.getValue());
    }

    @Override
    public int size() {
        return this.multimap.size();
    }

    @Override
    public UnmodifiableIterator iterator() {
        return this.multimap.entryIterator();
    }

    @Override
    boolean isPartialView() {
        return false;
    }
}

