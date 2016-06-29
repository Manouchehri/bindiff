/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$ColumnMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class StandardTable$ColumnMap$ColumnMapValues
extends Maps$Values {
    final /* synthetic */ StandardTable$ColumnMap this$1;

    StandardTable$ColumnMap$ColumnMapValues(StandardTable$ColumnMap standardTable$ColumnMap) {
        this.this$1 = standardTable$ColumnMap;
        super(standardTable$ColumnMap);
    }

    @Override
    public boolean remove(Object object) {
        Map.Entry entry;
        Iterator iterator = this.this$1.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!((Map)(entry = (Map.Entry)iterator.next()).getValue()).equals(object));
        StandardTable.access$900(this.this$1.this$0, entry.getKey());
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        Preconditions.checkNotNull(collection);
        boolean bl2 = false;
        Iterator iterator = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (!collection.contains(this.this$1.this$0.column(e2))) continue;
            StandardTable.access$900(this.this$1.this$0, e2);
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public boolean retainAll(Collection collection) {
        Preconditions.checkNotNull(collection);
        boolean bl2 = false;
        Iterator iterator = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (collection.contains(this.this$1.this$0.column(e2))) continue;
            StandardTable.access$900(this.this$1.this$0, e2);
            bl2 = true;
        }
        return bl2;
    }
}

