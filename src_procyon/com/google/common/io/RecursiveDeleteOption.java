package com.google.common.io;

import com.google.common.annotations.*;

@GoogleInternal
public enum RecursiveDeleteOption
{
    ALLOW_INSECURE("ALLOW_INSECURE", 0);
    
    private RecursiveDeleteOption(final String s, final int n) {
    }
}
