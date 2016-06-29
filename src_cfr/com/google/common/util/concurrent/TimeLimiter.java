/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Beta
public interface TimeLimiter {
    public Object newProxy(Object var1, Class var2, long var3, TimeUnit var5);

    public Object callWithTimeout(Callable var1, long var2, TimeUnit var4, boolean var5);
}

