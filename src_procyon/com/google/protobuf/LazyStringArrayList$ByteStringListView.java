package com.google.protobuf;

import java.util.*;

class LazyStringArrayList$ByteStringListView extends AbstractList implements RandomAccess
{
    private final LazyStringArrayList list;
    
    LazyStringArrayList$ByteStringListView(final LazyStringArrayList list) {
        this.list = list;
    }
    
    public ByteString get(final int n) {
        return this.list.getByteString(n);
    }
    
    public int size() {
        return this.list.size();
    }
    
    public ByteString set(final int n, final ByteString byteString) {
        final Object access$300 = this.list.setAndReturn(n, byteString);
        ++this.modCount;
        return asByteString(access$300);
    }
    
    public void add(final int n, final ByteString byteString) {
        this.list.add(n, byteString);
        ++this.modCount;
    }
    
    public ByteString remove(final int n) {
        final String remove = this.list.remove(n);
        ++this.modCount;
        return asByteString(remove);
    }
}
