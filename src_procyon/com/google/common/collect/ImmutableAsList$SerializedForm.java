package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;

@GwtIncompatible("serialization")
class ImmutableAsList$SerializedForm implements Serializable
{
    final ImmutableCollection collection;
    private static final long serialVersionUID = 0L;
    
    ImmutableAsList$SerializedForm(final ImmutableCollection collection) {
        this.collection = collection;
    }
    
    Object readResolve() {
        return this.collection.asList();
    }
}
