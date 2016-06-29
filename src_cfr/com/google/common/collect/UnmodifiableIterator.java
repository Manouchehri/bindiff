/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
public abstract class UnmodifiableIterator
implements Iterator {
    protected UnmodifiableIterator() {
    }

    @Deprecated
    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

