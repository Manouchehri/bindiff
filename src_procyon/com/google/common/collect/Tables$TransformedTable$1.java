package com.google.common.collect;

import com.google.common.base.*;

class Tables$TransformedTable$1 implements Function
{
    final /* synthetic */ Tables$TransformedTable this$0;
    
    Tables$TransformedTable$1(final Tables$TransformedTable this$0) {
        this.this$0 = this$0;
    }
    
    public Table$Cell apply(final Table$Cell table$Cell) {
        return Tables.immutableCell(table$Cell.getRowKey(), table$Cell.getColumnKey(), this.this$0.function.apply(table$Cell.getValue()));
    }
}
