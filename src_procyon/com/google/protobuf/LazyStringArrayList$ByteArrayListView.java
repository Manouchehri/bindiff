package com.google.protobuf;

import java.util.*;

class LazyStringArrayList$ByteArrayListView extends AbstractList implements RandomAccess
{
    private final LazyStringArrayList list;
    
    LazyStringArrayList$ByteArrayListView(final LazyStringArrayList list) {
        this.list = list;
    }
    
    public byte[] get(final int n) {
        return this.list.getByteArray(n);
    }
    
    public int size() {
        return this.list.size();
    }
    
    public byte[] set(final int n, final byte[] array) {
        final Object access$000 = this.list.setAndReturn(n, array);
        ++this.modCount;
        return asByteArray(access$000);
    }
    
    public void add(final int n, final byte[] array) {
        this.list.add(n, array);
        ++this.modCount;
    }
    
    public byte[] remove(final int n) {
        final String remove = this.list.remove(n);
        ++this.modCount;
        return asByteArray(remove);
    }
}
