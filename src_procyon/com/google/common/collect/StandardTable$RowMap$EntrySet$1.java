package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class StandardTable$RowMap$EntrySet$1 implements Function
{
    final /* synthetic */ StandardTable$RowMap$EntrySet this$2;
    
    StandardTable$RowMap$EntrySet$1(final StandardTable$RowMap$EntrySet this$2) {
        this.this$2 = this$2;
    }
    
    @Override
    public Map apply(final Object o) {
        return this.this$2.this$1.this$0.row(o);
    }
}
