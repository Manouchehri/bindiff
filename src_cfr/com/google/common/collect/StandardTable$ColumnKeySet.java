/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$TableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class StandardTable$ColumnKeySet
extends StandardTable$TableSet {
    final /* synthetic */ StandardTable this$0;

    private StandardTable$ColumnKeySet(StandardTable standardTable) {
        this.this$0 = standardTable;
        super(standardTable, null);
    }

    @Override
    public Iterator iterator() {
        return this.this$0.createColumnKeyIterator();
    }

    @Override
    public int size() {
        return Iterators.size(this.iterator());
    }

    @Override
    public boolean remove(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = false;
        Iterator iterator = this.this$0.backingMap.values().iterator();
        while (iterator.hasNext()) {
            Map map = (Map)iterator.next();
            if (!map.keySet().remove(object)) continue;
            bl2 = true;
            if (!map.isEmpty()) continue;
            iterator.remove();
        }
        return bl2;
    }

    @Override
    public boolean removeAll(Collection collection) {
        Preconditions.checkNotNull(collection);
        boolean bl2 = false;
        Iterator iterator = this.this$0.backingMap.values().iterator();
        while (iterator.hasNext()) {
            Map map = (Map)iterator.next();
            if (!Iterators.removeAll(map.keySet().iterator(), collection)) continue;
            bl2 = true;
            if (!map.isEmpty()) continue;
            iterator.remove();
        }
        return bl2;
    }

    @Override
    public boolean retainAll(Collection collection) {
        Preconditions.checkNotNull(collection);
        boolean bl2 = false;
        Iterator iterator = this.this$0.backingMap.values().iterator();
        while (iterator.hasNext()) {
            Map map = (Map)iterator.next();
            if (!map.keySet().retainAll(collection)) continue;
            bl2 = true;
            if (!map.isEmpty()) continue;
            iterator.remove();
        }
        return bl2;
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsColumn(object);
    }

    /* synthetic */ StandardTable$ColumnKeySet(StandardTable standardTable, StandardTable$1 standardTable$1) {
        this(standardTable);
    }
}

