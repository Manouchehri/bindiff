/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;

class ImmutableMap$1
extends UnmodifiableIterator {
    final /* synthetic */ UnmodifiableIterator val$entryIterator;
    final /* synthetic */ ImmutableMap this$0;

    ImmutableMap$1(ImmutableMap immutableMap, UnmodifiableIterator unmodifiableIterator) {
        this.this$0 = immutableMap;
        this.val$entryIterator = unmodifiableIterator;
    }

    @Override
    public boolean hasNext() {
        return this.val$entryIterator.hasNext();
    }

    public Object next() {
        return ((Map.Entry)this.val$entryIterator.next()).getKey();
    }
}

