package com.google.common.util.concurrent;

import java.util.concurrent.*;
import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.annotations.*;

final class Callables$3 implements Callable
{
    final /* synthetic */ Supplier val$nameSupplier;
    final /* synthetic */ Callable val$callable;
    
    Callables$3(final Supplier val$nameSupplier, final Callable val$callable) {
        this.val$nameSupplier = val$nameSupplier;
        this.val$callable = val$callable;
    }
    
    @Override
    public Object call() {
        final Thread currentThread = Thread.currentThread();
        final String name = currentThread.getName();
        final boolean access$000 = trySetName((String)this.val$nameSupplier.get(), currentThread);
        try {
            return this.val$callable.call();
        }
        finally {
            if (access$000) {
                trySetName(name, currentThread);
            }
        }
    }
}
