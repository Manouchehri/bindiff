/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.TransformedIterator;
import java.util.Iterator;

final class Iterables$3
extends TransformedIterator {
    Iterables$3(Iterator iterator) {
        super(iterator);
    }

    Iterator transform(Iterable iterable) {
        return iterable.iterator();
    }
}

