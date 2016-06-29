package com.google.common.util.concurrent;

import java.util.concurrent.*;

enum MoreExecutors$DirectExecutor implements Executor
{
    INSTANCE("INSTANCE", 0);
    
    private MoreExecutors$DirectExecutor(final String s, final int n) {
    }
    
    @Override
    public void execute(final Runnable runnable) {
        runnable.run();
    }
}
