package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
final class SingletonImmutableList extends ImmutableList
{
    final transient Object element;
    
    SingletonImmutableList(final Object o) {
        this.element = Preconditions.checkNotNull(o);
    }
    
    @Override
    public Object get(final int n) {
        Preconditions.checkElementIndex(n, 1);
        return this.element;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return Iterators.singletonIterator(this.element);
    }
    
    @Override
    public int size() {
        return 1;
    }
    
    @Override
    public ImmutableList subList(final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n2, 1);
        return (n == n2) ? ImmutableList.of() : this;
    }
    
    @Override
    public String toString() {
        final String string = this.element.toString();
        return new StringBuilder(string.length() + 2).append('[').append(string).append(']').toString();
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
}
