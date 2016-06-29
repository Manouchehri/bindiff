/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSet$Indexed;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.RegularImmutableTable$1;
import com.google.common.collect.Table$Cell;
import javax.annotation.Nullable;

final class RegularImmutableTable$CellSet
extends ImmutableSet$Indexed {
    final /* synthetic */ RegularImmutableTable this$0;

    private RegularImmutableTable$CellSet(RegularImmutableTable regularImmutableTable) {
        this.this$0 = regularImmutableTable;
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    Table$Cell get(int n2) {
        return this.this$0.getCell(n2);
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (!(object instanceof Table$Cell)) return false;
        Table$Cell table$Cell = (Table$Cell)object;
        Object object2 = this.this$0.get(table$Cell.getRowKey(), table$Cell.getColumnKey());
        if (object2 == null) return false;
        if (!object2.equals(table$Cell.getValue())) return false;
        return true;
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    /* synthetic */ RegularImmutableTable$CellSet(RegularImmutableTable regularImmutableTable, RegularImmutableTable$1 regularImmutableTable$1) {
        this(regularImmutableTable);
    }
}

