/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$1;
import com.google.common.collect.CompactHashMap$EntrySetView;
import com.google.common.collect.CompactHashMap$Itr;
import com.google.common.collect.CompactHashMap$MapEntry;
import java.util.Map;

class CompactHashMap$EntrySetView$1
extends CompactHashMap$Itr {
    final /* synthetic */ CompactHashMap$EntrySetView this$1;

    CompactHashMap$EntrySetView$1(CompactHashMap$EntrySetView compactHashMap$EntrySetView) {
        this.this$1 = compactHashMap$EntrySetView;
        super(compactHashMap$EntrySetView.this$0, null);
    }

    @Override
    Map.Entry getOutput(int n2) {
        return new CompactHashMap$MapEntry(this.this$1.this$0, n2);
    }
}

