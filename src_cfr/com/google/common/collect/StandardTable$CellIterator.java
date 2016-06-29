/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class StandardTable$CellIterator
implements Iterator {
    final Iterator rowIterator;
    Map.Entry rowEntry;
    Iterator columnIterator;
    final /* synthetic */ StandardTable this$0;

    private StandardTable$CellIterator(StandardTable standardTable) {
        this.this$0 = standardTable;
        this.rowIterator = this.this$0.backingMap.entrySet().iterator();
        this.columnIterator = Iterators.emptyModifiableIterator();
    }

    @Override
    public boolean hasNext() {
        if (this.rowIterator.hasNext()) return true;
        if (this.columnIterator.hasNext()) return true;
        return false;
    }

    public Table$Cell next() {
        if (!this.columnIterator.hasNext()) {
            this.rowEntry = (Map.Entry)this.rowIterator.next();
            this.columnIterator = ((Map)this.rowEntry.getValue()).entrySet().iterator();
        }
        Map.Entry entry = (Map.Entry)this.columnIterator.next();
        return Tables.immutableCell(this.rowEntry.getKey(), entry.getKey(), entry.getValue());
    }

    @Override
    public void remove() {
        this.columnIterator.remove();
        if (!((Map)this.rowEntry.getValue()).isEmpty()) return;
        this.rowIterator.remove();
    }

    /* synthetic */ StandardTable$CellIterator(StandardTable standardTable, StandardTable$1 standardTable$1) {
        this(standardTable);
    }
}

