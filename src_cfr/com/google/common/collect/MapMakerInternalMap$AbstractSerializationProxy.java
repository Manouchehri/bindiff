/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.ForwardingConcurrentMap;
import com.google.common.collect.GenericMapMaker;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMaker$RemovalListener;
import com.google.common.collect.MapMakerInternalMap$Strength;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

abstract class MapMakerInternalMap$AbstractSerializationProxy
extends ForwardingConcurrentMap
implements Serializable {
    private static final long serialVersionUID = 3;
    final MapMakerInternalMap$Strength keyStrength;
    final MapMakerInternalMap$Strength valueStrength;
    final Equivalence keyEquivalence;
    final Equivalence valueEquivalence;
    final long expireAfterWriteNanos;
    final long expireAfterAccessNanos;
    final int maximumSize;
    final int concurrencyLevel;
    final MapMaker$RemovalListener removalListener;
    transient ConcurrentMap delegate;

    MapMakerInternalMap$AbstractSerializationProxy(MapMakerInternalMap$Strength mapMakerInternalMap$Strength, MapMakerInternalMap$Strength mapMakerInternalMap$Strength2, Equivalence equivalence, Equivalence equivalence2, long l2, long l3, int n2, int n3, MapMaker$RemovalListener mapMaker$RemovalListener, ConcurrentMap concurrentMap) {
        this.keyStrength = mapMakerInternalMap$Strength;
        this.valueStrength = mapMakerInternalMap$Strength2;
        this.keyEquivalence = equivalence;
        this.valueEquivalence = equivalence2;
        this.expireAfterWriteNanos = l2;
        this.expireAfterAccessNanos = l3;
        this.maximumSize = n2;
        this.concurrencyLevel = n3;
        this.removalListener = mapMaker$RemovalListener;
        this.delegate = concurrentMap;
    }

    @Override
    protected ConcurrentMap delegate() {
        return this.delegate;
    }

    void writeMapTo(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.delegate.size());
        Iterator iterator = this.delegate.entrySet().iterator();
        do {
            if (!iterator.hasNext()) {
                objectOutputStream.writeObject(null);
                return;
            }
            Map.Entry entry = iterator.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        } while (true);
    }

    MapMaker readMapMaker(ObjectInputStream objectInputStream) {
        int n2 = objectInputStream.readInt();
        MapMaker mapMaker = new MapMaker().initialCapacity(n2).setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).concurrencyLevel(this.concurrencyLevel);
        mapMaker.removalListener(this.removalListener);
        if (this.expireAfterWriteNanos > 0) {
            mapMaker.expireAfterWrite(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
        }
        if (this.expireAfterAccessNanos > 0) {
            mapMaker.expireAfterAccess(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
        }
        if (this.maximumSize == -1) return mapMaker;
        mapMaker.maximumSize(this.maximumSize);
        return mapMaker;
    }

    void readEntries(ObjectInputStream objectInputStream) {
        Object object;
        while ((object = objectInputStream.readObject()) != null) {
            Object object2 = objectInputStream.readObject();
            this.delegate.put(object, object2);
        }
        return;
    }
}

