package org.jfree.util;

import java.util.*;

final class HashNMap$EmptyIterator implements Iterator
{
    private HashNMap$EmptyIterator() {
    }
    
    public boolean hasNext() {
        return false;
    }
    
    public Object next() {
        throw new NoSuchElementException("This iterator is empty.");
    }
    
    public void remove() {
        throw new UnsupportedOperationException("This iterator is empty, no remove supported.");
    }
    
    HashNMap$EmptyIterator(final HashNMap$1 hashNMap$1) {
        this();
    }
}
