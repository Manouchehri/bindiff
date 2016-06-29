package com.google.protobuf;

import java.util.*;

class ProtobufArrayList extends AbstractProtobufList
{
    private static final ProtobufArrayList EMPTY_LIST;
    private final List list;
    
    public static ProtobufArrayList emptyList() {
        return ProtobufArrayList.EMPTY_LIST;
    }
    
    ProtobufArrayList() {
        this.list = new ArrayList();
    }
    
    ProtobufArrayList(final List list) {
        this.list = new ArrayList(list);
    }
    
    public void add(final int n, final Object o) {
        this.ensureIsMutable();
        this.list.add(n, o);
        ++this.modCount;
    }
    
    public Object get(final int n) {
        return this.list.get(n);
    }
    
    public Object remove(final int n) {
        this.ensureIsMutable();
        final Object remove = this.list.remove(n);
        ++this.modCount;
        return remove;
    }
    
    public Object set(final int n, final Object o) {
        this.ensureIsMutable();
        final Object set = this.list.set(n, o);
        ++this.modCount;
        return set;
    }
    
    public int size() {
        return this.list.size();
    }
    
    static {
        (EMPTY_LIST = new ProtobufArrayList()).makeImmutable();
    }
}
