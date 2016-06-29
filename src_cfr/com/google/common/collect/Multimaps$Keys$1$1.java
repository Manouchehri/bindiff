/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multimaps$Keys;
import com.google.common.collect.Multimaps$Keys$1;
import com.google.common.collect.Multisets$AbstractEntry;
import java.util.Collection;
import java.util.Map;

class Multimaps$Keys$1$1
extends Multisets$AbstractEntry {
    final /* synthetic */ Map.Entry val$backingEntry;
    final /* synthetic */ Multimaps$Keys.1 this$1;

    Multimaps$Keys$1$1(Multimaps$Keys.1 var1_1, Map.Entry entry) {
        this.this$1 = var1_1;
        this.val$backingEntry = entry;
    }

    @Override
    public Object getElement() {
        return this.val$backingEntry.getKey();
    }

    @Override
    public int getCount() {
        return ((Collection)this.val$backingEntry.getValue()).size();
    }
}

