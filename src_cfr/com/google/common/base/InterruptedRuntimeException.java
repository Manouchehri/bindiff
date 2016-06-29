/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import javax.annotation.Nullable;

@Deprecated
@GoogleInternal
public class InterruptedRuntimeException
extends RuntimeException {
    private static final long serialVersionUID = 1;

    public InterruptedRuntimeException() {
        Thread.currentThread().interrupt();
    }

    public InterruptedRuntimeException(@Nullable String string) {
        super(string);
        Thread.currentThread().interrupt();
    }

    public InterruptedRuntimeException(@Nullable InterruptedException interruptedException) {
        super(interruptedException);
        Thread.currentThread().interrupt();
    }

    public InterruptedRuntimeException(@Nullable String string, @Nullable InterruptedException interruptedException) {
        super(string, interruptedException);
        Thread.currentThread().interrupt();
    }
}

