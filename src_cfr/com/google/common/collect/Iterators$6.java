/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class Iterators$6
extends UnmodifiableIterator {
    final /* synthetic */ Iterator val$iterator;
    final /* synthetic */ int val$size;
    final /* synthetic */ boolean val$pad;

    Iterators$6(Iterator iterator, int n2, boolean bl2) {
        this.val$iterator = iterator;
        this.val$size = n2;
        this.val$pad = bl2;
    }

    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public List next() {
        int n2;
        List<Object> list;
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        Object[] arrobject = new Object[this.val$size];
        for (n2 = 0; n2 < this.val$size && this.val$iterator.hasNext(); ++n2) {
            arrobject[n2] = this.val$iterator.next();
        }
        for (int i2 = n2; i2 < this.val$size; ++i2) {
            arrobject[i2] = null;
        }
        List<Object> list2 = Collections.unmodifiableList(Arrays.asList(arrobject));
        if (!this.val$pad && n2 != this.val$size) {
            list = list2.subList(0, n2);
            return list;
        }
        list = list2;
        return list;
    }
}

