/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.io.Closeables;
import com.google.common.io.Closer$Suppressor;
import java.io.Closeable;
import java.util.logging.Level;
import java.util.logging.Logger;

@VisibleForTesting
final class Closer$LoggingSuppressor
implements Closer$Suppressor {
    static final Closer$LoggingSuppressor INSTANCE = new Closer$LoggingSuppressor();

    Closer$LoggingSuppressor() {
    }

    @Override
    public void suppress(Closeable closeable, Throwable throwable, Throwable throwable2) {
        String string = String.valueOf(closeable);
        Closeables.logger.log(Level.WARNING, new StringBuilder(42 + String.valueOf(string).length()).append("Suppressing exception thrown when closing ").append(string).toString(), throwable2);
    }
}

