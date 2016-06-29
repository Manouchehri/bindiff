/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.ArrayTable$ArrayMap;
import com.google.common.collect.ArrayTable$ArrayMap$1;

class ArrayTable$ArrayMap$1$1
extends AbstractMapEntry {
    final /* synthetic */ int val$index;
    final /* synthetic */ ArrayTable$ArrayMap$1 this$1;

    ArrayTable$ArrayMap$1$1(ArrayTable$ArrayMap$1 var1_1, int n2) {
        this.this$1 = var1_1;
        this.val$index = n2;
    }

    @Override
    public Object getKey() {
        return this.this$1.this$0.getKey(this.val$index);
    }

    @Override
    public Object getValue() {
        return this.this$1.this$0.getValue(this.val$index);
    }

    @Override
    public Object setValue(Object object) {
        return this.this$1.this$0.setValue(this.val$index, object);
    }
}

