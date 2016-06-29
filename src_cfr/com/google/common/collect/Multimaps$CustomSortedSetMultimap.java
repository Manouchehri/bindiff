/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractSortedSetMultimap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

class Multimaps$CustomSortedSetMultimap
extends AbstractSortedSetMultimap {
    transient Supplier factory;
    transient Comparator valueComparator;
    @GwtIncompatible(value="not needed in emulated source")
    private static final long serialVersionUID = 0;

    Multimaps$CustomSortedSetMultimap(Map map, Supplier supplier) {
        super(map);
        this.factory = (Supplier)Preconditions.checkNotNull(supplier);
        this.valueComparator = ((SortedSet)supplier.get()).comparator();
    }

    @Override
    protected SortedSet createCollection() {
        return (SortedSet)this.factory.get();
    }

    @Override
    public Comparator valueComparator() {
        return this.valueComparator;
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.factory);
        objectOutputStream.writeObject(this.backingMap());
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.factory = (Supplier)objectInputStream.readObject();
        this.valueComparator = ((SortedSet)this.factory.get()).comparator();
        Map map = (Map)objectInputStream.readObject();
        this.setMap(map);
    }
}

