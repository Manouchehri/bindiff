/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

final class Callables$1
implements Callable {
    final /* synthetic */ Object val$value;

    Callables$1(Object object) {
        this.val$value = object;
    }

    public Object call() {
        return this.val$value;
    }
}

