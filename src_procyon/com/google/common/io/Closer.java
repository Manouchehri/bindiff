package com.google.common.io;

import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;
import java.io.*;
import com.google.common.base.*;

@Beta
public final class Closer implements Closeable
{
    private static final Closer$Suppressor SUPPRESSOR;
    @VisibleForTesting
    final Closer$Suppressor suppressor;
    private final Deque stack;
    private Throwable thrown;
    
    public static Closer create() {
        return new Closer(Closer.SUPPRESSOR);
    }
    
    Closer(final Closer$Suppressor closer$Suppressor) {
        this.stack = new ArrayDeque(4);
        this.suppressor = (Closer$Suppressor)Preconditions.checkNotNull(closer$Suppressor);
    }
    
    public Closeable register(@Nullable final Closeable closeable) {
        if (closeable != null) {
            this.stack.addFirst(closeable);
        }
        return closeable;
    }
    
    public RuntimeException rethrow(final Throwable thrown) {
        Preconditions.checkNotNull(thrown);
        Throwables.propagateIfPossible(this.thrown = thrown, IOException.class);
        throw new RuntimeException(thrown);
    }
    
    public RuntimeException rethrow(final Throwable thrown, final Class clazz) {
        Preconditions.checkNotNull(thrown);
        Throwables.propagateIfPossible(this.thrown = thrown, IOException.class);
        Throwables.propagateIfPossible(thrown, clazz);
        throw new RuntimeException(thrown);
    }
    
    public RuntimeException rethrow(final Throwable thrown, final Class clazz, final Class clazz2) {
        Preconditions.checkNotNull(thrown);
        Throwables.propagateIfPossible(this.thrown = thrown, IOException.class);
        Throwables.propagateIfPossible(thrown, clazz, clazz2);
        throw new RuntimeException(thrown);
    }
    
    @Override
    public void close() {
        Throwable thrown = this.thrown;
        while (!this.stack.isEmpty()) {
            final Closeable closeable = this.stack.removeFirst();
            try {
                closeable.close();
            }
            catch (Throwable t) {
                if (thrown == null) {
                    thrown = t;
                }
                else {
                    this.suppressor.suppress(closeable, thrown, t);
                }
            }
        }
        if (this.thrown == null && thrown != null) {
            Throwables.propagateIfPossible(thrown, IOException.class);
            throw new AssertionError((Object)thrown);
        }
    }
    
    static {
        SUPPRESSOR = (Closer$SuppressingSuppressor.isAvailable() ? Closer$SuppressingSuppressor.INSTANCE : Closer$LoggingSuppressor.INSTANCE);
    }
}
