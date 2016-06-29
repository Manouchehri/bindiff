/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;

final class Iterables$16
implements Function {
    Iterables$16() {
    }

    public Iterator apply(Iterable iterable) {
        return iterable.iterator();
    }
}

