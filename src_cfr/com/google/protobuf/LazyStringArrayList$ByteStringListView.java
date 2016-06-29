/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.LazyStringArrayList;
import java.util.AbstractList;
import java.util.RandomAccess;

class LazyStringArrayList$ByteStringListView
extends AbstractList
implements RandomAccess {
    private final LazyStringArrayList list;

    LazyStringArrayList$ByteStringListView(LazyStringArrayList lazyStringArrayList) {
        this.list = lazyStringArrayList;
    }

    @Override
    public ByteString get(int n2) {
        return this.list.getByteString(n2);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public ByteString set(int n2, ByteString byteString) {
        Object object = LazyStringArrayList.access$300(this.list, n2, byteString);
        ++this.modCount;
        return LazyStringArrayList.access$400(object);
    }

    @Override
    public void add(int n2, ByteString byteString) {
        LazyStringArrayList.access$500(this.list, n2, byteString);
        ++this.modCount;
    }

    @Override
    public ByteString remove(int n2) {
        String string = this.list.remove(n2);
        ++this.modCount;
        return LazyStringArrayList.access$400(string);
    }
}

