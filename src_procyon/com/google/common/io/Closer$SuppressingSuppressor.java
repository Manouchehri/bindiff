package com.google.common.io;

import com.google.common.annotations.*;
import java.lang.reflect.*;
import java.io.*;

@VisibleForTesting
final class Closer$SuppressingSuppressor implements Closer$Suppressor
{
    static final Closer$SuppressingSuppressor INSTANCE;
    static final Method addSuppressed;
    
    static boolean isAvailable() {
        return Closer$SuppressingSuppressor.addSuppressed != null;
    }
    
    private static Method getAddSuppressed() {
        try {
            return Throwable.class.getMethod("addSuppressed", Throwable.class);
        }
        catch (Throwable t) {
            return null;
        }
    }
    
    @Override
    public void suppress(final Closeable closeable, final Throwable t, final Throwable t2) {
        if (t == t2) {
            return;
        }
        try {
            Closer$SuppressingSuppressor.addSuppressed.invoke(t, t2);
        }
        catch (Throwable t3) {
            Closer$LoggingSuppressor.INSTANCE.suppress(closeable, t, t2);
        }
    }
    
    static {
        INSTANCE = new Closer$SuppressingSuppressor();
        addSuppressed = getAddSuppressed();
    }
}
