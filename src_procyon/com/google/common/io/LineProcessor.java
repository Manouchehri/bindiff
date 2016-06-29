package com.google.common.io;

import com.google.common.annotations.*;

@Beta
public interface LineProcessor
{
    boolean processLine(final String p0);
    
    Object getResult();
}
