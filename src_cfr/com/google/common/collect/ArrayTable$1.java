/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1$1;
import com.google.common.collect.Table$Cell;

class ArrayTable$1
extends AbstractIndexedListIterator {
    final /* synthetic */ ArrayTable this$0;

    ArrayTable$1(ArrayTable arrayTable, int n2) {
        this.this$0 = arrayTable;
        super(n2);
    }

    @Override
    protected Table$Cell get(int n2) {
        return new ArrayTable$1$1(this, n2);
    }
}

