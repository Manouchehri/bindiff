/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ExecutionList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

public class ListenableFutureTask
extends FutureTask
implements ListenableFuture {
    private final ExecutionList executionList = new ExecutionList();

    public static ListenableFutureTask create(Callable callable) {
        return new ListenableFutureTask(callable);
    }

    public static ListenableFutureTask create(Runnable runnable, @Nullable Object object) {
        return new ListenableFutureTask(runnable, object);
    }

    ListenableFutureTask(Callable callable) {
        super(callable);
    }

    ListenableFutureTask(Runnable runnable, @Nullable Object object) {
        super(runnable, object);
    }

    @Override
    public void addListener(Runnable runnable, Executor executor) {
        this.executionList.add(runnable, executor);
    }

    @Override
    protected void done() {
        this.executionList.execute();
    }
}

