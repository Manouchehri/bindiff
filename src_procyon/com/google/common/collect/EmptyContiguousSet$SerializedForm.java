package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;

@GwtIncompatible("serialization")
final class EmptyContiguousSet$SerializedForm implements Serializable
{
    private final DiscreteDomain domain;
    private static final long serialVersionUID = 0L;
    
    private EmptyContiguousSet$SerializedForm(final DiscreteDomain domain) {
        this.domain = domain;
    }
    
    private Object readResolve() {
        return new EmptyContiguousSet(this.domain);
    }
}
