/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map;

final class Maps$6
extends UnmodifiableIterator {
    final /* synthetic */ Iterator val$entryIterator;

    Maps$6(Iterator iterator) {
        this.val$entryIterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.val$entryIterator.hasNext();
    }

    public Map.Entry next() {
        return Maps.unmodifiableEntry((Map.Entry)this.val$entryIterator.next());
    }
}

