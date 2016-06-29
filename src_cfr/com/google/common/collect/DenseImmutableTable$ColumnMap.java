/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.DenseImmutableTable$1;
import com.google.common.collect.DenseImmutableTable$Column;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

final class DenseImmutableTable$ColumnMap
extends DenseImmutableTable$ImmutableArrayMap {
    final /* synthetic */ DenseImmutableTable this$0;

    private DenseImmutableTable$ColumnMap(DenseImmutableTable denseImmutableTable) {
        this.this$0 = denseImmutableTable;
        super(DenseImmutableTable.access$500(denseImmutableTable).length);
    }

    @Override
    ImmutableMap keyToIndex() {
        return DenseImmutableTable.access$300(this.this$0);
    }

    @Override
    Map getValue(int n2) {
        return new DenseImmutableTable$Column(this.this$0, n2);
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    /* synthetic */ DenseImmutableTable$ColumnMap(DenseImmutableTable denseImmutableTable, DenseImmutableTable$1 denseImmutableTable$1) {
        this(denseImmutableTable);
    }
}

