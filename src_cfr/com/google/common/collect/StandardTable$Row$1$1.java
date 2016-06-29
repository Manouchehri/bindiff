/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$Row;
import com.google.common.collect.StandardTable$Row$1;
import java.util.Map;

class StandardTable$Row$1$1
extends ForwardingMapEntry {
    final /* synthetic */ Map.Entry val$entry;
    final /* synthetic */ StandardTable.Row.1 this$2;

    StandardTable$Row$1$1(StandardTable.Row.1 var1_1, Map.Entry entry) {
        this.this$2 = var1_1;
        this.val$entry = entry;
    }

    @Override
    protected Map.Entry delegate() {
        return this.val$entry;
    }

    @Override
    public Object setValue(Object object) {
        return super.setValue(Preconditions.checkNotNull(object));
    }

    @Override
    public boolean equals(Object object) {
        return this.standardEquals(object);
    }
}

