package com.google.common.collect;

import javax.annotation.*;

public interface MapDifference$ValueDifference
{
    Object leftValue();
    
    Object rightValue();
    
    boolean equals(@Nullable final Object p0);
    
    int hashCode();
}
