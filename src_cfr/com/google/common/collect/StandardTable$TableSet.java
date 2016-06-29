/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Sets$ImprovedAbstractSet;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import java.util.Map;

abstract class StandardTable$TableSet
extends Sets$ImprovedAbstractSet {
    final /* synthetic */ StandardTable this$0;

    private StandardTable$TableSet(StandardTable standardTable) {
        this.this$0 = standardTable;
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.backingMap.isEmpty();
    }

    @Override
    public void clear() {
        this.this$0.backingMap.clear();
    }

    /* synthetic */ StandardTable$TableSet(StandardTable standardTable, StandardTable$1 standardTable$1) {
        this(standardTable);
    }
}

