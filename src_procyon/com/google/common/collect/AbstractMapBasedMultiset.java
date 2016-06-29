package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.primitives.*;
import javax.annotation.*;
import java.io.*;

@GwtCompatible(emulated = true)
abstract class AbstractMapBasedMultiset extends AbstractMultiset implements Serializable
{
    private transient Map backingMap;
    private transient long size;
    @GwtIncompatible("not needed in emulated source.")
    private static final long serialVersionUID = -2250766705698539974L;
    
    protected AbstractMapBasedMultiset(final Map map) {
        this.backingMap = (Map)Preconditions.checkNotNull(map);
        this.size = super.size();
    }
    
    void setBackingMap(final Map backingMap) {
        this.backingMap = backingMap;
    }
    
    @Override
    public Set entrySet() {
        return super.entrySet();
    }
    
    @Override
    Iterator entryIterator() {
        return new AbstractMapBasedMultiset$1(this, this.backingMap.entrySet().iterator());
    }
    
    @Override
    public void clear() {
        final Iterator<Count> iterator = this.backingMap.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().set(0);
        }
        this.backingMap.clear();
        this.size = 0L;
    }
    
    @Override
    int distinctElements() {
        return this.backingMap.size();
    }
    
    @Override
    public int size() {
        return Ints.saturatedCast(this.size);
    }
    
    @Override
    public Iterator iterator() {
        return new AbstractMapBasedMultiset$MapBasedMultisetIterator(this);
    }
    
    @Override
    public int count(@Nullable final Object o) {
        final Count count = (Count)Maps.safeGet(this.backingMap, o);
        return (count == null) ? 0 : count.get();
    }
    
    @Override
    public int add(@Nullable final Object o, final int n) {
        if (n == 0) {
            return this.count(o);
        }
        Preconditions.checkArgument(n > 0, "occurrences cannot be negative: %s", n);
        final Count count = this.backingMap.get(o);
        int value;
        if (count == null) {
            value = 0;
            this.backingMap.put(o, new Count(n));
        }
        else {
            value = count.get();
            final long n2 = value + n;
            Preconditions.checkArgument(n2 <= 2147483647L, "too many occurrences: %s", n2);
            count.getAndAdd(n);
        }
        this.size += n;
        return value;
    }
    
    @Override
    public int remove(@Nullable final Object o, final int n) {
        if (n == 0) {
            return this.count(o);
        }
        Preconditions.checkArgument(n > 0, "occurrences cannot be negative: %s", n);
        final Count count = this.backingMap.get(o);
        if (count == null) {
            return 0;
        }
        final int value = count.get();
        int n2;
        if (value > n) {
            n2 = n;
        }
        else {
            n2 = value;
            this.backingMap.remove(o);
        }
        count.addAndGet(-n2);
        this.size -= n2;
        return value;
    }
    
    @Override
    public int setCount(@Nullable final Object o, final int n) {
        CollectPreconditions.checkNonnegative(n, "count");
        int n2;
        if (n == 0) {
            n2 = getAndSet(this.backingMap.remove(o), n);
        }
        else {
            final Count count = this.backingMap.get(o);
            n2 = getAndSet(count, n);
            if (count == null) {
                this.backingMap.put(o, new Count(n));
            }
        }
        this.size += n - n2;
        return n2;
    }
    
    private static int getAndSet(final Count count, final int n) {
        if (count == null) {
            return 0;
        }
        return count.getAndSet(n);
    }
    
    @GwtIncompatible("java.io.ObjectStreamException")
    private void readObjectNoData() {
        throw new InvalidObjectException("Stream data required");
    }
}
