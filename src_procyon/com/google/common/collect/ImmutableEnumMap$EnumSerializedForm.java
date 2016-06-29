package com.google.common.collect;

import java.io.*;
import java.util.*;

class ImmutableEnumMap$EnumSerializedForm implements Serializable
{
    final EnumMap delegate;
    private static final long serialVersionUID = 0L;
    
    ImmutableEnumMap$EnumSerializedForm(final EnumMap delegate) {
        this.delegate = delegate;
    }
    
    Object readResolve() {
        return new ImmutableEnumMap(this.delegate, null);
    }
}
