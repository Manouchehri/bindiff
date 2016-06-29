/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.StandardTable$Column;
import com.google.common.collect.StandardTable$Column$EntrySetIterator;
import java.util.Map;

class StandardTable$Column$EntrySetIterator$1EntryImpl
extends AbstractMapEntry {
    final /* synthetic */ Map.Entry val$entry;
    final /* synthetic */ StandardTable$Column$EntrySetIterator this$2;

    StandardTable$Column$EntrySetIterator$1EntryImpl(StandardTable$Column$EntrySetIterator standardTable$Column$EntrySetIterator, Map.Entry entry) {
        this.this$2 = standardTable$Column$EntrySetIterator;
        this.val$entry = entry;
    }

    @Override
    public Object getKey() {
        return this.val$entry.getKey();
    }

    @Override
    public Object getValue() {
        return ((Map)this.val$entry.getValue()).get(this.this$2.this$1.columnKey);
    }

    @Override
    public Object setValue(Object object) {
        return ((Map)this.val$entry.getValue()).put(this.this$2.this$1.columnKey, Preconditions.checkNotNull(object));
    }
}

