package com.google.common.util.concurrent;

import com.google.common.annotations.*;

@Beta
public enum CycleDetectingLockFactory$Policies implements CycleDetectingLockFactory$Policy
{
    THROW("THROW", 0), 
    WARN("WARN", 1), 
    DISABLED("DISABLED", 2);
    
    private CycleDetectingLockFactory$Policies(final String s, final int n) {
    }
}
