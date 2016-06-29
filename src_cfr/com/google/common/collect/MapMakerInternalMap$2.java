/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators;
import java.util.AbstractQueue;
import java.util.Iterator;

final class MapMakerInternalMap$2
extends AbstractQueue {
    MapMakerInternalMap$2() {
    }

    @Override
    public boolean offer(Object object) {
        return true;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return Iterators.emptyIterator();
    }
}

