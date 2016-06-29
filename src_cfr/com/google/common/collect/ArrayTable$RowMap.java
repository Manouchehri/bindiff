/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$ArrayMap;
import com.google.common.collect.ArrayTable$Row;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

class ArrayTable$RowMap
extends ArrayTable$ArrayMap {
    final /* synthetic */ ArrayTable this$0;

    private ArrayTable$RowMap(ArrayTable arrayTable) {
        this.this$0 = arrayTable;
        super(ArrayTable.access$200(arrayTable), null);
    }

    @Override
    String getKeyRole() {
        return "Row";
    }

    @Override
    Map getValue(int n2) {
        return new ArrayTable$Row(this.this$0, n2);
    }

    Map setValue(int n2, Map map) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map put(Object object, Map map) {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ ArrayTable$RowMap(ArrayTable arrayTable, ArrayTable$1 arrayTable$1) {
        this(arrayTable);
    }
}

