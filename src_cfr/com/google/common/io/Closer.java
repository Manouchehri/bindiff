/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.io.Closer$LoggingSuppressor;
import com.google.common.io.Closer$SuppressingSuppressor;
import com.google.common.io.Closer$Suppressor;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.annotation.Nullable;

@Beta
public final class Closer
implements Closeable {
    private static final Closer$Suppressor SUPPRESSOR = Closer$SuppressingSuppressor.isAvailable() ? Closer$SuppressingSuppressor.INSTANCE : Closer$LoggingSuppressor.INSTANCE;
    @VisibleForTesting
    final Closer$Suppressor suppressor;
    private final Deque stack = new ArrayDeque(4);
    private Throwable thrown;

    public static Closer create() {
        return new Closer(SUPPRESSOR);
    }

    @VisibleForTesting
    Closer(Closer$Suppressor closer$Suppressor) {
        this.suppressor = (Closer$Suppressor)Preconditions.checkNotNull(closer$Suppressor);
    }

    public Closeable register(@Nullable Closeable closeable) {
        if (closeable == null) return closeable;
        this.stack.addFirst(closeable);
        return closeable;
    }

    public RuntimeException rethrow(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        this.thrown = throwable;
        Throwables.propagateIfPossible(throwable, IOException.class);
        throw new RuntimeException(throwable);
    }

    public RuntimeException rethrow(Throwable throwable, Class class_) {
        Preconditions.checkNotNull(throwable);
        this.thrown = throwable;
        Throwables.propagateIfPossible(throwable, IOException.class);
        Throwables.propagateIfPossible(throwable, class_);
        throw new RuntimeException(throwable);
    }

    public RuntimeException rethrow(Throwable throwable, Class class_, Class class_2) {
        Preconditions.checkNotNull(throwable);
        this.thrown = throwable;
        Throwables.propagateIfPossible(throwable, IOException.class);
        Throwables.propagateIfPossible(throwable, class_, class_2);
        throw new RuntimeException(throwable);
    }

    @Override
    public void close() {
        Throwable throwable = this.thrown;
        do {
            if (this.stack.isEmpty()) {
                if (this.thrown != null) return;
                if (throwable == null) return;
                Throwables.propagateIfPossible(throwable, IOException.class);
                throw new AssertionError(throwable);
            }
            Closeable closeable = (Closeable)this.stack.removeFirst();
            try {
                closeable.close();
            }
            catch (Throwable var3_3) {
                if (throwable == null) {
                    throwable = var3_3;
                    continue;
                }
                this.suppressor.suppress(closeable, throwable, var3_3);
                continue;
            }
            break;
        } while (true);
    }
}

