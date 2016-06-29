package com.google.common.collect;

import java.util.*;
import javax.annotation.*;

class Synchronized$SynchronizedRandomAccessList extends Synchronized$SynchronizedList implements RandomAccess
{
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedRandomAccessList(final List list, @Nullable final Object o) {
        super(list, o);
    }
}
