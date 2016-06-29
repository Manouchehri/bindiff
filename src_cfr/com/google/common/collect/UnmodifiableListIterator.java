/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ListIterator;

@GwtCompatible
public abstract class UnmodifiableListIterator
extends UnmodifiableIterator
implements ListIterator {
    protected UnmodifiableListIterator() {
    }

    @Deprecated
    public final void add(Object object) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void set(Object object) {
        throw new UnsupportedOperationException();
    }
}

