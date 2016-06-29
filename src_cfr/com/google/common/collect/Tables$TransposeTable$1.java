/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;

final class Tables$TransposeTable$1
implements Function {
    Tables$TransposeTable$1() {
    }

    public Table$Cell apply(Table$Cell table$Cell) {
        return Tables.immutableCell(table$Cell.getColumnKey(), table$Cell.getRowKey(), table$Cell.getValue());
    }
}

