/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$1;
import com.google.common.collect.CompactHashMap$Itr;
import com.google.common.collect.CompactHashMap$ValuesView;

class CompactHashMap$ValuesView$1
extends CompactHashMap$Itr {
    final /* synthetic */ CompactHashMap$ValuesView this$1;

    CompactHashMap$ValuesView$1(CompactHashMap$ValuesView compactHashMap$ValuesView) {
        this.this$1 = compactHashMap$ValuesView;
        super(compactHashMap$ValuesView.this$0, null);
    }

    @Override
    Object getOutput(int n2) {
        return this.this$1.this$0.values[n2];
    }
}

