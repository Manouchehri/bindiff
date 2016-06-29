/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.UncaughtExceptionHandlers$Exiter;

public final class UncaughtExceptionHandlers {
    private UncaughtExceptionHandlers() {
    }

    public static Thread.UncaughtExceptionHandler systemExit() {
        return new UncaughtExceptionHandlers$Exiter(Runtime.getRuntime());
    }
}

