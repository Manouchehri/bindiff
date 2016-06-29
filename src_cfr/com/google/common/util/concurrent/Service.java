/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@Beta
public interface Service {
    public Service startAsync();

    public boolean isRunning();

    public Service$State state();

    public Service stopAsync();

    public void awaitRunning();

    public void awaitRunning(long var1, TimeUnit var3);

    public void awaitTerminated();

    public void awaitTerminated(long var1, TimeUnit var3);

    public Throwable failureCause();

    public void addListener(Service$Listener var1, Executor var2);
}

