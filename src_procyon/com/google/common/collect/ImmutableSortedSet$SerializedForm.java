package com.google.common.collect;

import java.io.*;
import java.util.*;

class ImmutableSortedSet$SerializedForm implements Serializable
{
    final Comparator comparator;
    final Object[] elements;
    private static final long serialVersionUID = 0L;
    
    public ImmutableSortedSet$SerializedForm(final Comparator comparator, final Object[] elements) {
        this.comparator = comparator;
        this.elements = elements;
    }
    
    Object readResolve() {
        return new ImmutableSortedSet$Builder(this.comparator).add((Object[])this.elements).build();
    }
}
