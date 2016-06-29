package com.google.common.util.concurrent;

import com.google.common.annotations.*;

@Beta
public enum Service$State
{
    NEW("NEW", 0), 
    STARTING("STARTING", 1), 
    RUNNING("RUNNING", 2), 
    STOPPING("STOPPING", 3), 
    TERMINATED("TERMINATED", 4), 
    FAILED("FAILED", 5);
    
    private Service$State(final String s, final int n) {
    }
    
    abstract boolean isTerminal();
}
