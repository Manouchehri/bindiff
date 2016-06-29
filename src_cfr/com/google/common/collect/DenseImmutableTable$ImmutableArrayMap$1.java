/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;

class DenseImmutableTable$ImmutableArrayMap$1
extends AbstractIterator {
    private int index;
    private final int maxIndex;
    final /* synthetic */ DenseImmutableTable$ImmutableArrayMap this$0;

    DenseImmutableTable$ImmutableArrayMap$1(DenseImmutableTable$ImmutableArrayMap denseImmutableTable$ImmutableArrayMap) {
        this.this$0 = denseImmutableTable$ImmutableArrayMap;
        this.index = -1;
        this.maxIndex = this.this$0.keyToIndex().size();
    }

    @Override
    protected Map.Entry computeNext() {
        ++this.index;
        while (this.index < this.maxIndex) {
            Object object = this.this$0.getValue(this.index);
            if (object != null) {
                return Maps.immutableEntry(this.this$0.getKey(this.index), object);
            }
            ++this.index;
        }
        return (Map.Entry)this.endOfData();
    }
}

