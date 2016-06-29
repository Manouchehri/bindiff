/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import java.io.PrintStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@VisibleForTesting
final class UncaughtExceptionHandlers$Exiter
implements Thread.UncaughtExceptionHandler {
    private static final Logger logger = Logger.getLogger(UncaughtExceptionHandlers$Exiter.class.getName());
    private final Runtime runtime;

    UncaughtExceptionHandlers$Exiter(Runtime runtime) {
        this.runtime = runtime;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        try {
            logger.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", thread), throwable);
            return;
        }
        catch (Throwable var3_3) {
            System.err.println(throwable.getMessage());
            System.err.println(var3_3.getMessage());
            return;
        }
        finally {
            this.runtime.exit(1);
        }
    }
}

