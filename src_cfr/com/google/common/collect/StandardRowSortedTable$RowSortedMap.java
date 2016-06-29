/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps$SortedKeySet;
import com.google.common.collect.StandardRowSortedTable;
import com.google.common.collect.StandardRowSortedTable$1;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$RowMap;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

class StandardRowSortedTable$RowSortedMap
extends StandardTable$RowMap
implements SortedMap {
    final /* synthetic */ StandardRowSortedTable this$0;

    private StandardRowSortedTable$RowSortedMap(StandardRowSortedTable standardRowSortedTable) {
        this.this$0 = standardRowSortedTable;
        super(standardRowSortedTable);
    }

    @Override
    public SortedSet keySet() {
        return (SortedSet)super.keySet();
    }

    @Override
    SortedSet createKeySet() {
        return new Maps$SortedKeySet(this);
    }

    public Comparator comparator() {
        return StandardRowSortedTable.access$100(this.this$0).comparator();
    }

    public Object firstKey() {
        return StandardRowSortedTable.access$100(this.this$0).firstKey();
    }

    public Object lastKey() {
        return StandardRowSortedTable.access$100(this.this$0).lastKey();
    }

    public SortedMap headMap(Object object) {
        Preconditions.checkNotNull(object);
        return new StandardRowSortedTable(StandardRowSortedTable.access$100(this.this$0).headMap(object), this.this$0.factory).rowMap();
    }

    public SortedMap subMap(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        return new StandardRowSortedTable(StandardRowSortedTable.access$100(this.this$0).subMap(object, object2), this.this$0.factory).rowMap();
    }

    public SortedMap tailMap(Object object) {
        Preconditions.checkNotNull(object);
        return new StandardRowSortedTable(StandardRowSortedTable.access$100(this.this$0).tailMap(object), this.this$0.factory).rowMap();
    }

    /* synthetic */ StandardRowSortedTable$RowSortedMap(StandardRowSortedTable standardRowSortedTable, StandardRowSortedTable$1 standardRowSortedTable$1) {
        this(standardRowSortedTable);
    }
}

