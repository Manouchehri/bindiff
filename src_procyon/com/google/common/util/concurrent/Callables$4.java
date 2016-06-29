package com.google.common.util.concurrent;

import javax.annotation.*;
import java.util.concurrent.*;
import com.google.common.base.*;
import com.google.common.annotations.*;

final class Callables$4 implements Runnable
{
    final /* synthetic */ Supplier val$nameSupplier;
    final /* synthetic */ Runnable val$task;
    
    Callables$4(final Supplier val$nameSupplier, final Runnable val$task) {
        this.val$nameSupplier = val$nameSupplier;
        this.val$task = val$task;
    }
    
    @Override
    public void run() {
        final Thread currentThread = Thread.currentThread();
        final String name = currentThread.getName();
        final boolean access$000 = trySetName((String)this.val$nameSupplier.get(), currentThread);
        try {
            this.val$task.run();
        }
        finally {
            if (access$000) {
                trySetName(name, currentThread);
            }
        }
    }
}
