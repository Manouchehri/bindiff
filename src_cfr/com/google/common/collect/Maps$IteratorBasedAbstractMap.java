/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.Maps$IteratorBasedAbstractMap$1;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Set;

abstract class Maps$IteratorBasedAbstractMap
extends AbstractMap {
    Maps$IteratorBasedAbstractMap() {
    }

    @Override
    public abstract int size();

    abstract Iterator entryIterator();

    @Override
    public Set entrySet() {
        return new Maps$IteratorBasedAbstractMap$1(this);
    }

    @Override
    public void clear() {
        Iterators.clear(this.entryIterator());
    }
}

