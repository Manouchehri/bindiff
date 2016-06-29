package com.google.common.base;

import com.google.common.annotations.*;
import javax.annotation.*;

@Deprecated
@GoogleInternal
public class InterruptedRuntimeException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    
    public InterruptedRuntimeException() {
        Thread.currentThread().interrupt();
    }
    
    public InterruptedRuntimeException(@Nullable final String s) {
        super(s);
        Thread.currentThread().interrupt();
    }
    
    public InterruptedRuntimeException(@Nullable final InterruptedException ex) {
        super(ex);
        Thread.currentThread().interrupt();
    }
    
    public InterruptedRuntimeException(@Nullable final String s, @Nullable final InterruptedException ex) {
        super(s, ex);
        Thread.currentThread().interrupt();
    }
}
