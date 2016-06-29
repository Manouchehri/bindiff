package com.google.common.util.concurrent;

public final class UncaughtExceptionHandlers
{
    public static Thread.UncaughtExceptionHandler systemExit() {
        return new UncaughtExceptionHandlers$Exiter(Runtime.getRuntime());
    }
}
