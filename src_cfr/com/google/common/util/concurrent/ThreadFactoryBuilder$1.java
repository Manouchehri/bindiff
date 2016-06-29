/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

final class ThreadFactoryBuilder$1
implements ThreadFactory {
    final /* synthetic */ ThreadFactory val$backingThreadFactory;
    final /* synthetic */ String val$nameFormat;
    final /* synthetic */ AtomicLong val$count;
    final /* synthetic */ Boolean val$daemon;
    final /* synthetic */ Integer val$priority;
    final /* synthetic */ Thread.UncaughtExceptionHandler val$uncaughtExceptionHandler;

    ThreadFactoryBuilder$1(ThreadFactory threadFactory, String string, AtomicLong atomicLong, Boolean bl2, Integer n2, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.val$backingThreadFactory = threadFactory;
        this.val$nameFormat = string;
        this.val$count = atomicLong;
        this.val$daemon = bl2;
        this.val$priority = n2;
        this.val$uncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = this.val$backingThreadFactory.newThread(runnable);
        if (this.val$nameFormat != null) {
            thread.setName(ThreadFactoryBuilder.access$000(this.val$nameFormat, new Object[]{this.val$count.getAndIncrement()}));
        }
        if (this.val$daemon != null) {
            thread.setDaemon(this.val$daemon);
        }
        if (this.val$priority != null) {
            thread.setPriority(this.val$priority);
        }
        if (this.val$uncaughtExceptionHandler == null) return thread;
        thread.setUncaughtExceptionHandler(this.val$uncaughtExceptionHandler);
        return thread;
    }
}

