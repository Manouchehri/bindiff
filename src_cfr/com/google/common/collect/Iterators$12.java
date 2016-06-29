/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;

final class Iterators$12
extends AbstractIndexedListIterator {
    final /* synthetic */ Object[] val$array;
    final /* synthetic */ int val$offset;

    Iterators$12(int n2, int n3, Object[] arrobject, int n4) {
        this.val$array = arrobject;
        this.val$offset = n4;
        super(n2, n3);
    }

    @Override
    protected Object get(int n2) {
        return this.val$array[this.val$offset + n2];
    }
}

