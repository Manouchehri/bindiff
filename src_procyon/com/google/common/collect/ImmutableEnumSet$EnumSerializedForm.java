package com.google.common.collect;

import java.io.*;
import java.util.*;

class ImmutableEnumSet$EnumSerializedForm implements Serializable
{
    final EnumSet delegate;
    private static final long serialVersionUID = 0L;
    
    ImmutableEnumSet$EnumSerializedForm(final EnumSet delegate) {
        this.delegate = delegate;
    }
    
    Object readResolve() {
        return new ImmutableEnumSet(this.delegate.clone(), null);
    }
}
