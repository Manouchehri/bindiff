/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$Column;
import com.google.common.collect.StandardTable$Column$EntrySetIterator$1EntryImpl;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class StandardTable$Column$EntrySetIterator
extends AbstractIterator {
    final Iterator iterator;
    final /* synthetic */ StandardTable$Column this$1;

    private StandardTable$Column$EntrySetIterator(StandardTable$Column standardTable$Column) {
        this.this$1 = standardTable$Column;
        this.iterator = this.this$1.this$0.backingMap.entrySet().iterator();
    }

    @Override
    protected Map.Entry computeNext() {
        Map.Entry entry;
        do {
            if (!this.iterator.hasNext()) return (Map.Entry)this.endOfData();
        } while (!((Map)(entry = (Map.Entry)this.iterator.next()).getValue()).containsKey(this.this$1.columnKey));
        return new StandardTable$Column$EntrySetIterator$1EntryImpl(this, entry);
    }

    /* synthetic */ StandardTable$Column$EntrySetIterator(StandardTable$Column standardTable$Column, StandardTable$1 standardTable$1) {
        this(standardTable$Column);
    }
}

