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
import com.google.common.collect.AbstractListMultimap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public final class ArrayListMultimap
extends AbstractListMultimap {
    private static final int DEFAULT_VALUES_PER_KEY = 3;
    @VisibleForTesting
    transient int expectedValuesPerKey;
    @GwtIncompatible(value="Not needed in emulated source.")
    private static final long serialVersionUID = 0;

    public static ArrayListMultimap create() {
        return new ArrayListMultimap();
    }

    public static ArrayListMultimap create(int n2, int n3) {
        return new ArrayListMultimap(n2, n3);
    }

    public static ArrayListMultimap create(Multimap multimap) {
        return new ArrayListMultimap(multimap);
    }

    private ArrayListMultimap() {
        super(new HashMap());
        this.expectedValuesPerKey = 3;
    }

    private ArrayListMultimap(int n2, int n3) {
        super(Maps.newHashMapWithExpectedSize(n2));
        CollectPreconditions.checkNonnegative(n3, "expectedValuesPerKey");
        this.expectedValuesPerKey = n3;
    }

    private ArrayListMultimap(Multimap multimap) {
        this(multimap.keySet().size(), multimap instanceof ArrayListMultimap ? ((ArrayListMultimap)multimap).expectedValuesPerKey : 3);
        this.putAll(multimap);
    }

    @Override
    List createCollection() {
        return new ArrayList(this.expectedValuesPerKey);
    }

    public void trimToSize() {
        Iterator iterator = this.backingMap().values().iterator();
        while (iterator.hasNext()) {
            Collection collection = (Collection)iterator.next();
            ArrayList arrayList = (ArrayList)collection;
            arrayList.trimToSize();
        }
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultimap(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 3;
        int n2 = Serialization.readCount(objectInputStream);
        HashMap hashMap = Maps.newHashMap();
        this.setMap(hashMap);
        Serialization.populateMultimap(this, objectInputStream, n2);
    }
}

