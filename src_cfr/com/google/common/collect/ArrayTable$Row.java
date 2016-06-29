/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$ArrayMap;
import com.google.common.collect.ImmutableMap;

class ArrayTable$Row
extends ArrayTable$ArrayMap {
    final int rowIndex;
    final /* synthetic */ ArrayTable this$0;

    ArrayTable$Row(ArrayTable arrayTable, int n2) {
        this.this$0 = arrayTable;
        super(ArrayTable.access$500(arrayTable), null);
        this.rowIndex = n2;
    }

    @Override
    String getKeyRole() {
        return "Column";
    }

    @Override
    Object getValue(int n2) {
        return this.this$0.at(this.rowIndex, n2);
    }

    @Override
    Object setValue(int n2, Object object) {
        return this.this$0.set(this.rowIndex, n2, object);
    }
}

