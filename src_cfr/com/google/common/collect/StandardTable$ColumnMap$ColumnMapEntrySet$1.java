/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$ColumnMap;
import com.google.common.collect.StandardTable$ColumnMap$ColumnMapEntrySet;
import java.util.Map;

class StandardTable$ColumnMap$ColumnMapEntrySet$1
implements Function {
    final /* synthetic */ StandardTable$ColumnMap$ColumnMapEntrySet this$2;

    StandardTable$ColumnMap$ColumnMapEntrySet$1(StandardTable$ColumnMap$ColumnMapEntrySet columnMapEntrySet) {
        this.this$2 = columnMapEntrySet;
    }

    @Override
    public Map apply(Object object) {
        return this.this$2.this$1.this$0.column(object);
    }
}

