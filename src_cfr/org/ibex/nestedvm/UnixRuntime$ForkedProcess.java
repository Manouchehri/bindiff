/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime;

public final class UnixRuntime$ForkedProcess
extends Thread {
    private final UnixRuntime initial;

    public UnixRuntime$ForkedProcess(UnixRuntime unixRuntime) {
        this.initial = unixRuntime;
        this.start();
    }

    @Override
    public void run() {
        UnixRuntime.executeAndExec(this.initial);
    }
}

