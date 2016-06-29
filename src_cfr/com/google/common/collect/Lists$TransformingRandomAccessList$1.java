/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Lists$TransformingRandomAccessList;
import com.google.common.collect.TransformedListIterator;
import java.util.ListIterator;

class Lists$TransformingRandomAccessList$1
extends TransformedListIterator {
    final /* synthetic */ Lists$TransformingRandomAccessList this$0;

    Lists$TransformingRandomAccessList$1(Lists$TransformingRandomAccessList transformingRandomAccessList, ListIterator listIterator) {
        this.this$0 = transformingRandomAccessList;
        super(listIterator);
    }

    @Override
    Object transform(Object object) {
        return this.this$0.function.apply(object);
    }
}

