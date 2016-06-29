/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.ImmutableRangeMap$Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Map;

class ImmutableRangeMap$SerializedForm
implements Serializable {
    private final ImmutableMap mapOfRanges;
    private static final long serialVersionUID = 0;

    ImmutableRangeMap$SerializedForm(ImmutableMap immutableMap) {
        this.mapOfRanges = immutableMap;
    }

    Object readResolve() {
        if (!this.mapOfRanges.isEmpty()) return this.createRangeMap();
        return ImmutableRangeMap.of();
    }

    Object createRangeMap() {
        ImmutableRangeMap$Builder immutableRangeMap$Builder = new ImmutableRangeMap$Builder();
        UnmodifiableIterator unmodifiableIterator = this.mapOfRanges.entrySet().iterator();
        while (unmodifiableIterator.hasNext()) {
            Map.Entry entry = (Map.Entry)unmodifiableIterator.next();
            immutableRangeMap$Builder.put((Range)entry.getKey(), entry.getValue());
        }
        return immutableRangeMap$Builder.build();
    }
}

