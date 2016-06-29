/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CompactLinkedHashMap;
import com.google.common.collect.CompactLinkedHashMap$1;
import com.google.common.collect.CompactLinkedHashMap$1KeySetImpl;
import com.google.common.collect.CompactLinkedHashMap$Itr;

class CompactLinkedHashMap$1KeySetImpl$1
extends CompactLinkedHashMap$Itr {
    final /* synthetic */ CompactLinkedHashMap$1KeySetImpl this$1;

    CompactLinkedHashMap$1KeySetImpl$1(CompactLinkedHashMap$1KeySetImpl compactLinkedHashMap$1KeySetImpl) {
        this.this$1 = compactLinkedHashMap$1KeySetImpl;
        super(compactLinkedHashMap$1KeySetImpl.this$0, null);
    }

    @Override
    Object getOutput(int n2) {
        return this.this$1.this$0.keys[n2];
    }
}

