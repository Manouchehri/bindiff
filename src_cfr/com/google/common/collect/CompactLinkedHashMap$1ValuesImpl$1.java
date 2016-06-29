/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CompactLinkedHashMap;
import com.google.common.collect.CompactLinkedHashMap$1;
import com.google.common.collect.CompactLinkedHashMap$1ValuesImpl;
import com.google.common.collect.CompactLinkedHashMap$Itr;

class CompactLinkedHashMap$1ValuesImpl$1
extends CompactLinkedHashMap$Itr {
    final /* synthetic */ CompactLinkedHashMap$1ValuesImpl this$1;

    CompactLinkedHashMap$1ValuesImpl$1(CompactLinkedHashMap$1ValuesImpl compactLinkedHashMap$1ValuesImpl) {
        this.this$1 = compactLinkedHashMap$1ValuesImpl;
        super(compactLinkedHashMap$1ValuesImpl.this$0, null);
    }

    @Override
    Object getOutput(int n2) {
        return this.this$1.this$0.values[n2];
    }
}

