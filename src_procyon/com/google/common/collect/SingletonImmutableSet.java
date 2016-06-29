package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.errorprone.annotations.concurrent.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
final class SingletonImmutableSet extends ImmutableSet
{
    final transient Object element;
    @LazyInit
    private transient int cachedHashCode;
    
    SingletonImmutableSet(final Object o) {
        this.element = Preconditions.checkNotNull(o);
    }
    
    SingletonImmutableSet(final Object element, final int cachedHashCode) {
        this.element = element;
        this.cachedHashCode = cachedHashCode;
    }
    
    @Override
    public int size() {
        return 1;
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.element.equals(o);
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return Iterators.singletonIterator(this.element);
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    int copyIntoArray(final Object[] array, final int n) {
        array[n] = this.element;
        return n + 1;
    }
    
    @Override
    public final int hashCode() {
        int cachedHashCode = this.cachedHashCode;
        if (cachedHashCode == 0) {
            cachedHashCode = (this.cachedHashCode = this.element.hashCode());
        }
        return cachedHashCode;
    }
    
    @Override
    boolean isHashCodeFast() {
        return this.cachedHashCode != 0;
    }
    
    @Override
    public String toString() {
        final String string = this.element.toString();
        return new StringBuilder(string.length() + 2).append('[').append(string).append(']').toString();
    }
}
