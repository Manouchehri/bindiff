package com.google.common.cache;

import com.google.common.annotations.*;

@GwtCompatible
public enum RemovalCause
{
    EXPLICIT("EXPLICIT", 0), 
    REPLACED("REPLACED", 1), 
    COLLECTED("COLLECTED", 2), 
    EXPIRED("EXPIRED", 3), 
    SIZE("SIZE", 4);
    
    private RemovalCause(final String s, final int n) {
    }
    
    abstract boolean wasEvicted();
}
