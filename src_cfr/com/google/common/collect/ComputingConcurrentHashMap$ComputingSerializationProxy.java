/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMaker$RemovalListener;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$AbstractSerializationProxy;
import com.google.common.collect.MapMakerInternalMap$Strength;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentMap;

final class ComputingConcurrentHashMap$ComputingSerializationProxy
extends MapMakerInternalMap$AbstractSerializationProxy {
    final Function computingFunction;
    private static final long serialVersionUID = 4;

    ComputingConcurrentHashMap$ComputingSerializationProxy(MapMakerInternalMap.Strength strength, MapMakerInternalMap.Strength strength2, Equivalence equivalence, Equivalence equivalence2, long l2, long l3, int n2, int n3, MapMaker.RemovalListener removalListener, ConcurrentMap concurrentMap, Function function) {
        super(strength, strength2, equivalence, equivalence2, l2, l3, n2, n3, removalListener, concurrentMap);
        this.computingFunction = function;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.writeMapTo(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        MapMaker mapMaker = this.readMapMaker(objectInputStream);
        this.delegate = mapMaker.makeComputingMap(this.computingFunction);
        this.readEntries(objectInputStream);
    }

    Object readResolve() {
        return this.delegate;
    }
}

