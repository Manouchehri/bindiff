package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.io.*;
import java.util.*;

class Multimaps$CustomSortedSetMultimap extends AbstractSortedSetMultimap
{
    transient Supplier factory;
    transient Comparator valueComparator;
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0L;
    
    Multimaps$CustomSortedSetMultimap(final Map map, final Supplier supplier) {
        super(map);
        this.factory = (Supplier)Preconditions.checkNotNull(supplier);
        this.valueComparator = ((SortedSet)supplier.get()).comparator();
    }
    
    protected SortedSet createCollection() {
        return (SortedSet)this.factory.get();
    }
    
    @Override
    public Comparator valueComparator() {
        return this.valueComparator;
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
        this.valueComparator = ((SortedSet)this.factory.get()).comparator();
        this.setMap((Map)objectInputStream.readObject());
    }
}
