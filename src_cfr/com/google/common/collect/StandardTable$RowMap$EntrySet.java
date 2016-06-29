/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$RowMap;
import com.google.common.collect.StandardTable$RowMap$EntrySet$1;
import com.google.common.collect.StandardTable$TableSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class StandardTable$RowMap$EntrySet
extends StandardTable$TableSet {
    final /* synthetic */ StandardTable$RowMap this$1;

    StandardTable$RowMap$EntrySet(StandardTable$RowMap standardTable$RowMap) {
        this.this$1 = standardTable$RowMap;
        super(standardTable$RowMap.this$0, null);
    }

    @Override
    public Iterator iterator() {
        return Maps.asMapEntryIterator(this.this$1.this$0.backingMap.keySet(), new StandardTable$RowMap$EntrySet$1(this));
    }

    @Override
    public int size() {
        return this.this$1.this$0.backingMap.size();
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        if (entry.getKey() == null) return false;
        if (!(entry.getValue() instanceof Map)) return false;
        if (!Collections2.safeContains(this.this$1.this$0.backingMap.entrySet(), entry)) return false;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        if (entry.getKey() == null) return false;
        if (!(entry.getValue() instanceof Map)) return false;
        if (!this.this$1.this$0.backingMap.entrySet().remove(entry)) return false;
        return true;
    }
}

