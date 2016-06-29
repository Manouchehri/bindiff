package com.google.common.io;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.logging.*;
import java.io.*;

@GoogleInternal
public final class LegacyCloseables
{
    private static final Logger logger;
    
    @Deprecated
    public static void closeQuietly(@Nullable final Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        }
        catch (IOException ex) {
            LegacyCloseables.logger.log(Level.WARNING, "IOException thrown while closing Closeable.", ex);
        }
    }
    
    static {
        logger = Logger.getLogger(LegacyCloseables.class.getName());
    }
}
