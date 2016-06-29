/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$ArrayMap;
import com.google.common.collect.ArrayTable$Column;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

class ArrayTable$ColumnMap
extends ArrayTable$ArrayMap {
    final /* synthetic */ ArrayTable this$0;

    private ArrayTable$ColumnMap(ArrayTable arrayTable) {
        this.this$0 = arrayTable;
        super(ArrayTable.access$500(arrayTable), null);
    }

    @Override
    String getKeyRole() {
        return "Column";
    }

    @Override
    Map getValue(int n2) {
        return new ArrayTable$Column(this.this$0, n2);
    }

    Map setValue(int n2, Map map) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map put(Object object, Map map) {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ ArrayTable$ColumnMap(ArrayTable arrayTable, ArrayTable$1 arrayTable$1) {
        this(arrayTable);
    }
}

