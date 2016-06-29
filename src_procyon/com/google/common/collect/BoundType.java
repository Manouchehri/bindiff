package com.google.common.collect;

import com.google.common.annotations.*;

@GwtCompatible
public enum BoundType
{
    OPEN("OPEN", 0), 
    CLOSED("CLOSED", 1);
    
    private BoundType(final String s, final int n) {
    }
    
    static BoundType forBoolean(final boolean b) {
        return b ? BoundType.CLOSED : BoundType.OPEN;
    }
    
    abstract BoundType flip();
}
