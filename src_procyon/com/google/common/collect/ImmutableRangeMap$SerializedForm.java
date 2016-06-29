package com.google.common.collect;

import java.io.*;
import java.util.*;

class ImmutableRangeMap$SerializedForm implements Serializable
{
    private final ImmutableMap mapOfRanges;
    private static final long serialVersionUID = 0L;
    
    ImmutableRangeMap$SerializedForm(final ImmutableMap mapOfRanges) {
        this.mapOfRanges = mapOfRanges;
    }
    
    Object readResolve() {
        if (this.mapOfRanges.isEmpty()) {
            return ImmutableRangeMap.of();
        }
        return this.createRangeMap();
    }
    
    Object createRangeMap() {
        final ImmutableRangeMap$Builder immutableRangeMap$Builder = new ImmutableRangeMap$Builder();
        for (final Map.Entry<Range, V> entry : this.mapOfRanges.entrySet()) {
            immutableRangeMap$Builder.put(entry.getKey(), entry.getValue());
        }
        return immutableRangeMap$Builder.build();
    }
}
