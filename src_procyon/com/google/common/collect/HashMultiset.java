package com.google.common.collect;

import com.google.common.annotations.*;
import java.io.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
public final class HashMultiset extends AbstractMapBasedMultiset
{
    @GwtIncompatible("Not needed in emulated source.")
    private static final long serialVersionUID = 0L;
    
    public static HashMultiset create() {
        return new HashMultiset();
    }
    
    public static HashMultiset create(final int n) {
        return new HashMultiset(n);
    }
    
    public static HashMultiset create(final Iterable iterable) {
        final HashMultiset create = create(Multisets.inferDistinctElements(iterable));
        Iterables.addAll(create, iterable);
        return create;
    }
    
    private HashMultiset() {
        super(new HashMap());
    }
    
    private HashMultiset(final int n) {
        super(Maps.newHashMapWithExpectedSize(n));
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        final int count = Serialization.readCount(objectInputStream);
        this.setBackingMap(Maps.newHashMap());
        Serialization.populateMultiset(this, objectInputStream, count);
    }
}
