package com.google.common.collect;

import com.google.common.base.*;

final class Tables$TransposeTable$1 implements Function
{
    public Table$Cell apply(final Table$Cell table$Cell) {
        return Tables.immutableCell(table$Cell.getColumnKey(), table$Cell.getRowKey(), table$Cell.getValue());
    }
}
