package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;

@GwtIncompatible("serialization")
class ImmutableMapKeySet$KeySetSerializedForm implements Serializable
{
    final ImmutableMap map;
    private static final long serialVersionUID = 0L;
    
    ImmutableMapKeySet$KeySetSerializedForm(final ImmutableMap map) {
        this.map = map;
    }
    
    Object readResolve() {
        return this.map.keySet();
    }
}
