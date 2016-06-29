/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.FinalizableReferenceQueue;
import com.google.common.base.FinalizableReferenceQueue$FinalizerLoader;

class FinalizableReferenceQueue$SystemLoader
implements FinalizableReferenceQueue$FinalizerLoader {
    @VisibleForTesting
    static boolean disabled;

    FinalizableReferenceQueue$SystemLoader() {
    }

    @Override
    public Class loadFinalizer() {
        ClassLoader classLoader;
        if (disabled) {
            return null;
        }
        try {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        catch (SecurityException var2_2) {
            FinalizableReferenceQueue.access$000().info("Not allowed to access system class loader.");
            return null;
        }
        if (classLoader == null) return null;
        try {
            return classLoader.loadClass("com.google.common.base.internal.Finalizer");
        }
        catch (ClassNotFoundException var2_3) {
            return null;
        }
    }
}

