/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.Service$State;

@Beta
public abstract class Service$Listener {
    public void starting() {
    }

    public void running() {
    }

    public void stopping(Service$State service$State) {
    }

    public void terminated(Service$State service$State) {
    }

    public void failed(Service$State service$State, Throwable throwable) {
    }
}

