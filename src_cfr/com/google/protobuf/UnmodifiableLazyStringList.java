/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList$1;
import com.google.protobuf.UnmodifiableLazyStringList$2;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList
extends AbstractList
implements LazyStringList,
RandomAccess {
    private final LazyStringList list;

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.list = lazyStringList;
    }

    public String get(int n2) {
        return (String)this.list.get(n2);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public ByteString getByteString(int n2) {
        return this.list.getByteString(n2);
    }

    @Override
    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(int n2, ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAllByteString(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] getByteArray(int n2) {
        return this.list.getByteArray(n2);
    }

    @Override
    public void add(byte[] arrby) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(int n2, byte[] arrby) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAllByteArray(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public ListIterator listIterator(int n2) {
        return new UnmodifiableLazyStringList$1(this, n2);
    }

    @Override
    public Iterator iterator() {
        return new UnmodifiableLazyStringList$2(this);
    }

    @Override
    public List getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    @Override
    public void mergeFrom(LazyStringList lazyStringList) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List asByteArrayList() {
        return Collections.unmodifiableList(this.list.asByteArrayList());
    }

    @Override
    public List asByteStringList() {
        return Collections.unmodifiableList(this.list.asByteStringList());
    }

    @Override
    public LazyStringList getUnmodifiableView() {
        return this;
    }

    static /* synthetic */ LazyStringList access$000(UnmodifiableLazyStringList unmodifiableLazyStringList) {
        return unmodifiableLazyStringList.list;
    }
}

