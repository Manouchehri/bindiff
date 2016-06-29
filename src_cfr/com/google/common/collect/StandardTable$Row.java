/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$Row$1;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class StandardTable$Row
extends Maps$IteratorBasedAbstractMap {
    final Object rowKey;
    Map backingRowMap;
    final /* synthetic */ StandardTable this$0;

    StandardTable$Row(StandardTable standardTable, Object object) {
        this.this$0 = standardTable;
        this.rowKey = Preconditions.checkNotNull(object);
    }

    Map backingRowMap() {
        Map map;
        if (this.backingRowMap == null || this.backingRowMap.isEmpty() && this.this$0.backingMap.containsKey(this.rowKey)) {
            map = this.backingRowMap = this.computeBackingRowMap();
            return map;
        }
        map = this.backingRowMap;
        return map;
    }

    Map computeBackingRowMap() {
        return (Map)this.this$0.backingMap.get(this.rowKey);
    }

    void maintainEmptyInvariant() {
        if (this.backingRowMap() == null) return;
        if (!this.backingRowMap.isEmpty()) return;
        this.this$0.backingMap.remove(this.rowKey);
        this.backingRowMap = null;
    }

    @Override
    public boolean containsKey(Object object) {
        Map map = this.backingRowMap();
        if (object == null) return false;
        if (map == null) return false;
        if (!Maps.safeContainsKey(map, object)) return false;
        return true;
    }

    @Override
    public Object get(Object object) {
        Map map = this.backingRowMap();
        if (object == null) return null;
        if (map == null) return null;
        Object object2 = Maps.safeGet(map, object);
        return object2;
    }

    @Override
    public Object put(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        if (this.backingRowMap == null) return this.this$0.put(this.rowKey, object, object2);
        if (this.backingRowMap.isEmpty()) return this.this$0.put(this.rowKey, object, object2);
        return this.backingRowMap.put(object, object2);
    }

    @Override
    public Object remove(Object object) {
        Map map = this.backingRowMap();
        if (map == null) {
            return null;
        }
        Object object2 = Maps.safeRemove(map, object);
        this.maintainEmptyInvariant();
        return object2;
    }

    @Override
    public void clear() {
        Map map = this.backingRowMap();
        if (map != null) {
            map.clear();
        }
        this.maintainEmptyInvariant();
    }

    @Override
    public int size() {
        Map map = this.backingRowMap();
        if (map == null) {
            return 0;
        }
        int n2 = map.size();
        return n2;
    }

    @Override
    Iterator entryIterator() {
        Map map = this.backingRowMap();
        if (map == null) {
            return Iterators.emptyModifiableIterator();
        }
        Iterator iterator = map.entrySet().iterator();
        return new StandardTable$Row$1(this, iterator);
    }
}

