/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMaker$RemovalListener;
import com.google.common.collect.MapMakerInternalMap$AbstractSerializationProxy;
import com.google.common.collect.MapMakerInternalMap$Strength;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentMap;

final class MapMakerInternalMap$SerializationProxy
extends MapMakerInternalMap$AbstractSerializationProxy {
    private static final long serialVersionUID = 3;

    MapMakerInternalMap$SerializationProxy(MapMakerInternalMap$Strength mapMakerInternalMap$Strength, MapMakerInternalMap$Strength mapMakerInternalMap$Strength2, Equivalence equivalence, Equivalence equivalence2, long l2, long l3, int n2, int n3, MapMaker$RemovalListener mapMaker$RemovalListener, ConcurrentMap concurrentMap) {
        super(mapMakerInternalMap$Strength, mapMakerInternalMap$Strength2, equivalence, equivalence2, l2, l3, n2, n3, mapMaker$RemovalListener, concurrentMap);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.writeMapTo(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        MapMaker mapMaker = this.readMapMaker(objectInputStream);
        this.delegate = mapMaker.makeMap();
        this.readEntries(objectInputStream);
    }

    private Object readResolve() {
        return this.delegate;
    }
}

