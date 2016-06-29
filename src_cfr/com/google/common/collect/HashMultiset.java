/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Multisets;
import com.google.common.collect.Serialization;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public final class HashMultiset
extends AbstractMapBasedMultiset {
    @GwtIncompatible(value="Not needed in emulated source.")
    private static final long serialVersionUID = 0;

    public static HashMultiset create() {
        return new HashMultiset();
    }

    public static HashMultiset create(int n2) {
        return new HashMultiset(n2);
    }

    public static HashMultiset create(Iterable iterable) {
        HashMultiset hashMultiset = HashMultiset.create(Multisets.inferDistinctElements(iterable));
        Iterables.addAll(hashMultiset, iterable);
        return hashMultiset;
    }

    private HashMultiset() {
        super(new HashMap());
    }

    private HashMultiset(int n2) {
        super(Maps.newHashMapWithExpectedSize(n2));
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n2 = Serialization.readCount(objectInputStream);
        this.setBackingMap(Maps.newHashMap());
        Serialization.populateMultiset(this, objectInputStream, n2);
    }
}

