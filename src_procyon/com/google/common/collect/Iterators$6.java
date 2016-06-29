package com.google.common.collect;

import java.util.*;

final class Iterators$6 extends UnmodifiableIterator
{
    final /* synthetic */ Iterator val$iterator;
    final /* synthetic */ int val$size;
    final /* synthetic */ boolean val$pad;
    
    Iterators$6(final Iterator val$iterator, final int val$size, final boolean val$pad) {
        this.val$iterator = val$iterator;
        this.val$size = val$size;
        this.val$pad = val$pad;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }
    
    @Override
    public List next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        final Object[] array = new Object[this.val$size];
        int n;
        for (n = 0; n < this.val$size && this.val$iterator.hasNext(); ++n) {
            array[n] = this.val$iterator.next();
        }
        for (int i = n; i < this.val$size; ++i) {
            array[i] = null;
        }
        final List<Object> unmodifiableList = Collections.unmodifiableList((List<?>)Arrays.asList((T[])array));
        return (this.val$pad || n == this.val$size) ? unmodifiableList : unmodifiableList.subList(0, n);
    }
}
