/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ThreadFactoryBuilder$1;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadFactoryBuilder {
    private String nameFormat = null;
    private Boolean daemon = null;
    private Integer priority = null;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
    private ThreadFactory backingThreadFactory = null;

    public ThreadFactoryBuilder setNameFormat(String string) {
        ThreadFactoryBuilder.format(string, 0);
        this.nameFormat = string;
        return this;
    }

    public ThreadFactoryBuilder setDaemon(boolean bl2) {
        this.daemon = bl2;
        return this;
    }

    public ThreadFactoryBuilder setPriority(int n2) {
        Preconditions.checkArgument(n2 >= 1, "Thread priority (%s) must be >= %s", n2, 1);
        Preconditions.checkArgument(n2 <= 10, "Thread priority (%s) must be <= %s", n2, 10);
        this.priority = n2;
        return this;
    }

    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler)Preconditions.checkNotNull(uncaughtExceptionHandler);
        return this;
    }

    public ThreadFactoryBuilder setThreadFactory(ThreadFactory threadFactory) {
        this.backingThreadFactory = (ThreadFactory)Preconditions.checkNotNull(threadFactory);
        return this;
    }

    public ThreadFactory build() {
        return ThreadFactoryBuilder.build(this);
    }

    private static ThreadFactory build(ThreadFactoryBuilder threadFactoryBuilder) {
        String string = threadFactoryBuilder.nameFormat;
        Boolean bl2 = threadFactoryBuilder.daemon;
        Integer n2 = threadFactoryBuilder.priority;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadFactoryBuilder.uncaughtExceptionHandler;
        ThreadFactory threadFactory = threadFactoryBuilder.backingThreadFactory != null ? threadFactoryBuilder.backingThreadFactory : Executors.defaultThreadFactory();
        AtomicLong atomicLong = string != null ? new AtomicLong(0) : null;
        return new ThreadFactoryBuilder$1(threadFactory, string, atomicLong, bl2, n2, uncaughtExceptionHandler);
    }

    private static /* varargs */ String format(String string, Object ... arrobject) {
        return String.format(Locale.ROOT, string, arrobject);
    }

    static /* synthetic */ String access$000(String string, Object[] arrobject) {
        return ThreadFactoryBuilder.format(string, arrobject);
    }
}

