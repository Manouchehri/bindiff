package com.google.common.util.concurrent;

import java.util.concurrent.atomic.*;
import com.google.common.base.*;
import java.util.concurrent.*;
import java.util.*;

final class ThreadFactoryBuilder$1 implements ThreadFactory
{
    final /* synthetic */ ThreadFactory val$backingThreadFactory;
    final /* synthetic */ String val$nameFormat;
    final /* synthetic */ AtomicLong val$count;
    final /* synthetic */ Boolean val$daemon;
    final /* synthetic */ Integer val$priority;
    final /* synthetic */ Thread.UncaughtExceptionHandler val$uncaughtExceptionHandler;
    
    ThreadFactoryBuilder$1(final ThreadFactory val$backingThreadFactory, final String val$nameFormat, final AtomicLong val$count, final Boolean val$daemon, final Integer val$priority, final Thread.UncaughtExceptionHandler val$uncaughtExceptionHandler) {
        this.val$backingThreadFactory = val$backingThreadFactory;
        this.val$nameFormat = val$nameFormat;
        this.val$count = val$count;
        this.val$daemon = val$daemon;
        this.val$priority = val$priority;
        this.val$uncaughtExceptionHandler = val$uncaughtExceptionHandler;
    }
    
    @Override
    public Thread newThread(final Runnable runnable) {
        final Thread thread = this.val$backingThreadFactory.newThread(runnable);
        if (this.val$nameFormat != null) {
            thread.setName(format(this.val$nameFormat, new Object[] { this.val$count.getAndIncrement() }));
        }
        if (this.val$daemon != null) {
            thread.setDaemon(this.val$daemon);
        }
        if (this.val$priority != null) {
            thread.setPriority(this.val$priority);
        }
        if (this.val$uncaughtExceptionHandler != null) {
            thread.setUncaughtExceptionHandler(this.val$uncaughtExceptionHandler);
        }
        return thread;
    }
}
