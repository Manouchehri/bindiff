/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import javax.annotation.Nullable;

public class UncheckedTimeoutException
extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(@Nullable String string) {
        super(string);
    }

    public UncheckedTimeoutException(@Nullable Throwable throwable) {
        super(throwable);
    }

    public UncheckedTimeoutException(@Nullable String string, @Nullable Throwable throwable) {
        super(string, throwable);
    }
}

