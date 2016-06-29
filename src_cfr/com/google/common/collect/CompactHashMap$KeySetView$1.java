/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$1;
import com.google.common.collect.CompactHashMap$Itr;
import com.google.common.collect.CompactHashMap$KeySetView;

class CompactHashMap$KeySetView$1
extends CompactHashMap$Itr {
    final /* synthetic */ CompactHashMap$KeySetView this$1;

    CompactHashMap$KeySetView$1(CompactHashMap$KeySetView compactHashMap$KeySetView) {
        this.this$1 = compactHashMap$KeySetView;
        super(compactHashMap$KeySetView.this$0, null);
    }

    @Override
    Object getOutput(int n2) {
        return this.this$1.this$0.keys[n2];
    }
}

