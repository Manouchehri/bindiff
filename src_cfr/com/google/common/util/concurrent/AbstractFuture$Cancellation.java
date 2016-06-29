/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;

final class AbstractFuture$Cancellation {
    final boolean wasInterrupted;
    final Throwable cause;

    AbstractFuture$Cancellation(boolean bl2, Throwable throwable) {
        this.wasInterrupted = bl2;
        this.cause = (Throwable)Preconditions.checkNotNull(throwable);
    }
}

