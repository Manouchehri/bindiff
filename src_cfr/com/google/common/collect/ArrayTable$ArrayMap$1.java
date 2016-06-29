/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ArrayTable$ArrayMap;
import com.google.common.collect.ArrayTable$ArrayMap$1$1;
import java.util.Map;

class ArrayTable$ArrayMap$1
extends AbstractIndexedListIterator {
    final /* synthetic */ ArrayTable$ArrayMap this$0;

    ArrayTable$ArrayMap$1(ArrayTable$ArrayMap arrayTable$ArrayMap, int n2) {
        this.this$0 = arrayTable$ArrayMap;
        super(n2);
    }

    @Override
    protected Map.Entry get(int n2) {
        return new ArrayTable$ArrayMap$1$1(this, n2);
    }
}

