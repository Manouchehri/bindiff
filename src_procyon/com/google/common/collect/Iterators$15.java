package com.google.common.collect;

import java.util.*;

final class Iterators$15 implements Enumeration
{
    final /* synthetic */ Iterator val$iterator;
    
    Iterators$15(final Iterator val$iterator) {
        this.val$iterator = val$iterator;
    }
    
    @Override
    public boolean hasMoreElements() {
        return this.val$iterator.hasNext();
    }
    
    @Override
    public Object nextElement() {
        return this.val$iterator.next();
    }
}
