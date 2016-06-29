/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class AbstractSequentialIterator
extends UnmodifiableIterator {
    private Object nextOrNull;

    protected AbstractSequentialIterator(@Nullable Object object) {
        this.nextOrNull = object;
    }

    protected abstract Object computeNext(Object var1);

    @Override
    public final boolean hasNext() {
        if (this.nextOrNull == null) return false;
        return true;
    }

    public final Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            Object object = this.nextOrNull;
            return object;
        }
        finally {
            this.nextOrNull = this.computeNext(this.nextOrNull);
        }
    }
}

