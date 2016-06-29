/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import java.util.Enumeration;
import java.util.Iterator;

final class Iterators$15
implements Enumeration {
    final /* synthetic */ Iterator val$iterator;

    Iterators$15(Iterator iterator) {
        this.val$iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return this.val$iterator.hasNext();
    }

    public Object nextElement() {
        return this.val$iterator.next();
    }
}

