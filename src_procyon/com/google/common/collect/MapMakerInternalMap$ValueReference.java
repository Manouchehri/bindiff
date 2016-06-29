package com.google.common.collect;

import java.lang.ref.*;
import javax.annotation.*;

interface MapMakerInternalMap$ValueReference
{
    Object get();
    
    Object waitForValue();
    
    MapMakerInternalMap$ReferenceEntry getEntry();
    
    MapMakerInternalMap$ValueReference copyFor(final ReferenceQueue p0, @Nullable final Object p1, final MapMakerInternalMap$ReferenceEntry p2);
    
    void clear(@Nullable final MapMakerInternalMap$ValueReference p0);
    
    boolean isComputingReference();
}
