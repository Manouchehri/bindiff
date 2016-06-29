package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

class Synchronized$SynchronizedAsMapValues extends Synchronized$SynchronizedCollection
{
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedAsMapValues(final Collection collection, @Nullable final Object o) {
        super(collection, o, null);
    }
    
    @Override
    public Iterator iterator() {
        return new Synchronized$SynchronizedAsMapValues$1(this, super.iterator());
    }
}
