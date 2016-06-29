/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.bindiff.log.Logger;

public class Timer {
    private long startTime = 0;
    private long endTime = 0;
    private long lastStartTime = 0;

    public void end() {
        this.endTime = System.currentTimeMillis();
    }

    public void printTime() {
        this.end();
        long l2 = this.endTime - this.startTime;
        Logger.logVerbose(new StringBuilder(40).append("Elapsed time in ms: ").append(l2).toString(), new Object[0]);
    }

    public void printTime(String string) {
        this.end();
        long l2 = this.endTime - this.startTime;
        long l3 = this.endTime - this.lastStartTime;
        Logger.logVerbose(new StringBuilder(68 + String.valueOf(string).length()).append("Elapsed time in ms: ").append(l2).append("[").append(l3).append("]").append("  --  ").append(string).toString(), new Object[0]);
        this.lastStartTime = System.currentTimeMillis();
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.lastStartTime = System.currentTimeMillis();
    }

    public void start(String string) {
        Logger.logVerbose(string, new Object[0]);
        this.start();
    }
}

