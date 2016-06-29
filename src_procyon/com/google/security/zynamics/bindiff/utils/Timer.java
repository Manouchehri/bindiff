package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.bindiff.log.*;

public class Timer
{
    private long startTime;
    private long endTime;
    private long lastStartTime;
    
    public Timer() {
        this.startTime = 0L;
        this.endTime = 0L;
        this.lastStartTime = 0L;
    }
    
    public void end() {
        this.endTime = System.currentTimeMillis();
    }
    
    public void printTime() {
        this.end();
        Logger.logVerbose(new StringBuilder(40).append("Elapsed time in ms: ").append(this.endTime - this.startTime).toString(), new Object[0]);
    }
    
    public void printTime(final String s) {
        this.end();
        Logger.logVerbose(new StringBuilder(68 + String.valueOf(s).length()).append("Elapsed time in ms: ").append(this.endTime - this.startTime).append("[").append(this.endTime - this.lastStartTime).append("]").append("  --  ").append(s).toString(), new Object[0]);
        this.lastStartTime = System.currentTimeMillis();
    }
    
    public void start() {
        this.startTime = System.currentTimeMillis();
        this.lastStartTime = System.currentTimeMillis();
    }
    
    public void start(final String s) {
        Logger.logVerbose(s, new Object[0]);
        this.start();
    }
}
