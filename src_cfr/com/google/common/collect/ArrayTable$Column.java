/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$ArrayMap;
import com.google.common.collect.ImmutableMap;

class ArrayTable$Column
extends ArrayTable$ArrayMap {
    final int columnIndex;
    final /* synthetic */ ArrayTable this$0;

    ArrayTable$Column(ArrayTable arrayTable, int n2) {
        this.this$0 = arrayTable;
        super(ArrayTable.access$200(arrayTable), null);
        this.columnIndex = n2;
    }

    @Override
    String getKeyRole() {
        return "Row";
    }

    @Override
    Object getValue(int n2) {
        return this.this$0.at(n2, this.columnIndex);
    }

    @Override
    Object setValue(int n2, Object object) {
        return this.this$0.set(n2, this.columnIndex, object);
    }
}

