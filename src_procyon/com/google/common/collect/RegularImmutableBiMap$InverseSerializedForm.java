package com.google.common.collect;

import java.io.*;

class RegularImmutableBiMap$InverseSerializedForm implements Serializable
{
    private final ImmutableBiMap forward;
    private static final long serialVersionUID = 1L;
    
    RegularImmutableBiMap$InverseSerializedForm(final ImmutableBiMap forward) {
        this.forward = forward;
    }
    
    Object readResolve() {
        return this.forward.inverse();
    }
}
