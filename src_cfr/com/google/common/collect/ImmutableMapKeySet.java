/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapKeySet$KeySetSerializedForm;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Indexed;
import com.google.common.collect.UnmodifiableIterator;
import com.google.j2objc.annotations.Weak;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
final class ImmutableMapKeySet
extends ImmutableSet$Indexed {
    @Weak
    private final ImmutableMap map;

    ImmutableMapKeySet(ImmutableMap immutableMap) {
        this.map = immutableMap;
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public UnmodifiableIterator iterator() {
        return this.map.keyIterator();
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.map.containsKey(object);
    }

    @Override
    Object get(int n2) {
        return ((Map.Entry)this.map.entrySet().asList().get(n2)).getKey();
    }

    @Override
    boolean isPartialView() {
        return true;
    }

    @GwtIncompatible(value="serialization")
    @Override
    Object writeReplace() {
        return new ImmutableMapKeySet$KeySetSerializedForm(this.map);
    }
}

