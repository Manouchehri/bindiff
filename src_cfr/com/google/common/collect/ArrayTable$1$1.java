/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.Tables$AbstractCell;

class ArrayTable$1$1
extends Tables$AbstractCell {
    final int rowIndex;
    final int columnIndex;
    final /* synthetic */ int val$index;
    final /* synthetic */ ArrayTable$1 this$1;

    ArrayTable$1$1(ArrayTable$1 arrayTable$1, int n2) {
        this.this$1 = arrayTable$1;
        this.val$index = n2;
        this.rowIndex = this.val$index / ArrayTable.access$000(this.this$1.this$0).size();
        this.columnIndex = this.val$index % ArrayTable.access$000(this.this$1.this$0).size();
    }

    @Override
    public Object getRowKey() {
        return ArrayTable.access$100(this.this$1.this$0).get(this.rowIndex);
    }

    @Override
    public Object getColumnKey() {
        return ArrayTable.access$000(this.this$1.this$0).get(this.columnIndex);
    }

    @Override
    public Object getValue() {
        return this.this$1.this$0.at(this.rowIndex, this.columnIndex);
    }
}

