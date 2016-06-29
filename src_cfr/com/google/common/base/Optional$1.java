/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Optional$1$1;
import java.util.Iterator;

final class Optional$1
implements Iterable {
    final /* synthetic */ Iterable val$optionals;

    Optional$1(Iterable iterable) {
        this.val$optionals = iterable;
    }

    public Iterator iterator() {
        return new Optional$1$1(this);
    }
}

