/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$Column;
import com.google.common.collect.StandardTable$Column$EntrySetIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class StandardTable$Column$EntrySet
extends Sets$ImprovedAbstractSet {
    final /* synthetic */ StandardTable$Column this$1;

    private StandardTable$Column$EntrySet(StandardTable$Column column) {
        this.this$1 = column;
    }

    @Override
    public Iterator iterator() {
        return new StandardTable$Column$EntrySetIterator(this.this$1, null);
    }

    @Override
    public int size() {
        int n2 = 0;
        Iterator iterator = this.this$1.this$0.backingMap.values().iterator();
        while (iterator.hasNext()) {
            Map map = (Map)iterator.next();
            if (!map.containsKey(this.this$1.columnKey)) continue;
            ++n2;
        }
        return n2;
    }

    @Override
    public boolean isEmpty() {
        if (this.this$1.this$0.containsColumn(this.this$1.columnKey)) return false;
        return true;
    }

    @Override
    public void clear() {
        this.this$1.removeFromColumnIf(Predicates.alwaysTrue());
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        return StandardTable.access$300(this.this$1.this$0, entry.getKey(), this.this$1.columnKey, entry.getValue());
    }

    @Override
    public boolean remove(Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        return StandardTable.access$400(this.this$1.this$0, entry.getKey(), this.this$1.columnKey, entry.getValue());
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.this$1.removeFromColumnIf(Predicates.not(Predicates.in(collection)));
    }

    /* synthetic */ StandardTable$Column$EntrySet(StandardTable$Column standardTable$Column, StandardTable$1 standardTable$1) {
        this(standardTable$Column);
    }
}

