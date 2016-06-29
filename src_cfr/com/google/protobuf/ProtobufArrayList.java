/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ProtobufArrayList
extends AbstractProtobufList {
    private static final ProtobufArrayList EMPTY_LIST = new ProtobufArrayList();
    private final List list;

    public static ProtobufArrayList emptyList() {
        return EMPTY_LIST;
    }

    ProtobufArrayList() {
        this.list = new ArrayList();
    }

    ProtobufArrayList(List list) {
        this.list = new ArrayList(list);
    }

    @Override
    public void add(int n2, Object object) {
        this.ensureIsMutable();
        this.list.add(n2, object);
        ++this.modCount;
    }

    public Object get(int n2) {
        return this.list.get(n2);
    }

    @Override
    public Object remove(int n2) {
        this.ensureIsMutable();
        Object e2 = this.list.remove(n2);
        ++this.modCount;
        return e2;
    }

    @Override
    public Object set(int n2, Object object) {
        this.ensureIsMutable();
        Object object2 = this.list.set(n2, object);
        ++this.modCount;
        return object2;
    }

    @Override
    public int size() {
        return this.list.size();
    }

    static {
        EMPTY_LIST.makeImmutable();
    }
}

