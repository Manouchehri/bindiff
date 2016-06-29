package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class StandardTable$ColumnMap$ColumnMapEntrySet$1 implements Function
{
    final /* synthetic */ StandardTable$ColumnMap$ColumnMapEntrySet this$2;
    
    StandardTable$ColumnMap$ColumnMapEntrySet$1(final StandardTable$ColumnMap$ColumnMapEntrySet this$2) {
        this.this$2 = this$2;
    }
    
    @Override
    public Map apply(final Object o) {
        return this.this$2.this$1.this$0.column(o);
    }
}
