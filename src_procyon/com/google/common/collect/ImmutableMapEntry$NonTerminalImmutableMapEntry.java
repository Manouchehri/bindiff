package com.google.common.collect;

import javax.annotation.*;

class ImmutableMapEntry$NonTerminalImmutableMapEntry extends ImmutableMapEntry
{
    private final transient ImmutableMapEntry nextInKeyBucket;
    
    ImmutableMapEntry$NonTerminalImmutableMapEntry(final Object o, final Object o2, final ImmutableMapEntry nextInKeyBucket) {
        super(o, o2);
        this.nextInKeyBucket = nextInKeyBucket;
    }
    
    @Nullable
    @Override
    final ImmutableMapEntry getNextInKeyBucket() {
        return this.nextInKeyBucket;
    }
    
    @Override
    final boolean isReusable() {
        return false;
    }
}
