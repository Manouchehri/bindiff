package com.google.common.collect;

import java.util.*;

final class Iterators$1 extends UnmodifiableListIterator
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
    public boolean hasPrevious() {
        return false;
    }
    
    @Override
    public Object previous() {
        throw new NoSuchElementException();
    }
    
    @Override
    public int nextIndex() {
        return 0;
    }
    
    @Override
    public int previousIndex() {
        return -1;
    }
}
