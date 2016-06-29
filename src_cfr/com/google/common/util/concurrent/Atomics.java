/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.Nullable;

public final class Atomics {
    private Atomics() {
    }

    public static AtomicReference newReference() {
        return new AtomicReference();
    }

    public static AtomicReference newReference(@Nullable Object object) {
        return new AtomicReference<Object>(object);
    }

    public static AtomicReferenceArray newReferenceArray(int n2) {
        return new AtomicReferenceArray(n2);
    }

    public static AtomicReferenceArray newReferenceArray(Object[] arrobject) {
        return new AtomicReferenceArray<Object>(arrobject);
    }
}

