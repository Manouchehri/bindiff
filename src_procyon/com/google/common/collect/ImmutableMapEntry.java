package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;

@GwtIncompatible("unnecessary")
class ImmutableMapEntry extends ImmutableEntry
{
    static ImmutableMapEntry[] createEntryArray(final int n) {
        return new ImmutableMapEntry[n];
    }
    
    ImmutableMapEntry(final Object o, final Object o2) {
        super(o, o2);
        CollectPreconditions.checkEntryNotNull(o, o2);
    }
    
    ImmutableMapEntry(final ImmutableMapEntry immutableMapEntry) {
        super(immutableMapEntry.getKey(), immutableMapEntry.getValue());
    }
    
    @Nullable
    ImmutableMapEntry getNextInKeyBucket() {
        return null;
    }
    
    @Nullable
    ImmutableMapEntry getNextInValueBucket() {
        return null;
    }
    
    boolean isReusable() {
        return true;
    }
}
