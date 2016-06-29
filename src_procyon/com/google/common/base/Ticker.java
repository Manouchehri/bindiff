package com.google.common.base;

import com.google.common.annotations.*;
import javax.annotation.*;

@Beta
@GwtCompatible
public abstract class Ticker
{
    private static final Ticker SYSTEM_TICKER;
    
    public abstract long read();
    
    @CheckReturnValue
    public static Ticker systemTicker() {
        return Ticker.SYSTEM_TICKER;
    }
    
    static {
        SYSTEM_TICKER = new Ticker$1();
    }
}
