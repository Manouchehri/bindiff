package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;

@GwtIncompatible("serialization")
class ImmutableMapValues$SerializedForm implements Serializable
{
    final ImmutableMap map;
    private static final long serialVersionUID = 0L;
    
    ImmutableMapValues$SerializedForm(final ImmutableMap map) {
        this.map = map;
    }
    
    Object readResolve() {
        return this.map.values();
    }
}
