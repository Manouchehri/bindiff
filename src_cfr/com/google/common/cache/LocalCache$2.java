/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractQueue;
import java.util.Iterator;

final class LocalCache$2
extends AbstractQueue {
    LocalCache$2() {
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
        return ImmutableSet.of().iterator();
    }
}

