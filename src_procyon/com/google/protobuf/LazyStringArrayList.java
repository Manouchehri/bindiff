package com.google.protobuf;

import java.util.*;

public class LazyStringArrayList extends AbstractProtobufList implements LazyStringList, RandomAccess
{
    private static final LazyStringArrayList EMPTY_LIST;
    public static final LazyStringList EMPTY;
    private final List list;
    
    static LazyStringArrayList emptyList() {
        return LazyStringArrayList.EMPTY_LIST;
    }
    
    public LazyStringArrayList() {
        this.list = new ArrayList();
    }
    
    public LazyStringArrayList(final int n) {
        this.list = new ArrayList(n);
    }
    
    public LazyStringArrayList(final LazyStringList list) {
        this.list = new ArrayList(list.size());
        this.addAll(list);
    }
    
    public LazyStringArrayList(final List list) {
        this.list = new ArrayList(list);
    }
    
    public String get(final int n) {
        final byte[] value = this.list.get(n);
        if (value instanceof String) {
            return (String)(Object)value;
        }
        if (value instanceof ByteString) {
            final ByteString byteString = (Object)value;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.list.set(n, stringUtf8);
            }
            return stringUtf8;
        }
        final byte[] array = value;
        final String stringUtf9 = Internal.toStringUtf8(array);
        if (Internal.isValidUtf8(array)) {
            this.list.set(n, stringUtf9);
        }
        return stringUtf9;
    }
    
    public int size() {
        return this.list.size();
    }
    
    public String set(final int n, final String s) {
        this.ensureIsMutable();
        return asString(this.list.set(n, s));
    }
    
    public void add(final int n, final String s) {
        this.ensureIsMutable();
        this.list.add(n, s);
        ++this.modCount;
    }
    
    private void add(final int n, final ByteString byteString) {
        this.ensureIsMutable();
        this.list.add(n, byteString);
        ++this.modCount;
    }
    
    private void add(final int n, final byte[] array) {
        this.ensureIsMutable();
        this.list.add(n, array);
        ++this.modCount;
    }
    
    public boolean addAll(final Collection collection) {
        return this.addAll(this.size(), collection);
    }
    
    public boolean addAll(final int n, final Collection collection) {
        this.ensureIsMutable();
        final boolean addAll = this.list.addAll(n, (collection instanceof LazyStringList) ? ((LazyStringList)collection).getUnderlyingElements() : collection);
        ++this.modCount;
        return addAll;
    }
    
    public boolean addAllByteString(final Collection collection) {
        this.ensureIsMutable();
        final boolean addAll = this.list.addAll(collection);
        ++this.modCount;
        return addAll;
    }
    
    public boolean addAllByteArray(final Collection collection) {
        this.ensureIsMutable();
        final boolean addAll = this.list.addAll(collection);
        ++this.modCount;
        return addAll;
    }
    
    public String remove(final int n) {
        this.ensureIsMutable();
        final Object remove = this.list.remove(n);
        ++this.modCount;
        return asString(remove);
    }
    
    public void clear() {
        this.ensureIsMutable();
        this.list.clear();
        ++this.modCount;
    }
    
    public void add(final ByteString byteString) {
        this.ensureIsMutable();
        this.list.add(byteString);
        ++this.modCount;
    }
    
    public void add(final byte[] array) {
        this.ensureIsMutable();
        this.list.add(array);
        ++this.modCount;
    }
    
    public ByteString getByteString(final int n) {
        final ByteString value = this.list.get(n);
        final ByteString byteString = asByteString(value);
        if (byteString != value) {
            this.list.set(n, byteString);
        }
        return byteString;
    }
    
    public byte[] getByteArray(final int n) {
        final byte[] value = this.list.get(n);
        final byte[] byteArray = asByteArray(value);
        if (byteArray != value) {
            this.list.set(n, byteArray);
        }
        return byteArray;
    }
    
    public void set(final int n, final ByteString byteString) {
        this.setAndReturn(n, byteString);
    }
    
    private Object setAndReturn(final int n, final ByteString byteString) {
        this.ensureIsMutable();
        return this.list.set(n, byteString);
    }
    
    public void set(final int n, final byte[] array) {
        this.setAndReturn(n, array);
    }
    
    private Object setAndReturn(final int n, final byte[] array) {
        this.ensureIsMutable();
        return this.list.set(n, array);
    }
    
    private static String asString(final Object o) {
        if (o instanceof String) {
            return (String)o;
        }
        if (o instanceof ByteString) {
            return ((ByteString)o).toStringUtf8();
        }
        return Internal.toStringUtf8((byte[])o);
    }
    
    private static ByteString asByteString(final Object o) {
        if (o instanceof ByteString) {
            return (ByteString)o;
        }
        if (o instanceof String) {
            return ByteString.copyFromUtf8((String)o);
        }
        return ByteString.copyFrom((byte[])o);
    }
    
    private static byte[] asByteArray(final Object o) {
        if (o instanceof byte[]) {
            return (byte[])o;
        }
        if (o instanceof String) {
            return Internal.toByteArray((String)o);
        }
        return ((ByteString)o).toByteArray();
    }
    
    public List getUnderlyingElements() {
        return Collections.unmodifiableList((List<?>)this.list);
    }
    
    public void mergeFrom(final LazyStringList list) {
        this.ensureIsMutable();
        for (final byte[] next : list.getUnderlyingElements()) {
            if (next instanceof byte[]) {
                final byte[] array = next;
                this.list.add(Arrays.copyOf(array, array.length));
            }
            else {
                this.list.add(next);
            }
        }
    }
    
    public List asByteArrayList() {
        return new LazyStringArrayList$ByteArrayListView(this);
    }
    
    public List asByteStringList() {
        return new LazyStringArrayList$ByteStringListView(this);
    }
    
    public LazyStringList getUnmodifiableView() {
        if (this.isModifiable()) {
            return new UnmodifiableLazyStringList(this);
        }
        return this;
    }
    
    static {
        (EMPTY_LIST = new LazyStringArrayList()).makeImmutable();
        EMPTY = LazyStringArrayList.EMPTY_LIST;
    }
}
