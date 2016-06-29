/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$EntrySetView;
import com.google.common.collect.CompactLinkedHashMap;
import com.google.common.collect.CompactLinkedHashMap$1EntrySetImpl$1;
import java.util.Iterator;

class CompactLinkedHashMap$1EntrySetImpl
extends CompactHashMap$EntrySetView {
    final /* synthetic */ CompactLinkedHashMap this$0;

    CompactLinkedHashMap$1EntrySetImpl(CompactLinkedHashMap compactLinkedHashMap) {
        this.this$0 = compactLinkedHashMap;
        super(compactLinkedHashMap);
    }

    @Override
    public Iterator iterator() {
        return new CompactLinkedHashMap$1EntrySetImpl$1(this);
    }
}

