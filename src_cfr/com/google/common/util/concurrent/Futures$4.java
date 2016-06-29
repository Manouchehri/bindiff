/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

final class Futures$4
implements AsyncFunction {
    Futures$4() {
    }

    public ListenableFuture apply(ListenableFuture listenableFuture) {
        return listenableFuture;
    }
}

