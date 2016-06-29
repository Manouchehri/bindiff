/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.ImmutableMap;

final class DenseImmutableTable$Column
extends DenseImmutableTable$ImmutableArrayMap {
    private final int columnIndex;
    final /* synthetic */ DenseImmutableTable this$0;

    DenseImmutableTable$Column(DenseImmutableTable denseImmutableTable, int n2) {
        this.this$0 = denseImmutableTable;
        super(DenseImmutableTable.access$500(denseImmutableTable)[n2]);
        this.columnIndex = n2;
    }

    @Override
    ImmutableMap keyToIndex() {
        return DenseImmutableTable.access$600(this.this$0);
    }

    @Override
    Object getValue(int n2) {
        return DenseImmutableTable.access$400(this.this$0)[n2][this.columnIndex];
    }

    @Override
    boolean isPartialView() {
        return true;
    }
}

