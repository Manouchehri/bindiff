/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$MapEntry;
import com.google.common.collect.CompactLinkedHashMap;
import com.google.common.collect.CompactLinkedHashMap$1;
import com.google.common.collect.CompactLinkedHashMap$1EntrySetImpl;
import com.google.common.collect.CompactLinkedHashMap$Itr;
import java.util.Map;

class CompactLinkedHashMap$1EntrySetImpl$1
extends CompactLinkedHashMap$Itr {
    final /* synthetic */ CompactLinkedHashMap$1EntrySetImpl this$1;

    CompactLinkedHashMap$1EntrySetImpl$1(CompactLinkedHashMap$1EntrySetImpl compactLinkedHashMap$1EntrySetImpl) {
        this.this$1 = compactLinkedHashMap$1EntrySetImpl;
        super(compactLinkedHashMap$1EntrySetImpl.this$0, null);
    }

    @Override
    Map.Entry getOutput(int n2) {
        return new CompactHashMap$MapEntry(this.this$1.this$0, n2);
    }
}

