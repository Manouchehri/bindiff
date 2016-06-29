package com.google.common.collect;

import com.google.common.base.*;
import java.util.concurrent.*;
import java.io.*;

final class MapMakerInternalMap$SerializationProxy extends MapMakerInternalMap$AbstractSerializationProxy
{
    private static final long serialVersionUID = 3L;
    
    MapMakerInternalMap$SerializationProxy(final MapMakerInternalMap$Strength mapMakerInternalMap$Strength, final MapMakerInternalMap$Strength mapMakerInternalMap$Strength2, final Equivalence equivalence, final Equivalence equivalence2, final long n, final long n2, final int n3, final int n4, final MapMaker$RemovalListener mapMaker$RemovalListener, final ConcurrentMap concurrentMap) {
        super(mapMakerInternalMap$Strength, mapMakerInternalMap$Strength2, equivalence, equivalence2, n, n2, n3, n4, mapMaker$RemovalListener, concurrentMap);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.writeMapTo(objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.delegate = this.readMapMaker(objectInputStream).makeMap();
        this.readEntries(objectInputStream);
    }
    
    private Object readResolve() {
        return this.delegate;
    }
}
