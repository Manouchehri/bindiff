/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$RowMap;
import com.google.common.collect.StandardTable$RowMap$EntrySet;
import java.util.Map;

class StandardTable$RowMap$EntrySet$1
implements Function {
    final /* synthetic */ StandardTable$RowMap$EntrySet this$2;

    StandardTable$RowMap$EntrySet$1(StandardTable$RowMap$EntrySet entrySet) {
        this.this$2 = entrySet;
    }

    @Override
    public Map apply(Object object) {
        return this.this$2.this$1.this$0.row(object);
    }
}

