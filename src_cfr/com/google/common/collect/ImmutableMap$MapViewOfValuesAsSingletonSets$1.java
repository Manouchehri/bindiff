/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets;
import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1$1;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map;

class ImmutableMap$MapViewOfValuesAsSingletonSets$1
extends UnmodifiableIterator {
    final /* synthetic */ Iterator val$backingIterator;
    final /* synthetic */ ImmutableMap$MapViewOfValuesAsSingletonSets this$1;

    ImmutableMap$MapViewOfValuesAsSingletonSets$1(ImmutableMap$MapViewOfValuesAsSingletonSets immutableMap$MapViewOfValuesAsSingletonSets, Iterator iterator) {
        this.this$1 = immutableMap$MapViewOfValuesAsSingletonSets;
        this.val$backingIterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.val$backingIterator.hasNext();
    }

    public Map.Entry next() {
        Map.Entry entry = (Map.Entry)this.val$backingIterator.next();
        return new ImmutableMap$MapViewOfValuesAsSingletonSets$1$1(this, entry);
    }
}

