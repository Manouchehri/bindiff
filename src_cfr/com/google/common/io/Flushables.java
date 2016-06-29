/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public final class Flushables {
    private static final Logger logger = Logger.getLogger(Flushables.class.getName());

    private Flushables() {
    }

    public static void flush(Flushable flushable, boolean bl2) {
        try {
            flushable.flush();
            return;
        }
        catch (IOException var2_2) {
            if (!bl2) throw var2_2;
            logger.log(Level.WARNING, "IOException thrown while flushing Flushable.", var2_2);
            return;
        }
    }

    public static void flushQuietly(Flushable flushable) {
        try {
            Flushables.flush(flushable, true);
            return;
        }
        catch (IOException var1_1) {
            logger.log(Level.SEVERE, "IOException should not have been thrown.", var1_1);
        }
    }
}

