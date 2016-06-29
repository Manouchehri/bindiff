/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$RowMap$EntrySet;
import java.util.Map;
import java.util.Set;

class StandardTable$RowMap
extends Maps$ViewCachingAbstractMap {
    final /* synthetic */ StandardTable this$0;

    StandardTable$RowMap(StandardTable standardTable) {
        this.this$0 = standardTable;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.this$0.containsRow(object);
    }

    @Override
    public Map get(Object object) {
        if (!this.this$0.containsRow(object)) return null;
        Map map = this.this$0.row(object);
        return map;
    }

    @Override
    public Map remove(Object object) {
        if (object == null) {
            return null;
        }
        Map map = (Map)this.this$0.backingMap.remove(object);
        return map;
    }

    @Override
    protected Set createEntrySet() {
        return new StandardTable$RowMap$EntrySet(this);
    }
}

