package com.google.common.collect;

import java.io.*;

class ImmutableRangeSet$AsSetSerializedForm implements Serializable
{
    private final ImmutableList ranges;
    private final DiscreteDomain domain;
    
    ImmutableRangeSet$AsSetSerializedForm(final ImmutableList ranges, final DiscreteDomain domain) {
        this.ranges = ranges;
        this.domain = domain;
    }
    
    Object readResolve() {
        return new ImmutableRangeSet(this.ranges).asSet(this.domain);
    }
}
