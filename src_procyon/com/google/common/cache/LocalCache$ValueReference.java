package com.google.common.cache;

import javax.annotation.*;
import java.lang.ref.*;

interface LocalCache$ValueReference
{
    @Nullable
    Object get();
    
    Object waitForValue();
    
    int getWeight();
    
    @Nullable
    LocalCache$ReferenceEntry getEntry();
    
    LocalCache$ValueReference copyFor(final ReferenceQueue p0, @Nullable final Object p1, final LocalCache$ReferenceEntry p2);
    
    void notifyNewValue(@Nullable final Object p0);
    
    boolean isLoading();
    
    boolean isActive();
}
