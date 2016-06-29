package com.google.common.collect;

import java.util.*;

final class Iterators$2 implements Iterator
{
    @Override
    public boolean hasNext() {
        return false;
    }
    
    @Override
    public Object next() {
        throw new NoSuchElementException();
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(false);
    }
}
