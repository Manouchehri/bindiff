/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables$1;
import com.google.common.util.concurrent.Callables$2;
import com.google.common.util.concurrent.Callables$3;
import com.google.common.util.concurrent.Callables$4;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public final class Callables {
    private Callables() {
    }

    public static Callable returning(@Nullable Object object) {
        return new Callables$1(object);
    }

    @GoogleInternal
    public static Callable throwing(Exception exception) {
        Preconditions.checkNotNull(exception);
        return new Callables$2(exception);
    }

    @GwtIncompatible(value="threads")
    public static Callable threadRenaming(Callable callable, Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(callable);
        return new Callables$3(supplier, callable);
    }

    @GwtIncompatible(value="threads")
    public static Runnable threadRenaming(Runnable runnable, Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return new Callables$4(supplier, runnable);
    }

    @GwtIncompatible(value="threads")
    private static boolean trySetName(String string, Thread thread) {
        try {
            thread.setName(string);
            return true;
        }
        catch (SecurityException var2_2) {
            return false;
        }
    }

    static /* synthetic */ boolean access$000(String string, Thread thread) {
        return Callables.trySetName(string, thread);
    }
}

