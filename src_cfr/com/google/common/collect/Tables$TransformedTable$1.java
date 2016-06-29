/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;
import com.google.common.collect.Tables$TransformedTable;

class Tables$TransformedTable$1
implements Function {
    final /* synthetic */ Tables$TransformedTable this$0;

    Tables$TransformedTable$1(Tables$TransformedTable transformedTable) {
        this.this$0 = transformedTable;
    }

    public Table$Cell apply(Table$Cell table$Cell) {
        return Tables.immutableCell(table$Cell.getRowKey(), table$Cell.getColumnKey(), this.this$0.function.apply(table$Cell.getValue()));
    }
}

