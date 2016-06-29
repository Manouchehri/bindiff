/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$KeySetView$1;
import com.google.common.collect.Maps$KeySet;
import com.google.common.collect.ObjectArrays;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

class CompactHashMap$KeySetView
extends Maps$KeySet {
    final /* synthetic */ CompactHashMap this$0;

    CompactHashMap$KeySetView(CompactHashMap compactHashMap) {
        this.this$0 = compactHashMap;
        super(compactHashMap);
    }

    @Override
    public Object[] toArray() {
        return ObjectArrays.copyAsObjectArray(this.this$0.keys, 0, CompactHashMap.access$000(this.this$0));
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        return ObjectArrays.toArrayImpl(this.this$0.keys, 0, CompactHashMap.access$000(this.this$0), arrobject);
    }

    @Override
    public boolean remove(@Nullable Object object) {
        int n2 = CompactHashMap.access$200(this.this$0, object);
        if (n2 == -1) {
            return false;
        }
        CompactHashMap.access$100(this.this$0, n2);
        return true;
    }

    @Override
    public Iterator iterator() {
        return new CompactHashMap$KeySetView$1(this);
    }
}

