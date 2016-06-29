package com.google.common.collect;

import javax.annotation.*;

public interface Table$Cell
{
    @Nullable
    Object getRowKey();
    
    @Nullable
    Object getColumnKey();
    
    @Nullable
    Object getValue();
    
    boolean equals(@Nullable final Object p0);
    
    int hashCode();
}
