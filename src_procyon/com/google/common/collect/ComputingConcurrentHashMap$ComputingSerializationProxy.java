package com.google.common.collect;

import com.google.common.base.*;
import java.util.concurrent.*;
import java.io.*;

final class ComputingConcurrentHashMap$ComputingSerializationProxy extends MapMakerInternalMap$AbstractSerializationProxy
{
    final Function computingFunction;
    private static final long serialVersionUID = 4L;
    
    ComputingConcurrentHashMap$ComputingSerializationProxy(final MapMakerInternalMap$Strength mapMakerInternalMap$Strength, final MapMakerInternalMap$Strength mapMakerInternalMap$Strength2, final Equivalence equivalence, final Equivalence equivalence2, final long n, final long n2, final int n3, final int n4, final MapMaker$RemovalListener mapMaker$RemovalListener, final ConcurrentMap concurrentMap, final Function computingFunction) {
        super(mapMakerInternalMap$Strength, mapMakerInternalMap$Strength2, equivalence, equivalence2, n, n2, n3, n4, mapMaker$RemovalListener, concurrentMap);
        this.computingFunction = computingFunction;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.writeMapTo(objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.delegate = this.readMapMaker(objectInputStream).makeComputingMap(this.computingFunction);
        this.readEntries(objectInputStream);
    }
    
    Object readResolve() {
        return this.delegate;
    }
}
