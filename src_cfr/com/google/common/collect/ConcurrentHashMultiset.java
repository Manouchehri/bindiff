/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ConcurrentHashMultiset$1;
import com.google.common.collect.ConcurrentHashMultiset$2;
import com.google.common.collect.ConcurrentHashMultiset$3;
import com.google.common.collect.ConcurrentHashMultiset$EntrySet;
import com.google.common.collect.ConcurrentHashMultiset$FieldSettersHolder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Serialization$FieldSetter;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public final class ConcurrentHashMultiset
extends AbstractMultiset
implements Serializable {
    private final transient ConcurrentMap countMap;
    private static final long serialVersionUID = 1;

    public static ConcurrentHashMultiset create() {
        return new ConcurrentHashMultiset(new ConcurrentHashMap());
    }

    public static ConcurrentHashMultiset create(Iterable iterable) {
        ConcurrentHashMultiset concurrentHashMultiset = ConcurrentHashMultiset.create();
        Iterables.addAll(concurrentHashMultiset, iterable);
        return concurrentHashMultiset;
    }

    @Beta
    public static ConcurrentHashMultiset create(MapMaker mapMaker) {
        return new ConcurrentHashMultiset(mapMaker.makeMap());
    }

    @VisibleForTesting
    ConcurrentHashMultiset(ConcurrentMap concurrentMap) {
        Preconditions.checkArgument(concurrentMap.isEmpty());
        this.countMap = concurrentMap;
    }

    @Override
    public int count(@Nullable Object object) {
        AtomicInteger atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, object);
        if (atomicInteger == null) {
            return 0;
        }
        int n2 = atomicInteger.get();
        return n2;
    }

    @Override
    public int size() {
        long l2 = 0;
        Iterator iterator = this.countMap.values().iterator();
        while (iterator.hasNext()) {
            AtomicInteger atomicInteger = (AtomicInteger)iterator.next();
            l2 += (long)atomicInteger.get();
        }
        return Ints.saturatedCast(l2);
    }

    @Override
    public Object[] toArray() {
        return this.snapshot().toArray();
    }

    public Object[] toArray(Object[] arrobject) {
        return this.snapshot().toArray(arrobject);
    }

    private List snapshot() {
        ArrayList arrayList = Lists.newArrayListWithExpectedSize(this.size());
        Iterator iterator = this.entrySet().iterator();
        block0 : while (iterator.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
            Object object = multiset$Entry.getElement();
            int n2 = multiset$Entry.getCount();
            do {
                if (n2 <= 0) continue block0;
                arrayList.add(object);
                --n2;
            } while (true);
            break;
        }
        return arrayList;
    }

    @Override
    public int add(Object object, int n2) {
        AtomicInteger atomicInteger;
        Object object2;
        Preconditions.checkNotNull(object);
        if (n2 == 0) {
            return this.count(object);
        }
        Preconditions.checkArgument(n2 > 0, "Invalid occurrences: %s", n2);
        do {
            int n3;
            if ((atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, object)) == null && (atomicInteger = this.countMap.putIfAbsent(object, new AtomicInteger(n2))) == null) {
                return 0;
            }
            while ((n3 = atomicInteger.get()) != 0) {
                try {
                    object2 = IntMath.checkedAdd(n3, n2);
                    if (!atomicInteger.compareAndSet(n3, (int)object2)) continue;
                    return n3;
                }
                catch (ArithmeticException var5_6) {
                    throw new IllegalArgumentException(new StringBuilder(65).append("Overflow adding ").append(n2).append(" occurrences to a count of ").append(n3).toString());
                }
            }
            object2 = new AtomicInteger(n2);
            if (this.countMap.putIfAbsent(object, object2) == null) return 0;
        } while (!this.countMap.replace(object, atomicInteger, object2));
        return 0;
    }

    @Override
    public int remove(@Nullable Object object, int n2) {
        int n3;
        int n4;
        if (n2 == 0) {
            return this.count(object);
        }
        Preconditions.checkArgument(n2 > 0, "Invalid occurrences: %s", n2);
        AtomicInteger atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, object);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            if ((n3 = atomicInteger.get()) == 0) return 0;
        } while (!atomicInteger.compareAndSet(n3, n4 = Math.max(0, n3 - n2)));
        if (n4 != 0) return n3;
        this.countMap.remove(object, atomicInteger);
        return n3;
    }

    public boolean removeExactly(@Nullable Object object, int n2) {
        int n3;
        int n4;
        if (n2 == 0) {
            return true;
        }
        Preconditions.checkArgument(n2 > 0, "Invalid occurrences: %s", n2);
        AtomicInteger atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, object);
        if (atomicInteger == null) {
            return false;
        }
        do {
            if ((n3 = atomicInteger.get()) >= n2) continue;
            return false;
        } while (!atomicInteger.compareAndSet(n3, n4 = n3 - n2));
        if (n4 != 0) return true;
        this.countMap.remove(object, atomicInteger);
        return true;
    }

    @Override
    public int setCount(Object object, int n2) {
        AtomicInteger atomicInteger;
        int n3;
        Preconditions.checkNotNull(object);
        CollectPreconditions.checkNonnegative(n2, "count");
        block0 : do {
            if ((atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, object)) == null) {
                if (n2 == 0) {
                    return 0;
                }
                atomicInteger = this.countMap.putIfAbsent(object, new AtomicInteger(n2));
                if (atomicInteger == null) {
                    return 0;
                }
            }
            do {
                if ((n3 = atomicInteger.get()) != 0) continue;
                if (n2 == 0) {
                    return 0;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(n2);
                if (this.countMap.putIfAbsent(object, atomicInteger2) == null) return 0;
                if (!this.countMap.replace(object, atomicInteger, atomicInteger2)) continue block0;
                return 0;
            } while (!atomicInteger.compareAndSet(n3, n2));
            break;
        } while (true);
        if (n2 != 0) return n3;
        this.countMap.remove(object, atomicInteger);
        return n3;
    }

    @Override
    public boolean setCount(Object object, int n2, int n3) {
        Preconditions.checkNotNull(object);
        CollectPreconditions.checkNonnegative(n2, "oldCount");
        CollectPreconditions.checkNonnegative(n3, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, object);
        if (atomicInteger == null) {
            if (n2 != 0) {
                return false;
            }
            if (n3 == 0) {
                return true;
            }
            if (this.countMap.putIfAbsent(object, new AtomicInteger(n3)) != null) return false;
            return true;
        }
        int n4 = atomicInteger.get();
        if (n4 != n2) return false;
        if (n4 != 0) {
            if (!atomicInteger.compareAndSet(n4, n3)) return false;
            if (n3 != 0) return true;
            this.countMap.remove(object, atomicInteger);
            return true;
        }
        if (n3 == 0) {
            this.countMap.remove(object, atomicInteger);
            return true;
        }
        AtomicInteger atomicInteger2 = new AtomicInteger(n3);
        if (this.countMap.putIfAbsent(object, atomicInteger2) == null) return true;
        if (this.countMap.replace(object, atomicInteger, atomicInteger2)) return true;
        return false;
    }

    @Override
    Set createElementSet() {
        Set set = this.countMap.keySet();
        return new ConcurrentHashMultiset$1(this, set);
    }

    @Override
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
        ConcurrentHashMultiset$2 concurrentHashMultiset$2 = new ConcurrentHashMultiset$2(this);
        return new ConcurrentHashMultiset$3(this, concurrentHashMultiset$2);
    }

    @Override
    public void clear() {
        this.countMap.clear();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        ConcurrentMap concurrentMap = (ConcurrentMap)objectInputStream.readObject();
        ConcurrentHashMultiset$FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set((Object)this, concurrentMap);
    }

    static /* synthetic */ ConcurrentMap access$100(ConcurrentHashMultiset concurrentHashMultiset) {
        return concurrentHashMultiset.countMap;
    }
}

