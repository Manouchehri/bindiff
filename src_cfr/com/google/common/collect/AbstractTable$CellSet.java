/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractTable;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.Table$Cell;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractTable$CellSet
extends AbstractSet {
    final /* synthetic */ AbstractTable this$0;

    AbstractTable$CellSet(AbstractTable abstractTable) {
        this.this$0 = abstractTable;
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Table$Cell)) return false;
        Table$Cell table$Cell = (Table$Cell)object;
        Map map = (Map)Maps.safeGet(this.this$0.rowMap(), table$Cell.getRowKey());
        if (map == null) return false;
        if (!Collections2.safeContains(map.entrySet(), Maps.immutableEntry(table$Cell.getColumnKey(), table$Cell.getValue()))) return false;
        return true;
    }

    @Override
    public boolean remove(@Nullable Object object) {
        if (!(object instanceof Table$Cell)) return false;
        Table$Cell table$Cell = (Table$Cell)object;
        Map map = (Map)Maps.safeGet(this.this$0.rowMap(), table$Cell.getRowKey());
        if (map == null) return false;
        if (!Collections2.safeRemove(map.entrySet(), Maps.immutableEntry(table$Cell.getColumnKey(), table$Cell.getValue()))) return false;
        return true;
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public Iterator iterator() {
        return this.this$0.cellIterator();
    }

    @Override
    public int size() {
        return this.this$0.size();
    }
}

