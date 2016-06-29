/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.DenseImmutableTable$1;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.DenseImmutableTable$Row;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

final class DenseImmutableTable$RowMap
extends DenseImmutableTable$ImmutableArrayMap {
    final /* synthetic */ DenseImmutableTable this$0;

    private DenseImmutableTable$RowMap(DenseImmutableTable denseImmutableTable) {
        this.this$0 = denseImmutableTable;
        super(DenseImmutableTable.access$200(denseImmutableTable).length);
    }

    @Override
    ImmutableMap keyToIndex() {
        return DenseImmutableTable.access$600(this.this$0);
    }

    @Override
    Map getValue(int n2) {
        return new DenseImmutableTable$Row(this.this$0, n2);
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    /* synthetic */ DenseImmutableTable$RowMap(DenseImmutableTable denseImmutableTable, DenseImmutableTable$1 denseImmutableTable$1) {
        this(denseImmutableTable);
    }
}

