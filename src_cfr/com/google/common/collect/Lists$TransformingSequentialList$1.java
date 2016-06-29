/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Lists$TransformingSequentialList;
import com.google.common.collect.TransformedListIterator;
import java.util.ListIterator;

class Lists$TransformingSequentialList$1
extends TransformedListIterator {
    final /* synthetic */ Lists$TransformingSequentialList this$0;

    Lists$TransformingSequentialList$1(Lists$TransformingSequentialList transformingSequentialList, ListIterator listIterator) {
        this.this$0 = transformingSequentialList;
        super(listIterator);
    }

    @Override
    Object transform(Object object) {
        return this.this$0.function.apply(object);
    }
}

