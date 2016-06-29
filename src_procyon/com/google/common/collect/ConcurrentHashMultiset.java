package com.google.common.collect;

import java.util.concurrent.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.concurrent.atomic.*;
import com.google.common.primitives.*;
import com.google.common.math.*;
import java.util.*;
import java.io.*;

public final class ConcurrentHashMultiset extends AbstractMultiset implements Serializable
{
    private final transient ConcurrentMap countMap;
    private static final long serialVersionUID = 1L;
    
    public static ConcurrentHashMultiset create() {
        return new ConcurrentHashMultiset(new ConcurrentHashMap());
    }
    
    public static ConcurrentHashMultiset create(final Iterable iterable) {
        final ConcurrentHashMultiset create = create();
        Iterables.addAll(create, iterable);
        return create;
    }
    
    @Beta
    public static ConcurrentHashMultiset create(final MapMaker mapMaker) {
        return new ConcurrentHashMultiset(mapMaker.makeMap());
    }
    
    ConcurrentHashMultiset(final ConcurrentMap countMap) {
        Preconditions.checkArgument(countMap.isEmpty());
        this.countMap = countMap;
    }
    
    @Override
    public int count(@Nullable final Object o) {
        final AtomicInteger atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, o);
        return (atomicInteger == null) ? 0 : atomicInteger.get();
    }
    
    @Override
    public int size() {
        long n = 0L;
        final Iterator iterator = this.countMap.values().iterator();
        while (iterator.hasNext()) {
            n += iterator.next().get();
        }
        return Ints.saturatedCast(n);
    }
    
    @Override
    public Object[] toArray() {
        return this.snapshot().toArray();
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return this.snapshot().toArray(array);
    }
    
    private List snapshot() {
        final ArrayList arrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(this.size());
        for (final Multiset$Entry multiset$Entry : this.entrySet()) {
            final Object element = multiset$Entry.getElement();
            for (int i = multiset$Entry.getCount(); i > 0; --i) {
                arrayListWithExpectedSize.add(element);
            }
        }
        return arrayListWithExpectedSize;
    }
    
    @Override
    public int add(final Object o, final int n) {
        Preconditions.checkNotNull(o);
        if (n == 0) {
            return this.count(o);
        }
        Preconditions.checkArgument(n > 0, "Invalid occurrences: %s", n);
        while (true) {
            AtomicInteger atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, o);
            if (atomicInteger == null) {
                atomicInteger = this.countMap.putIfAbsent(o, new AtomicInteger(n));
                if (atomicInteger == null) {
                    return 0;
                }
            }
            while (true) {
                final int value = atomicInteger.get();
                if (value != 0) {
                    try {
                        if (atomicInteger.compareAndSet(value, IntMath.checkedAdd(value, n))) {
                            return value;
                        }
                        continue;
                    }
                    catch (ArithmeticException ex) {
                        throw new IllegalArgumentException(new StringBuilder(65).append("Overflow adding ").append(n).append(" occurrences to a count of ").append(value).toString());
                    }
                    break;
                }
                break;
            }
            final AtomicInteger atomicInteger2 = new AtomicInteger(n);
            if (this.countMap.putIfAbsent(o, atomicInteger2) == null || this.countMap.replace(o, atomicInteger, atomicInteger2)) {
                return 0;
            }
        }
    }
    
    @Override
    public int remove(@Nullable final Object o, final int n) {
        if (n == 0) {
            return this.count(o);
        }
        Preconditions.checkArgument(n > 0, "Invalid occurrences: %s", n);
        final AtomicInteger atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, o);
        if (atomicInteger == null) {
            return 0;
        }
        while (true) {
            final int value = atomicInteger.get();
            if (value == 0) {
                return 0;
            }
            final int max = Math.max(0, value - n);
            if (atomicInteger.compareAndSet(value, max)) {
                if (max == 0) {
                    this.countMap.remove(o, atomicInteger);
                }
                return value;
            }
        }
    }
    
    public boolean removeExactly(@Nullable final Object o, final int n) {
        if (n == 0) {
            return true;
        }
        Preconditions.checkArgument(n > 0, "Invalid occurrences: %s", n);
        final AtomicInteger atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, o);
        if (atomicInteger == null) {
            return false;
        }
        while (true) {
            final int value = atomicInteger.get();
            if (value < n) {
                return false;
            }
            final int n2 = value - n;
            if (atomicInteger.compareAndSet(value, n2)) {
                if (n2 == 0) {
                    this.countMap.remove(o, atomicInteger);
                }
                return true;
            }
        }
    }
    
    @Override
    public int setCount(final Object o, final int n) {
        Preconditions.checkNotNull(o);
        CollectPreconditions.checkNonnegative(n, "count");
        while (true) {
            AtomicInteger atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, o);
            if (atomicInteger == null) {
                if (n == 0) {
                    return 0;
                }
                atomicInteger = this.countMap.putIfAbsent(o, new AtomicInteger(n));
                if (atomicInteger == null) {
                    return 0;
                }
            }
            while (true) {
                final int value = atomicInteger.get();
                if (value == 0) {
                    if (n == 0) {
                        return 0;
                    }
                    final AtomicInteger atomicInteger2 = new AtomicInteger(n);
                    if (this.countMap.putIfAbsent(o, atomicInteger2) == null || this.countMap.replace(o, atomicInteger, atomicInteger2)) {
                        return 0;
                    }
                    break;
                }
                else {
                    if (atomicInteger.compareAndSet(value, n)) {
                        if (n == 0) {
                            this.countMap.remove(o, atomicInteger);
                        }
                        return value;
                    }
                    continue;
                }
            }
        }
    }
    
    @Override
    public boolean setCount(final Object o, final int n, final int n2) {
        Preconditions.checkNotNull(o);
        CollectPreconditions.checkNonnegative(n, "oldCount");
        CollectPreconditions.checkNonnegative(n2, "newCount");
        final AtomicInteger atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, o);
        if (atomicInteger == null) {
            return n == 0 && (n2 == 0 || this.countMap.putIfAbsent(o, new AtomicInteger(n2)) == null);
        }
        final int value = atomicInteger.get();
        if (value == n) {
            if (value == 0) {
                if (n2 == 0) {
                    this.countMap.remove(o, atomicInteger);
                    return true;
                }
                final AtomicInteger atomicInteger2 = new AtomicInteger(n2);
                return this.countMap.putIfAbsent(o, atomicInteger2) == null || this.countMap.replace(o, atomicInteger, atomicInteger2);
            }
            else if (atomicInteger.compareAndSet(value, n2)) {
                if (n2 == 0) {
                    this.countMap.remove(o, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }
    
    @Override
    Set createElementSet() {
        return new ConcurrentHashMultiset$1(this, this.countMap.keySet());
    }
    
    public Set createEntrySet() {
        return new ConcurrentHashMultiset$EntrySet(this, null);
    }
    
    @Override
    int distinctElements() {
        return this.countMap.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }
    
    @Override
    Iterator entryIterator() {
        return new ConcurrentHashMultiset$3(this, new ConcurrentHashMultiset$2(this));
    }
    
    @Override
    public void clear() {
        this.countMap.clear();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        ConcurrentHashMultiset$FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set(this, objectInputStream.readObject());
    }
}
