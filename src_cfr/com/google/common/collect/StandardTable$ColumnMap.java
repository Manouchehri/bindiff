/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$ColumnMap$ColumnMapEntrySet;
import com.google.common.collect.StandardTable$ColumnMap$ColumnMapValues;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class StandardTable$ColumnMap
extends Maps$ViewCachingAbstractMap {
    final /* synthetic */ StandardTable this$0;

    private StandardTable$ColumnMap(StandardTable standardTable) {
        this.this$0 = standardTable;
    }

    @Override
    public Map get(Object object) {
        if (!this.this$0.containsColumn(object)) return null;
        Map map = this.this$0.column(object);
        return map;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.this$0.containsColumn(object);
    }

    @Override
    public Map remove(Object object) {
        if (!this.this$0.containsColumn(object)) return null;
        Map map = StandardTable.access$900(this.this$0, object);
        return map;
    }

    @Override
    public Set createEntrySet() {
        return new StandardTable$ColumnMap$ColumnMapEntrySet(this);
    }

    @Override
    public Set keySet() {
        return this.this$0.columnKeySet();
    }

    @Override
    Collection createValues() {
        return new StandardTable$ColumnMap$ColumnMapValues(this);
    }

    /* synthetic */ StandardTable$ColumnMap(StandardTable standardTable, StandardTable$1 standardTable$1) {
        this(standardTable);
    }
}

