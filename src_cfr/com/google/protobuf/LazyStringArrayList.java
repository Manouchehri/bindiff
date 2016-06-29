/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList$ByteArrayListView;
import com.google.protobuf.LazyStringArrayList$ByteStringListView;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList
extends AbstractProtobufList
implements LazyStringList,
RandomAccess {
    private static final LazyStringArrayList EMPTY_LIST = new LazyStringArrayList();
    public static final LazyStringList EMPTY;
    private final List list;

    static LazyStringArrayList emptyList() {
        return EMPTY_LIST;
    }

    public LazyStringArrayList() {
        this.list = new ArrayList();
    }

    public LazyStringArrayList(int n2) {
        this.list = new ArrayList(n2);
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.list = new ArrayList(lazyStringList.size());
        this.addAll(lazyStringList);
    }

    public LazyStringArrayList(List list) {
        this.list = new ArrayList(list);
    }

    public String get(int n2) {
        Object e2 = this.list.get(n2);
        if (e2 instanceof String) {
            return (String)e2;
        }
        if (e2 instanceof ByteString) {
            ByteString byteString = (ByteString)e2;
            String string = byteString.toStringUtf8();
            if (!byteString.isValidUtf8()) return string;
            this.list.set(n2, string);
            return string;
        }
        byte[] arrby = (byte[])e2;
        String string = Internal.toStringUtf8(arrby);
        if (!Internal.isValidUtf8(arrby)) return string;
        this.list.set(n2, string);
        return string;
    }

    @Override
    public int size() {
        return this.list.size();
    }

    public String set(int n2, String string) {
        this.ensureIsMutable();
        String string2 = this.list.set(n2, string);
        return LazyStringArrayList.asString(string2);
    }

    public void add(int n2, String string) {
        this.ensureIsMutable();
        this.list.add(n2, string);
        ++this.modCount;
    }

    private void add(int n2, ByteString byteString) {
        this.ensureIsMutable();
        this.list.add(n2, byteString);
        ++this.modCount;
    }

    private void add(int n2, byte[] arrby) {
        this.ensureIsMutable();
        this.list.add(n2, arrby);
        ++this.modCount;
    }

    @Override
    public boolean addAll(Collection collection) {
        return this.addAll(this.size(), collection);
    }

    @Override
    public boolean addAll(int n2, Collection collection) {
        this.ensureIsMutable();
        Collection collection2 = collection instanceof LazyStringList ? ((LazyStringList)collection).getUnderlyingElements() : collection;
        boolean bl2 = this.list.addAll(n2, collection2);
        ++this.modCount;
        return bl2;
    }

    @Override
    public boolean addAllByteString(Collection collection) {
        this.ensureIsMutable();
        boolean bl2 = this.list.addAll(collection);
        ++this.modCount;
        return bl2;
    }

    @Override
    public boolean addAllByteArray(Collection collection) {
        this.ensureIsMutable();
        boolean bl2 = this.list.addAll(collection);
        ++this.modCount;
        return bl2;
    }

    @Override
    public String remove(int n2) {
        this.ensureIsMutable();
        Object e2 = this.list.remove(n2);
        ++this.modCount;
        return LazyStringArrayList.asString(e2);
    }

    @Override
    public void clear() {
        this.ensureIsMutable();
        this.list.clear();
        ++this.modCount;
    }

    @Override
    public void add(ByteString byteString) {
        this.ensureIsMutable();
        this.list.add(byteString);
        ++this.modCount;
    }

    @Override
    public void add(byte[] arrby) {
        this.ensureIsMutable();
        this.list.add(arrby);
        ++this.modCount;
    }

    @Override
    public ByteString getByteString(int n2) {
        Object e2 = this.list.get(n2);
        ByteString byteString = LazyStringArrayList.asByteString(e2);
        if (byteString == e2) return byteString;
        this.list.set(n2, byteString);
        return byteString;
    }

    @Override
    public byte[] getByteArray(int n2) {
        Object e2 = this.list.get(n2);
        byte[] arrby = LazyStringArrayList.asByteArray(e2);
        if (arrby == e2) return arrby;
        this.list.set(n2, arrby);
        return arrby;
    }

    @Override
    public void set(int n2, ByteString byteString) {
        this.setAndReturn(n2, byteString);
    }

    private Object setAndReturn(int n2, ByteString byteString) {
        this.ensureIsMutable();
        return this.list.set(n2, byteString);
    }

    @Override
    public void set(int n2, byte[] arrby) {
        this.setAndReturn(n2, arrby);
    }

    private Object setAndReturn(int n2, byte[] arrby) {
        this.ensureIsMutable();
        return this.list.set(n2, arrby);
    }

    private static String asString(Object object) {
        if (object instanceof String) {
            return (String)object;
        }
        if (!(object instanceof ByteString)) return Internal.toStringUtf8((byte[])object);
        return ((ByteString)object).toStringUtf8();
    }

    private static ByteString asByteString(Object object) {
        if (object instanceof ByteString) {
            return (ByteString)object;
        }
        if (!(object instanceof String)) return ByteString.copyFrom((byte[])object);
        return ByteString.copyFromUtf8((String)object);
    }

    private static byte[] asByteArray(Object object) {
        if (object instanceof byte[]) {
            return (byte[])object;
        }
        if (!(object instanceof String)) return ((ByteString)object).toByteArray();
        return Internal.toByteArray((String)object);
    }

    @Override
    public List getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    @Override
    public void mergeFrom(LazyStringList lazyStringList) {
        this.ensureIsMutable();
        Iterator iterator = lazyStringList.getUnderlyingElements().iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (e2 instanceof byte[]) {
                byte[] arrby = (byte[])e2;
                this.list.add(Arrays.copyOf(arrby, arrby.length));
                continue;
            }
            this.list.add(e2);
        }
    }

    @Override
    public List asByteArrayList() {
        return new LazyStringArrayList$ByteArrayListView(this);
    }

    @Override
    public List asByteStringList() {
        return new LazyStringArrayList$ByteStringListView(this);
    }

    @Override
    public LazyStringList getUnmodifiableView() {
        if (!this.isModifiable()) return this;
        return new UnmodifiableLazyStringList(this);
    }

    static /* synthetic */ Object access$000(LazyStringArrayList lazyStringArrayList, int n2, byte[] arrby) {
        return lazyStringArrayList.setAndReturn(n2, arrby);
    }

    static /* synthetic */ byte[] access$100(Object object) {
        return LazyStringArrayList.asByteArray(object);
    }

    static /* synthetic */ void access$200(LazyStringArrayList lazyStringArrayList, int n2, byte[] arrby) {
        lazyStringArrayList.add(n2, arrby);
    }

    static /* synthetic */ Object access$300(LazyStringArrayList lazyStringArrayList, int n2, ByteString byteString) {
        return lazyStringArrayList.setAndReturn(n2, byteString);
    }

    static /* synthetic */ ByteString access$400(Object object) {
        return LazyStringArrayList.asByteString(object);
    }

    static /* synthetic */ void access$500(LazyStringArrayList lazyStringArrayList, int n2, ByteString byteString) {
        lazyStringArrayList.add(n2, byteString);
    }

    static {
        EMPTY_LIST.makeImmutable();
        EMPTY = EMPTY_LIST;
    }
}

