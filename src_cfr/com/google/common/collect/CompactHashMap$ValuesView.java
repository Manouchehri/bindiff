/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$ValuesView$1;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.ObjectArrays;
import java.util.Iterator;
import java.util.Map;

class CompactHashMap$ValuesView
extends Maps$Values {
    final /* synthetic */ CompactHashMap this$0;

    CompactHashMap$ValuesView(CompactHashMap compactHashMap) {
        this.this$0 = compactHashMap;
        super(compactHashMap);
    }

    @Override
    public Iterator iterator() {
        return new CompactHashMap$ValuesView$1(this);
    }

    @Override
    public Object[] toArray() {
        return ObjectArrays.copyAsObjectArray(this.this$0.values, 0, CompactHashMap.access$000(this.this$0));
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        return ObjectArrays.toArrayImpl(this.this$0.values, 0, CompactHashMap.access$000(this.this$0), arrobject);
    }
}

