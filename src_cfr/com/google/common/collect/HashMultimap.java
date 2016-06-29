/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractSetMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import com.google.common.collect.Sets;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public final class HashMultimap
extends AbstractSetMultimap {
    private static final int DEFAULT_VALUES_PER_KEY = 2;
    @VisibleForTesting
    transient int expectedValuesPerKey = 2;
    @GwtIncompatible(value="Not needed in emulated source")
    private static final long serialVersionUID = 0;

    public static HashMultimap create() {
        return new HashMultimap();
    }

    public static HashMultimap create(int n2, int n3) {
        return new HashMultimap(n2, n3);
    }

    public static HashMultimap create(Multimap multimap) {
        return new HashMultimap(multimap);
    }

    private HashMultimap() {
        super(new HashMap());
    }

    private HashMultimap(int n2, int n3) {
        super(Maps.newHashMapWithExpectedSize(n2));
        Preconditions.checkArgument(n3 >= 0);
        this.expectedValuesPerKey = n3;
    }

    private HashMultimap(Multimap multimap) {
        super(Maps.newHashMapWithExpectedSize(multimap.keySet().size()));
        this.putAll(multimap);
    }

    @Override
    Set createCollection() {
        return Sets.newHashSetWithExpectedSize(this.expectedValuesPerKey);
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultimap(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 2;
        int n2 = Serialization.readCount(objectInputStream);
        HashMap hashMap = Maps.newHashMap();
        this.setMap(hashMap);
        Serialization.populateMultimap(this, objectInputStream, n2);
    }
}

