/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.ImmutableMap;

final class DenseImmutableTable$Row
extends DenseImmutableTable$ImmutableArrayMap {
    private final int rowIndex;
    final /* synthetic */ DenseImmutableTable this$0;

    DenseImmutableTable$Row(DenseImmutableTable denseImmutableTable, int n2) {
        this.this$0 = denseImmutableTable;
        super(DenseImmutableTable.access$200(denseImmutableTable)[n2]);
        this.rowIndex = n2;
    }

    @Override
    ImmutableMap keyToIndex() {
        return DenseImmutableTable.access$300(this.this$0);
    }

    @Override
    Object getValue(int n2) {
        return DenseImmutableTable.access$400(this.this$0)[this.rowIndex][n2];
    }

    @Override
    boolean isPartialView() {
        return true;
    }
}

