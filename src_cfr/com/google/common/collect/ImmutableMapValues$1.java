/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMapValues;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;

class ImmutableMapValues$1
extends UnmodifiableIterator {
    final UnmodifiableIterator entryItr;
    final /* synthetic */ ImmutableMapValues this$0;

    ImmutableMapValues$1(ImmutableMapValues immutableMapValues) {
        this.this$0 = immutableMapValues;
        this.entryItr = ImmutableMapValues.access$000(this.this$0).entrySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return this.entryItr.hasNext();
    }

    public Object next() {
        return ((Map.Entry)this.entryItr.next()).getValue();
    }
}

