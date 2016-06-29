package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import java.io.*;

class Multimaps$CustomMultimap extends AbstractMapBasedMultimap
{
    transient Supplier factory;
    @GwtIncompatible("java serialization not supported")
    private static final long serialVersionUID = 0L;
    
    Multimaps$CustomMultimap(final Map map, final Supplier supplier) {
        super(map);
        this.factory = (Supplier)Preconditions.checkNotNull(supplier);
    }
    
    protected Collection createCollection() {
        return (Collection)this.factory.get();
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.factory);
        objectOutputStream.writeObject(this.backingMap());
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.factory = (Supplier)objectInputStream.readObject();
        this.setMap((Map)objectInputStream.readObject());
    }
}
