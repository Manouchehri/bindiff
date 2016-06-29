package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;

@GwtIncompatible("serialization")
class ImmutableMapEntrySet$EntrySetSerializedForm implements Serializable
{
    final ImmutableMap map;
    private static final long serialVersionUID = 0L;
    
    ImmutableMapEntrySet$EntrySetSerializedForm(final ImmutableMap map) {
        this.map = map;
    }
    
    Object readResolve() {
        return this.map.entrySet();
    }
}
