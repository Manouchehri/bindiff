/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public class ExecutionError
extends Error {
    private static final long serialVersionUID = 0;

    protected ExecutionError() {
    }

    protected ExecutionError(@Nullable String string) {
        super(string);
    }

    public ExecutionError(@Nullable String string, @Nullable Error error) {
        super(string, error);
    }

    public ExecutionError(@Nullable Error error) {
        super(error);
    }
}

