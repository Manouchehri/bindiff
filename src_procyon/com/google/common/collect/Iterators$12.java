package com.google.common.collect;

final class Iterators$12 extends AbstractIndexedListIterator
{
    final /* synthetic */ Object[] val$array;
    final /* synthetic */ int val$offset;
    
    Iterators$12(final int n, final int n2, final Object[] val$array, final int val$offset) {
        this.val$array = val$array;
        this.val$offset = val$offset;
        super(n, n2);
    }
    
    @Override
    protected Object get(final int n) {
        return this.val$array[this.val$offset + n];
    }
}
