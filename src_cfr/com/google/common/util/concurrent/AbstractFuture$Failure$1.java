/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

final class AbstractFuture$Failure$1
extends Throwable {
    AbstractFuture$Failure$1(String string) {
        super(string);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

