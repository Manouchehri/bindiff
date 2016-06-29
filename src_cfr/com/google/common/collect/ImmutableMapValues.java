/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapValues$1;
import com.google.common.collect.ImmutableMapValues$2;
import com.google.common.collect.ImmutableMapValues$SerializedForm;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.j2objc.annotations.Weak;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
final class ImmutableMapValues
extends ImmutableCollection {
    @Weak
    private final ImmutableMap map;

    ImmutableMapValues(ImmutableMap immutableMap) {
        this.map = immutableMap;
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public UnmodifiableIterator iterator() {
        return new ImmutableMapValues$1(this);
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (object == null) return false;
        if (!Iterators.contains(this.iterator(), object)) return false;
        return true;
    }

    @Override
    boolean isPartialView() {
        return true;
    }

    @Override
    ImmutableList createAsList() {
        ImmutableList immutableList = this.map.entrySet().asList();
        return new ImmutableMapValues$2(this, immutableList);
    }

    @GwtIncompatible(value="serialization")
    @Override
    Object writeReplace() {
        return new ImmutableMapValues$SerializedForm(this.map);
    }

    static /* synthetic */ ImmutableMap access$000(ImmutableMapValues immutableMapValues) {
        return immutableMapValues.map;
    }
}

