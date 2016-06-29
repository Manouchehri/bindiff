/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultiset$1;
import com.google.common.collect.AbstractMapBasedMultiset$MapBasedMultisetIterator;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Count;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
abstract class AbstractMapBasedMultiset
extends AbstractMultiset
implements Serializable {
    private transient Map backingMap;
    private transient long size;
    @GwtIncompatible(value="not needed in emulated source.")
    private static final long serialVersionUID = -2250766705698539974L;

    protected AbstractMapBasedMultiset(Map map) {
        this.backingMap = (Map)Preconditions.checkNotNull(map);
        this.size = super.size();
    }

    void setBackingMap(Map map) {
        this.backingMap = map;
    }

    @Override
    public Set entrySet() {
        return super.entrySet();
    }

    @Override
    Iterator entryIterator() {
        Iterator iterator = this.backingMap.entrySet().iterator();
        return new AbstractMapBasedMultiset$1(this, iterator);
    }

    @Override
    public void clear() {
        Iterator iterator = this.backingMap.values().iterator();
        do {
            if (!iterator.hasNext()) {
                this.backingMap.clear();
                this.size = 0;
                return;
            }
            Count count = (Count)iterator.next();
            count.set(0);
        } while (true);
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
    public int count(@Nullable Object object) {
        Count count = (Count)Maps.safeGet(this.backingMap, object);
        if (count == null) {
            return 0;
        }
        int n2 = count.get();
        return n2;
    }

    @Override
    public int add(@Nullable Object object, int n2) {
        int n3;
        if (n2 == 0) {
            return this.count(object);
        }
        Preconditions.checkArgument(n2 > 0, "occurrences cannot be negative: %s", n2);
        Count count = (Count)this.backingMap.get(object);
        if (count == null) {
            n3 = 0;
            this.backingMap.put(object, new Count(n2));
        } else {
            n3 = count.get();
            long l2 = (long)n3 + (long)n2;
            Preconditions.checkArgument(l2 <= Integer.MAX_VALUE, "too many occurrences: %s", l2);
            count.getAndAdd(n2);
        }
        this.size += (long)n2;
        return n3;
    }

    @Override
    public int remove(@Nullable Object object, int n2) {
        int n3;
        if (n2 == 0) {
            return this.count(object);
        }
        Preconditions.checkArgument(n2 > 0, "occurrences cannot be negative: %s", n2);
        Count count = (Count)this.backingMap.get(object);
        if (count == null) {
            return 0;
        }
        int n4 = count.get();
        if (n4 > n2) {
            n3 = n2;
        } else {
            n3 = n4;
            this.backingMap.remove(object);
        }
        count.addAndGet(- n3);
        this.size -= (long)n3;
        return n4;
    }

    @Override
    public int setCount(@Nullable Object object, int n2) {
        int n3;
        CollectPreconditions.checkNonnegative(n2, "count");
        if (n2 == 0) {
            Count count = (Count)this.backingMap.remove(object);
            n3 = AbstractMapBasedMultiset.getAndSet(count, n2);
        } else {
            Count count = (Count)this.backingMap.get(object);
            n3 = AbstractMapBasedMultiset.getAndSet(count, n2);
            if (count == null) {
                this.backingMap.put(object, new Count(n2));
            }
        }
        this.size += (long)(n2 - n3);
        return n3;
    }

    private static int getAndSet(Count count, int n2) {
        if (count != null) return count.getAndSet(n2);
        return 0;
    }

    @GwtIncompatible(value="java.io.ObjectStreamException")
    private void readObjectNoData() {
        throw new InvalidObjectException("Stream data required");
    }

    static /* synthetic */ Map access$000(AbstractMapBasedMultiset abstractMapBasedMultiset) {
        return abstractMapBasedMultiset.backingMap;
    }

    static /* synthetic */ long access$100(AbstractMapBasedMultiset abstractMapBasedMultiset) {
        return abstractMapBasedMultiset.size;
    }

    static /* synthetic */ long access$102(AbstractMapBasedMultiset abstractMapBasedMultiset, long l2) {
        abstractMapBasedMultiset.size = l2;
        return abstractMapBasedMultiset.size;
    }

    static /* synthetic */ long access$110(AbstractMapBasedMultiset abstractMapBasedMultiset) {
        return abstractMapBasedMultiset.size--;
    }
}

