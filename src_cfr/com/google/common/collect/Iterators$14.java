/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Enumeration;

final class Iterators$14
extends UnmodifiableIterator {
    final /* synthetic */ Enumeration val$enumeration;

    Iterators$14(Enumeration enumeration) {
        this.val$enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return this.val$enumeration.hasMoreElements();
    }

    public Object next() {
        return this.val$enumeration.nextElement();
    }
}

