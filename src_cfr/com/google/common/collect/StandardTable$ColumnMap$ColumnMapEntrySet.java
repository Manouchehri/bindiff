/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$ColumnMap;
import com.google.common.collect.StandardTable$ColumnMap$ColumnMapEntrySet$1;
import com.google.common.collect.StandardTable$TableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class StandardTable$ColumnMap$ColumnMapEntrySet
extends StandardTable$TableSet {
    final /* synthetic */ StandardTable$ColumnMap this$1;

    StandardTable$ColumnMap$ColumnMapEntrySet(StandardTable$ColumnMap standardTable$ColumnMap) {
        this.this$1 = standardTable$ColumnMap;
        super(standardTable$ColumnMap.this$0, null);
    }

    @Override
    public Iterator iterator() {
        return Maps.asMapEntryIterator(this.this$1.this$0.columnKeySet(), new StandardTable$ColumnMap$ColumnMapEntrySet$1(this));
    }

    @Override
    public int size() {
        return this.this$1.this$0.columnKeySet().size();
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        if (!this.this$1.this$0.containsColumn(entry.getKey())) return false;
        Object k2 = entry.getKey();
        return this.this$1.get(k2).equals(entry.getValue());
    }

    @Override
    public boolean remove(Object object) {
        if (!this.contains(object)) return false;
        Map.Entry entry = (Map.Entry)object;
        StandardTable.access$900(this.this$1.this$0, entry.getKey());
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        Preconditions.checkNotNull(collection);
        return Sets.removeAllImpl((Set)this, collection.iterator());
    }

    @Override
    public boolean retainAll(Collection collection) {
        Preconditions.checkNotNull(collection);
        boolean bl2 = false;
        Iterator iterator = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (collection.contains(Maps.immutableEntry(e2, this.this$1.this$0.column(e2)))) continue;
            StandardTable.access$900(this.this$1.this$0, e2);
            bl2 = true;
        }
        return bl2;
    }
}

