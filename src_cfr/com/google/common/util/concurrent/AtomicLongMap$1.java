/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.AtomicLongMap;
import java.util.concurrent.atomic.AtomicLong;

class AtomicLongMap$1
implements Function {
    final /* synthetic */ AtomicLongMap this$0;

    AtomicLongMap$1(AtomicLongMap atomicLongMap) {
        this.this$0 = atomicLongMap;
    }

    public Long apply(AtomicLong atomicLong) {
        return atomicLong.get();
    }
}

