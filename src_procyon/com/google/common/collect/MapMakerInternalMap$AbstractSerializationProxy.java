package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;
import java.io.*;
import java.util.concurrent.*;

abstract class MapMakerInternalMap$AbstractSerializationProxy extends ForwardingConcurrentMap implements Serializable
{
    private static final long serialVersionUID = 3L;
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
    
    MapMakerInternalMap$AbstractSerializationProxy(final MapMakerInternalMap$Strength keyStrength, final MapMakerInternalMap$Strength valueStrength, final Equivalence keyEquivalence, final Equivalence valueEquivalence, final long expireAfterWriteNanos, final long expireAfterAccessNanos, final int maximumSize, final int concurrencyLevel, final MapMaker$RemovalListener removalListener, final ConcurrentMap delegate) {
        this.keyStrength = keyStrength;
        this.valueStrength = valueStrength;
        this.keyEquivalence = keyEquivalence;
        this.valueEquivalence = valueEquivalence;
        this.expireAfterWriteNanos = expireAfterWriteNanos;
        this.expireAfterAccessNanos = expireAfterAccessNanos;
        this.maximumSize = maximumSize;
        this.concurrencyLevel = concurrencyLevel;
        this.removalListener = removalListener;
        this.delegate = delegate;
    }
    
    @Override
    protected ConcurrentMap delegate() {
        return this.delegate;
    }
    
    void writeMapTo(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.delegate.size());
        for (final Map.Entry<Object, V> entry : this.delegate.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
        objectOutputStream.writeObject(null);
    }
    
    MapMaker readMapMaker(final ObjectInputStream objectInputStream) {
        final MapMaker concurrencyLevel = new MapMaker().initialCapacity(objectInputStream.readInt()).setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).concurrencyLevel(this.concurrencyLevel);
        concurrencyLevel.removalListener(this.removalListener);
        if (this.expireAfterWriteNanos > 0L) {
            concurrencyLevel.expireAfterWrite(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
        }
        if (this.expireAfterAccessNanos > 0L) {
            concurrencyLevel.expireAfterAccess(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
        }
        if (this.maximumSize != -1) {
            concurrencyLevel.maximumSize(this.maximumSize);
        }
        return concurrencyLevel;
    }
    
    void readEntries(final ObjectInputStream objectInputStream) {
        while (true) {
            final Object object = objectInputStream.readObject();
            if (object == null) {
                break;
            }
            this.delegate.put(object, objectInputStream.readObject());
        }
    }
}
