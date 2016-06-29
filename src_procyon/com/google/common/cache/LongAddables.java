package com.google.common.cache;

import com.google.common.annotations.*;
import com.google.common.base.*;

@GwtCompatible(emulated = true)
final class LongAddables
{
    private static final Supplier SUPPLIER;
    
    public static LongAddable create() {
        return (LongAddable)LongAddables.SUPPLIER.get();
    }
    
    static {
        Supplier supplier;
        try {
            new LongAdder();
            supplier = new LongAddables$1();
        }
        catch (Throwable t) {
            supplier = new LongAddables$2();
        }
        SUPPLIER = supplier;
    }
}
