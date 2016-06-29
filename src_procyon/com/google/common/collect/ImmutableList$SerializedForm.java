package com.google.common.collect;

import java.io.*;

class ImmutableList$SerializedForm implements Serializable
{
    final Object[] elements;
    private static final long serialVersionUID = 0L;
    
    ImmutableList$SerializedForm(final Object[] elements) {
        this.elements = elements;
    }
    
    Object readResolve() {
        return ImmutableList.copyOf(this.elements);
    }
}
