package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.logging.*;
import java.util.*;

@VisibleForTesting
final class UncaughtExceptionHandlers$Exiter implements UncaughtExceptionHandler
{
    private static final Logger logger;
    private final Runtime runtime;
    
    UncaughtExceptionHandlers$Exiter(final Runtime runtime) {
        this.runtime = runtime;
    }
    
    @Override
    public void uncaughtException(final Thread thread, final Throwable t) {
        try {
            UncaughtExceptionHandlers$Exiter.logger.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", thread), t);
        }
        catch (Throwable t2) {
            System.err.println(t.getMessage());
            System.err.println(t2.getMessage());
        }
        finally {
            this.runtime.exit(1);
        }
    }
    
    static {
        logger = Logger.getLogger(UncaughtExceptionHandlers$Exiter.class.getName());
    }
}
