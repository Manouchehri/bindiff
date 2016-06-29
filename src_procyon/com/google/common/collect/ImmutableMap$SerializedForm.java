package com.google.common.collect;

import java.io.*;
import java.util.*;

class ImmutableMap$SerializedForm implements Serializable
{
    private final Object[] keys;
    private final Object[] values;
    private static final long serialVersionUID = 0L;
    
    ImmutableMap$SerializedForm(final ImmutableMap immutableMap) {
        this.keys = new Object[immutableMap.size()];
        this.values = new Object[immutableMap.size()];
        int n = 0;
        for (final Map.Entry<Object, V> entry : immutableMap.entrySet()) {
            this.keys[n] = entry.getKey();
            this.values[n] = entry.getValue();
            ++n;
        }
    }
    
    Object readResolve() {
        return this.createMap(new ImmutableMap$Builder(this.keys.length));
    }
    
    Object createMap(final ImmutableMap$Builder immutableMap$Builder) {
        for (int i = 0; i < this.keys.length; ++i) {
            immutableMap$Builder.put(this.keys[i], this.values[i]);
        }
        return immutableMap$Builder.build();
    }
}
