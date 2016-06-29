package com.google.common.cache;

import java.util.*;
import com.google.common.collect.*;

final class LocalCache$2 extends AbstractQueue
{
    @Override
    public boolean offer(final Object o) {
        return true;
    }
    
    @Override
    public Object peek() {
        return null;
    }
    
    @Override
    public Object poll() {
        return null;
    }
    
    @Override
    public int size() {
        return 0;
    }
    
    @Override
    public Iterator iterator() {
        return ImmutableSet.of().iterator();
    }
}
