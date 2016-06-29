/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$ArrayMap$1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

abstract class ArrayTable$ArrayMap
extends Maps$IteratorBasedAbstractMap {
    private final ImmutableMap keyIndex;

    private ArrayTable$ArrayMap(ImmutableMap immutableMap) {
        this.keyIndex = immutableMap;
    }

    @Override
    public Set keySet() {
        return this.keyIndex.keySet();
    }

    Object getKey(int n2) {
        return this.keyIndex.keySet().asList().get(n2);
    }

    abstract String getKeyRole();

    @Nullable
    abstract Object getValue(int var1);

    @Nullable
    abstract Object setValue(int var1, Object var2);

    @Override
    public int size() {
        return this.keyIndex.size();
    }

    @Override
    public boolean isEmpty() {
        return this.keyIndex.isEmpty();
    }

    @Override
    Iterator entryIterator() {
        return new ArrayTable$ArrayMap$1(this, this.size());
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.keyIndex.containsKey(object);
    }

    @Override
    public Object get(@Nullable Object object) {
        Integer n2 = (Integer)this.keyIndex.get(object);
        if (n2 != null) return this.getValue(n2);
        return null;
    }

    @Override
    public Object put(Object object, Object object2) {
        Integer n2 = (Integer)this.keyIndex.get(object);
        if (n2 != null) return this.setValue(n2, object2);
        String string = this.getKeyRole();
        String string2 = String.valueOf(object);
        String string3 = String.valueOf(this.keyIndex.keySet());
        throw new IllegalArgumentException(new StringBuilder(9 + String.valueOf(string).length() + String.valueOf(string2).length() + String.valueOf(string3).length()).append(string).append(" ").append(string2).append(" not in ").append(string3).toString());
    }

    @Override
    public Object remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ ArrayTable$ArrayMap(ImmutableMap immutableMap, ArrayTable$1 arrayTable$1) {
        this(immutableMap);
    }
}

