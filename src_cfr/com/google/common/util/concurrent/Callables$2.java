/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

final class Callables$2
implements Callable {
    final /* synthetic */ Exception val$exception;

    Callables$2(Exception exception) {
        this.val$exception = exception;
    }

    public Object call() {
        throw this.val$exception;
    }
}

