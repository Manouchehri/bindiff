package com.google.common.collect;

import java.util.*;

final class Iterators$14 extends UnmodifiableIterator
{
    final /* synthetic */ Enumeration val$enumeration;
    
    Iterators$14(final Enumeration val$enumeration) {
        this.val$enumeration = val$enumeration;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$enumeration.hasMoreElements();
    }
    
    @Override
    public Object next() {
        return this.val$enumeration.nextElement();
    }
}
