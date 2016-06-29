package com.google.common.io;

import com.google.common.annotations.*;
import java.io.*;
import java.util.logging.*;

@VisibleForTesting
final class Closer$LoggingSuppressor implements Closer$Suppressor
{
    static final Closer$LoggingSuppressor INSTANCE;
    
    @Override
    public void suppress(final Closeable closeable, final Throwable t, final Throwable t2) {
        final Logger logger = Closeables.logger;
        final Level warning = Level.WARNING;
        final String value = String.valueOf(closeable);
        logger.log(warning, new StringBuilder(42 + String.valueOf(value).length()).append("Suppressing exception thrown when closing ").append(value).toString(), t2);
    }
    
    static {
        INSTANCE = new Closer$LoggingSuppressor();
    }
}
