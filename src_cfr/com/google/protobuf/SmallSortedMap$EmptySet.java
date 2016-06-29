/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.SmallSortedMap$EmptySet$1;
import com.google.protobuf.SmallSortedMap$EmptySet$2;
import java.util.Iterator;

class SmallSortedMap$EmptySet {
    private static final Iterator ITERATOR = new SmallSortedMap$EmptySet$1();
    private static final Iterable ITERABLE = new SmallSortedMap$EmptySet$2();

    private SmallSortedMap$EmptySet() {
    }

    static Iterable iterable() {
        return ITERABLE;
    }

    static /* synthetic */ Iterator access$700() {
        return ITERATOR;
    }
}

