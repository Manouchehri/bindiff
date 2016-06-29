/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.AtomicLongMap$1;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible
public final class AtomicLongMap {
    private final ConcurrentHashMap map;
    private transient Map asMap;

    private AtomicLongMap(ConcurrentHashMap concurrentHashMap) {
        this.map = (ConcurrentHashMap)Preconditions.checkNotNull(concurrentHashMap);
    }

    public static AtomicLongMap create() {
        return new AtomicLongMap(new ConcurrentHashMap());
    }

    public static AtomicLongMap create(Map map) {
        AtomicLongMap atomicLongMap = AtomicLongMap.create();
        atomicLongMap.putAll(map);
        return atomicLongMap;
    }

    public long get(Object object) {
        AtomicLong atomicLong = (AtomicLong)this.map.get(object);
        if (atomicLong == null) {
            return 0;
        }
        long l2 = atomicLong.get();
        return l2;
    }

    public long incrementAndGet(Object object) {
        return this.addAndGet(object, 1);
    }

    public long decrementAndGet(Object object) {
        return this.addAndGet(object, -1);
    }

    public long addAndGet(Object object, long l2) {
        long l3;
        block0 : do {
            long l4;
            AtomicLong atomicLong;
            if ((atomicLong = (AtomicLong)this.map.get(object)) == null && (atomicLong = this.map.putIfAbsent(object, new AtomicLong(l2))) == null) {
                return l2;
            }
            do {
                if ((l4 = atomicLong.get()) != 0) continue;
                if (!this.map.replace(object, atomicLong, new AtomicLong(l2))) continue block0;
                return l2;
            } while (!atomicLong.compareAndSet(l4, l3 = l4 + l2));
            break;
        } while (true);
        return l3;
    }

    public long getAndIncrement(Object object) {
        return this.getAndAdd(object, 1);
    }

    public long getAndDecrement(Object object) {
        return this.getAndAdd(object, -1);
    }

    public long getAndAdd(Object object, long l2) {
        long l3;
        block0 : do {
            long l4;
            AtomicLong atomicLong;
            if ((atomicLong = (AtomicLong)this.map.get(object)) == null && (atomicLong = this.map.putIfAbsent(object, new AtomicLong(l2))) == null) {
                return 0;
            }
            do {
                if ((l3 = atomicLong.get()) != 0) continue;
                if (!this.map.replace(object, atomicLong, new AtomicLong(l2))) continue block0;
                return 0;
            } while (!atomicLong.compareAndSet(l3, l4 = l3 + l2));
            break;
        } while (true);
        return l3;
    }

    public long put(Object object, long l2) {
        long l3;
        block0 : do {
            AtomicLong atomicLong;
            if ((atomicLong = (AtomicLong)this.map.get(object)) == null && (atomicLong = this.map.putIfAbsent(object, new AtomicLong(l2))) == null) {
                return 0;
            }
            do {
                if ((l3 = atomicLong.get()) != 0) continue;
                if (!this.map.replace(object, atomicLong, new AtomicLong(l2))) continue block0;
                return 0;
            } while (!atomicLong.compareAndSet(l3, l2));
            break;
        } while (true);
        return l3;
    }

    public void putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            this.put(entry.getKey(), (Long)entry.getValue());
        }
    }

    public long remove(Object object) {
        long l2;
        AtomicLong atomicLong = (AtomicLong)this.map.get(object);
        if (atomicLong == null) {
            return 0;
        }
        while ((l2 = atomicLong.get()) != 0 && !atomicLong.compareAndSet(l2, 0)) {
        }
        this.map.remove(object, atomicLong);
        return l2;
    }

    public void removeAllZeros() {
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            AtomicLong atomicLong = (AtomicLong)entry.getValue();
            if (atomicLong == null || atomicLong.get() != 0) continue;
            iterator.remove();
        }
    }

    public long sum() {
        long l2 = 0;
        Iterator iterator = this.map.values().iterator();
        while (iterator.hasNext()) {
            AtomicLong atomicLong = (AtomicLong)iterator.next();
            l2 += atomicLong.get();
        }
        return l2;
    }

    public Map asMap() {
        Map map;
        Map map2 = this.asMap;
        if (map2 == null) {
            map = this.asMap = this.createAsMap();
            return map;
        }
        map = map2;
        return map;
    }

    private Map createAsMap() {
        return Collections.unmodifiableMap(Maps.transformValues(this.map, (Function)new AtomicLongMap$1(this)));
    }

    public boolean containsKey(Object object) {
        return this.map.containsKey(object);
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }

    long putIfAbsent(Object object, long l2) {
        AtomicLong atomicLong;
        do {
            if ((atomicLong = (AtomicLong)this.map.get(object)) == null && (atomicLong = this.map.putIfAbsent(object, new AtomicLong(l2))) == null) {
                return 0;
            }
            long l3 = atomicLong.get();
            if (l3 != 0) return l3;
        } while (!this.map.replace(object, atomicLong, new AtomicLong(l2)));
        return 0;
    }

    boolean replace(Object object, long l2, long l3) {
        if (l2 == 0) {
            if (this.putIfAbsent(object, l3) != 0) return false;
            return true;
        }
        AtomicLong atomicLong = (AtomicLong)this.map.get(object);
        if (atomicLong == null) {
            return false;
        }
        boolean bl2 = atomicLong.compareAndSet(l2, l3);
        return bl2;
    }

    boolean remove(Object object, long l2) {
        AtomicLong atomicLong = (AtomicLong)this.map.get(object);
        if (atomicLong == null) {
            return false;
        }
        long l3 = atomicLong.get();
        if (l3 != l2) {
            return false;
        }
        if (l3 != 0) {
            if (!atomicLong.compareAndSet(l3, 0)) return false;
        }
        this.map.remove(object, atomicLong);
        return true;
    }
}

