/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.j2objc.annotations.Weak;
import java.util.Iterator;
import javax.annotation.Nullable;

final class ImmutableMultimap$Values
extends ImmutableCollection {
    @Weak
    private final transient ImmutableMultimap multimap;
    private static final long serialVersionUID = 0;

    ImmutableMultimap$Values(ImmutableMultimap immutableMultimap) {
        this.multimap = immutableMultimap;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.multimap.containsValue(object);
    }

    @Override
    public UnmodifiableIterator iterator() {
        return this.multimap.valueIterator();
    }

    @GwtIncompatible(value="not present in emulated superclass")
    @Override
    int copyIntoArray(Object[] arrobject, int n2) {
        UnmodifiableIterator unmodifiableIterator = this.multimap.map.values().iterator();
        while (unmodifiableIterator.hasNext()) {
            ImmutableCollection immutableCollection = (ImmutableCollection)unmodifiableIterator.next();
            n2 = immutableCollection.copyIntoArray(arrobject, n2);
        }
        return n2;
    }

    @Override
    public int size() {
        return this.multimap.size();
    }

    @Override
    boolean isPartialView() {
        return true;
    }
}

