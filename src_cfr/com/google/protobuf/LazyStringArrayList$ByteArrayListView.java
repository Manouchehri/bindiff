/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.LazyStringArrayList;
import java.util.AbstractList;
import java.util.RandomAccess;

class LazyStringArrayList$ByteArrayListView
extends AbstractList
implements RandomAccess {
    private final LazyStringArrayList list;

    LazyStringArrayList$ByteArrayListView(LazyStringArrayList lazyStringArrayList) {
        this.list = lazyStringArrayList;
    }

    @Override
    public byte[] get(int n2) {
        return this.list.getByteArray(n2);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public byte[] set(int n2, byte[] arrby) {
        Object object = LazyStringArrayList.access$000(this.list, n2, arrby);
        ++this.modCount;
        return LazyStringArrayList.access$100(object);
    }

    @Override
    public void add(int n2, byte[] arrby) {
        LazyStringArrayList.access$200(this.list, n2, arrby);
        ++this.modCount;
    }

    @Override
    public byte[] remove(int n2) {
        String string = this.list.remove(n2);
        ++this.modCount;
        return LazyStringArrayList.access$100(string);
    }
}

