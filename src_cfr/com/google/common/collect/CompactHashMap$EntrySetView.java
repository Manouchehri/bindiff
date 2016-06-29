/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$EntrySetView$1;
import com.google.common.collect.Maps$EntrySet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

class CompactHashMap$EntrySetView
extends Maps$EntrySet {
    final /* synthetic */ CompactHashMap this$0;

    CompactHashMap$EntrySetView(CompactHashMap compactHashMap) {
        this.this$0 = compactHashMap;
    }

    @Override
    Map map() {
        return this.this$0;
    }

    @Override
    public Iterator iterator() {
        return new CompactHashMap$EntrySetView$1(this);
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        int n2 = CompactHashMap.access$200(this.this$0, entry.getKey());
        if (n2 == -1) return false;
        if (!Objects.equal(this.this$0.values[n2], entry.getValue())) return false;
        return true;
    }

    @Override
    public boolean remove(@Nullable Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        int n2 = CompactHashMap.access$200(this.this$0, entry.getKey());
        if (n2 == -1) return false;
        if (!Objects.equal(this.this$0.values[n2], entry.getValue())) return false;
        CompactHashMap.access$100(this.this$0, n2);
        return true;
    }
}

