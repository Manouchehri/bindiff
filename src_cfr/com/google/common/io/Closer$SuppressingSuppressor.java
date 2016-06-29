/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.io.Closer$LoggingSuppressor;
import com.google.common.io.Closer$Suppressor;
import java.io.Closeable;
import java.lang.reflect.Method;

@VisibleForTesting
final class Closer$SuppressingSuppressor
implements Closer$Suppressor {
    static final Closer$SuppressingSuppressor INSTANCE = new Closer$SuppressingSuppressor();
    static final Method addSuppressed = Closer$SuppressingSuppressor.getAddSuppressed();

    Closer$SuppressingSuppressor() {
    }

    static boolean isAvailable() {
        if (addSuppressed == null) return false;
        return true;
    }

    private static Method getAddSuppressed() {
        try {
            return Throwable.class.getMethod("addSuppressed", Throwable.class);
        }
        catch (Throwable var0) {
            return null;
        }
    }

    @Override
    public void suppress(Closeable closeable, Throwable throwable, Throwable throwable2) {
        if (throwable == throwable2) {
            return;
        }
        try {
            addSuppressed.invoke(throwable, throwable2);
            return;
        }
        catch (Throwable var4_4) {
            Closer$LoggingSuppressor.INSTANCE.suppress(closeable, throwable, throwable2);
        }
    }
}

