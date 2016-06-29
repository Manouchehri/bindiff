/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GoogleInternal
public final class LegacyCloseables {
    private static final Logger logger = Logger.getLogger(LegacyCloseables.class.getName());

    private LegacyCloseables() {
    }

    @Deprecated
    public static void closeQuietly(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
            return;
        }
        catch (IOException var1_1) {
            logger.log(Level.WARNING, "IOException thrown while closing Closeable.", var1_1);
        }
    }
}

