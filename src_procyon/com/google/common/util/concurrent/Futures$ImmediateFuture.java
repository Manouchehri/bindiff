package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.logging.*;
import java.util.concurrent.*;

abstract class Futures$ImmediateFuture implements ListenableFuture
{
    private static final Logger log;
    
    @Override
    public void addListener(final Runnable runnable, final Executor executor) {
        Preconditions.checkNotNull(runnable, (Object)"Runnable was null.");
        Preconditions.checkNotNull(executor, (Object)"Executor was null.");
        try {
            executor.execute(runnable);
        }
        catch (RuntimeException ex) {
            final Logger log = Futures$ImmediateFuture.log;
            final Level severe = Level.SEVERE;
            final String value = String.valueOf(runnable);
            final String value2 = String.valueOf(executor);
            log.log(severe, new StringBuilder(57 + String.valueOf(value).length() + String.valueOf(value2).length()).append("RuntimeException while executing runnable ").append(value).append(" with executor ").append(value2).toString(), ex);
        }
    }
    
    @Override
    public boolean cancel(final boolean b) {
        return false;
    }
    
    @Override
    public abstract Object get();
    
    @Override
    public Object get(final long n, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        return this.get();
    }
    
    @Override
    public boolean isCancelled() {
        return false;
    }
    
    @Override
    public boolean isDone() {
        return true;
    }
    
    static {
        log = Logger.getLogger(Futures$ImmediateFuture.class.getName());
    }
}
