/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractSetMultimap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class Multimaps$CustomSetMultimap
extends AbstractSetMultimap {
    transient Supplier factory;
    @GwtIncompatible(value="not needed in emulated source")
    private static final long serialVersionUID = 0;

    Multimaps$CustomSetMultimap(Map map, Supplier supplier) {
        super(map);
        this.factory = (Supplier)Preconditions.checkNotNull(supplier);
    }

    @Override
    protected Set createCollection() {
        return (Set)this.factory.get();
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
        Map map = (Map)objectInputStream.readObject();
        this.setMap(map);
    }
}

