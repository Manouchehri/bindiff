/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$KeySetView;
import com.google.common.collect.CompactLinkedHashMap;
import com.google.common.collect.CompactLinkedHashMap$1KeySetImpl$1;
import com.google.common.collect.ObjectArrays;
import java.util.Iterator;

class CompactLinkedHashMap$1KeySetImpl
extends CompactHashMap$KeySetView {
    final /* synthetic */ CompactLinkedHashMap this$0;

    CompactLinkedHashMap$1KeySetImpl(CompactLinkedHashMap compactLinkedHashMap) {
        this.this$0 = compactLinkedHashMap;
        super(compactLinkedHashMap);
    }

    @Override
    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        return ObjectArrays.toArrayImpl(this, arrobject);
    }

    @Override
    public Iterator iterator() {
        return new CompactLinkedHashMap$1KeySetImpl$1(this);
    }
}

