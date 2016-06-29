package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;

@GwtIncompatible("serialization")
final class RegularContiguousSet$SerializedForm implements Serializable
{
    final Range range;
    final DiscreteDomain domain;
    
    private RegularContiguousSet$SerializedForm(final Range range, final DiscreteDomain domain) {
        this.range = range;
        this.domain = domain;
    }
    
    private Object readResolve() {
        return new RegularContiguousSet(this.range, this.domain);
    }
}
