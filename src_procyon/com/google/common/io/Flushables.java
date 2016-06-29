package com.google.common.io;

import com.google.common.annotations.*;
import java.util.logging.*;
import java.io.*;

@Beta
public final class Flushables
{
    private static final Logger logger;
    
    public static void flush(final Flushable flushable, final boolean b) {
        try {
            flushable.flush();
        }
        catch (IOException ex) {
            if (!b) {
                throw ex;
            }
            Flushables.logger.log(Level.WARNING, "IOException thrown while flushing Flushable.", ex);
        }
    }
    
    public static void flushQuietly(final Flushable flushable) {
        try {
            flush(flushable, true);
        }
        catch (IOException ex) {
            Flushables.logger.log(Level.SEVERE, "IOException should not have been thrown.", ex);
        }
    }
    
    static {
        logger = Logger.getLogger(Flushables.class.getName());
    }
}
