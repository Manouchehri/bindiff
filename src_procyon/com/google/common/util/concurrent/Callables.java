package com.google.common.util.concurrent;

import javax.annotation.*;
import java.util.concurrent.*;
import com.google.common.base.*;
import com.google.common.annotations.*;

@GwtCompatible(emulated = true)
public final class Callables
{
    public static Callable returning(@Nullable final Object o) {
        return new Callables$1(o);
    }
    
    @GoogleInternal
    public static Callable throwing(final Exception ex) {
        Preconditions.checkNotNull(ex);
        return new Callables$2(ex);
    }
    
    @GwtIncompatible("threads")
    public static Callable threadRenaming(final Callable callable, final Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(callable);
        return new Callables$3(supplier, callable);
    }
    
    @GwtIncompatible("threads")
    public static Runnable threadRenaming(final Runnable runnable, final Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return new Callables$4(supplier, runnable);
    }
    
    @GwtIncompatible("threads")
    private static boolean trySetName(final String name, final Thread thread) {
        try {
            thread.setName(name);
            return true;
        }
        catch (SecurityException ex) {
            return false;
        }
    }
}
