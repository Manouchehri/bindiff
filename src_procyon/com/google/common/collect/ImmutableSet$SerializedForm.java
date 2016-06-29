package com.google.common.collect;

import java.io.*;

class ImmutableSet$SerializedForm implements Serializable
{
    final Object[] elements;
    private static final long serialVersionUID = 0L;
    
    ImmutableSet$SerializedForm(final Object[] elements) {
        this.elements = elements;
    }
    
    Object readResolve() {
        return ImmutableSet.copyOf(this.elements);
    }
}
