/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@Beta
public final class Closeables {
    @VisibleForTesting
    static final Logger logger = Logger.getLogger(Closeables.class.getName());

    private Closeables() {
    }

    public static void close(@Nullable Closeable closeable, boolean bl2) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
            return;
        }
        catch (IOException var2_2) {
            if (!bl2) throw var2_2;
            logger.log(Level.WARNING, "IOException thrown while closing Closeable.", var2_2);
            return;
        }
    }

    @Deprecated
    @GoogleInternal
    public static void closeQuietly(@Nullable Closeable closeable) {
        try {
            Closeables.close(closeable, true);
            return;
        }
        catch (IOException var1_1) {
            logger.log(Level.SEVERE, "IOException should not have been thrown.", var1_1);
        }
    }

    public static void closeQuietly(@Nullable InputStream inputStream) {
        try {
            Closeables.close(inputStream, true);
            return;
        }
        catch (IOException var1_1) {
            throw new AssertionError(var1_1);
        }
    }

    public static void closeQuietly(@Nullable Reader reader) {
        try {
            Closeables.close(reader, true);
            return;
        }
        catch (IOException var1_1) {
            throw new AssertionError(var1_1);
        }
    }
}

