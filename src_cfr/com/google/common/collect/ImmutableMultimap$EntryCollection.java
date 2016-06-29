/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.j2objc.annotations.Weak;
import java.util.Iterator;
import java.util.Map;

class ImmutableMultimap$EntryCollection
extends ImmutableCollection {
    @Weak
    final ImmutableMultimap multimap;
    private static final long serialVersionUID = 0;

    ImmutableMultimap$EntryCollection(ImmutableMultimap immutableMultimap) {
        this.multimap = immutableMultimap;
    }

    @Override
    public UnmodifiableIterator iterator() {
        return this.multimap.entryIterator();
    }

    @Override
    boolean isPartialView() {
        return this.multimap.isPartialView();
    }

    @Override
    public int size() {
        return this.multimap.size();
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        return this.multimap.containsEntry(entry.getKey(), entry.getValue());
    }
}

