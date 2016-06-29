package com.google.common.io;

import javax.annotation.*;
import java.util.logging.*;
import com.google.common.annotations.*;
import java.io.*;

@Beta
public final class Closeables
{
    @VisibleForTesting
    static final Logger logger;
    
    public static void close(@Nullable final Closeable closeable, final boolean b) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        }
        catch (IOException ex) {
            if (!b) {
                throw ex;
            }
            Closeables.logger.log(Level.WARNING, "IOException thrown while closing Closeable.", ex);
        }
    }
    
    @Deprecated
    @GoogleInternal
    public static void closeQuietly(@Nullable final Closeable closeable) {
        try {
            close(closeable, true);
        }
        catch (IOException ex) {
            Closeables.logger.log(Level.SEVERE, "IOException should not have been thrown.", ex);
        }
    }
    
    public static void closeQuietly(@Nullable final InputStream inputStream) {
        try {
            close(inputStream, true);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public static void closeQuietly(@Nullable final Reader reader) {
        try {
            close(reader, true);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    static {
        logger = Logger.getLogger(Closeables.class.getName());
    }
}
