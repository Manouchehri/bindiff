package com.google.protobuf;

import java.util.*;

public class UnmodifiableLazyStringList extends AbstractList implements LazyStringList, RandomAccess
{
    private final LazyStringList list;
    
    public UnmodifiableLazyStringList(final LazyStringList list) {
        this.list = list;
    }
    
    public String get(final int n) {
        return this.list.get(n);
    }
    
    public int size() {
        return this.list.size();
    }
    
    public ByteString getByteString(final int n) {
        return this.list.getByteString(n);
    }
    
    public void add(final ByteString byteString) {
        throw new UnsupportedOperationException();
    }
    
    public void set(final int n, final ByteString byteString) {
        throw new UnsupportedOperationException();
    }
    
    public boolean addAllByteString(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    public byte[] getByteArray(final int n) {
        return this.list.getByteArray(n);
    }
    
    public void add(final byte[] array) {
        throw new UnsupportedOperationException();
    }
    
    public void set(final int n, final byte[] array) {
        throw new UnsupportedOperationException();
    }
    
    public boolean addAllByteArray(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    public ListIterator listIterator(final int n) {
        return new UnmodifiableLazyStringList$1(this, n);
    }
    
    public Iterator iterator() {
        return new UnmodifiableLazyStringList$2(this);
    }
    
    public List getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }
    
    public void mergeFrom(final LazyStringList list) {
        throw new UnsupportedOperationException();
    }
    
    public List asByteArrayList() {
        return Collections.unmodifiableList((List<?>)this.list.asByteArrayList());
    }
    
    public List asByteStringList() {
        return Collections.unmodifiableList((List<?>)this.list.asByteStringList());
    }
    
    public LazyStringList getUnmodifiableView() {
        return this;
    }
}
