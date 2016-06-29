/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

class ConcurrentHashMultiset$2
extends AbstractIterator {
    private Iterator mapEntries;
    final /* synthetic */ ConcurrentHashMultiset this$0;

    ConcurrentHashMultiset$2(ConcurrentHashMultiset concurrentHashMultiset) {
        this.this$0 = concurrentHashMultiset;
        this.mapEntries = ConcurrentHashMultiset.access$100(this.this$0).entrySet().iterator();
    }

    @Override
    protected Multiset$Entry computeNext() {
        int n2;
        Map.Entry entry;
        do {
            if (this.mapEntries.hasNext()) continue;
            return (Multiset$Entry)this.endOfData();
        } while ((n2 = ((AtomicInteger)(entry = (Map.Entry)this.mapEntries.next()).getValue()).get()) == 0);
        return Multisets.immutableEntry(entry.getKey(), n2);
    }
}

