/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.FinalizableReferenceQueue$FinalizerLoader;

class FinalizableReferenceQueue$DirectLoader
implements FinalizableReferenceQueue$FinalizerLoader {
    FinalizableReferenceQueue$DirectLoader() {
    }

    @Override
    public Class loadFinalizer() {
        try {
            return Class.forName("com.google.common.base.internal.Finalizer");
        }
        catch (ClassNotFoundException var1_1) {
            throw new AssertionError(var1_1);
        }
    }
}

