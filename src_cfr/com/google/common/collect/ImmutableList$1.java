/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ImmutableList;

class ImmutableList$1
extends AbstractIndexedListIterator {
    final /* synthetic */ ImmutableList this$0;

    ImmutableList$1(ImmutableList immutableList, int n2, int n3) {
        this.this$0 = immutableList;
        super(n2, n3);
    }

    @Override
    protected Object get(int n2) {
        return this.this$0.get(n2);
    }
}

