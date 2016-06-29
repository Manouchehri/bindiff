/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

enum MoreExecutors$DirectExecutor implements Executor
{
    INSTANCE;
    

    private MoreExecutors$DirectExecutor() {
    }

    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}

