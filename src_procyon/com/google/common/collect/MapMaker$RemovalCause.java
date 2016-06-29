package com.google.common.collect;

public enum MapMaker$RemovalCause
{
    EXPLICIT("EXPLICIT", 0), 
    REPLACED("REPLACED", 1), 
    COLLECTED("COLLECTED", 2), 
    EXPIRED("EXPIRED", 3), 
    SIZE("SIZE", 4);
    
    private MapMaker$RemovalCause(final String s, final int n) {
    }
    
    abstract boolean wasEvicted();
}
