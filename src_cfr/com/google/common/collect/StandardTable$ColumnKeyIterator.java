/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Supplier;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class StandardTable$ColumnKeyIterator
extends AbstractIterator {
    final Map seen;
    final Iterator mapIterator;
    Iterator entryIterator;
    final /* synthetic */ StandardTable this$0;

    private StandardTable$ColumnKeyIterator(StandardTable standardTable) {
        this.this$0 = standardTable;
        this.seen = (Map)this.this$0.factory.get();
        this.mapIterator = this.this$0.backingMap.values().iterator();
        this.entryIterator = Iterators.emptyIterator();
    }

    @Override
    protected Object computeNext() {
        do {
            if (this.entryIterator.hasNext()) {
                Map.Entry entry = (Map.Entry)this.entryIterator.next();
                if (this.seen.containsKey(entry.getKey())) continue;
                this.seen.put(entry.getKey(), entry.getValue());
                return entry.getKey();
            }
            if (!this.mapIterator.hasNext()) return this.endOfData();
            this.entryIterator = ((Map)this.mapIterator.next()).entrySet().iterator();
        } while (true);
    }

    /* synthetic */ StandardTable$ColumnKeyIterator(StandardTable standardTable, StandardTable$1 standardTable$1) {
        this(standardTable);
    }
}

