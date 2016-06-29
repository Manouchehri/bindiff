package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.io.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
public final class HashMultimap extends AbstractSetMultimap
{
    private static final int DEFAULT_VALUES_PER_KEY = 2;
    @VisibleForTesting
    transient int expectedValuesPerKey;
    @GwtIncompatible("Not needed in emulated source")
    private static final long serialVersionUID = 0L;
    
    public static HashMultimap create() {
        return new HashMultimap();
    }
    
    public static HashMultimap create(final int n, final int n2) {
        return new HashMultimap(n, n2);
    }
    
    public static HashMultimap create(final Multimap multimap) {
        return new HashMultimap(multimap);
    }
    
    private HashMultimap() {
        super(new HashMap());
        this.expectedValuesPerKey = 2;
    }
    
    private HashMultimap(final int n, final int expectedValuesPerKey) {
        super(Maps.newHashMapWithExpectedSize(n));
        this.expectedValuesPerKey = 2;
        Preconditions.checkArgument(expectedValuesPerKey >= 0);
        this.expectedValuesPerKey = expectedValuesPerKey;
    }
    
    private HashMultimap(final Multimap multimap) {
        super(Maps.newHashMapWithExpectedSize(multimap.keySet().size()));
        this.expectedValuesPerKey = 2;
        this.putAll(multimap);
    }
    
    @Override
    Set createCollection() {
        return Sets.newHashSetWithExpectedSize(this.expectedValuesPerKey);
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultimap(this, objectOutputStream);
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 2;
        final int count = Serialization.readCount(objectInputStream);
        this.setMap(Maps.newHashMap());
        Serialization.populateMultimap(this, objectInputStream, count);
    }
}
