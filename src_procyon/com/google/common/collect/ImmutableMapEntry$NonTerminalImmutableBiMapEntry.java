package com.google.common.collect;

import javax.annotation.*;

final class ImmutableMapEntry$NonTerminalImmutableBiMapEntry extends ImmutableMapEntry$NonTerminalImmutableMapEntry
{
    private final transient ImmutableMapEntry nextInValueBucket;
    
    ImmutableMapEntry$NonTerminalImmutableBiMapEntry(final Object o, final Object o2, final ImmutableMapEntry immutableMapEntry, final ImmutableMapEntry nextInValueBucket) {
        super(o, o2, immutableMapEntry);
        this.nextInValueBucket = nextInValueBucket;
    }
    
    @Nullable
    @Override
    ImmutableMapEntry getNextInValueBucket() {
        return this.nextInValueBucket;
    }
}
